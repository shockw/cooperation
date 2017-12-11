/**
 * There are <a href="https://github.com/reache/cooperation">Cooperation</a> code generation
 */
package com.reache.cooperation.modules.oa.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Maps;
import com.reache.cooperation.common.mapper.JsonMapper;
import com.reache.cooperation.common.persistence.Page;
import com.reache.cooperation.common.web.BaseController;
import com.reache.cooperation.modules.oa.entity.Leave;
import com.reache.cooperation.modules.oa.entity.TestAudit;
import com.reache.cooperation.modules.oa.service.LeaveService;
import com.reache.cooperation.modules.sys.utils.UserUtils;

/**
 * 请假Controller
 * 
 * @author liuj
 * @version 2013-04-05
 */
@Controller
@RequestMapping(value = "${adminPath}/oa/leave")
public class LeaveController extends BaseController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	protected LeaveService leaveService;

	@Autowired
	protected RuntimeService runtimeService;

	@Autowired
	protected TaskService taskService;

	@RequiresPermissions("oa:leave:view")
	@RequestMapping(value = { "form" })
	public String form(Leave leave, Model model) {
		String view = "leaveForm";
		// 查看审批申请单
		if (StringUtils.isNotBlank(leave.getId())) {

			// 环节编号
			String taskDefKey = leave.getAct().getTaskDefKey();
			// 查看工单
						if(leave.getAct().isFinishTask()){
							view = "leaveView";
						}
						// 审核环节
						else if ("deptLeaderAudit".equals(taskDefKey)){
							view = "leaveAudit";
						}
						// 审核环节2
						else if ("hrAudit".equals(taskDefKey)){
							view = "leaveAudit";
						}
						// 审核环节3
						else if ("modifyApply".equals(taskDefKey)){
							view = "leaveForm";
						}
						// 审核环节4
						else if ("reportBack".equals(taskDefKey)){
							view = "leaveAudit";
						}
						// 兑现环节
						else if ("end".equals(taskDefKey)){
							view = "leaveAudit";
						}
		}
		model.addAttribute("leave", leave);
		return "modules/oa/"+view;
	}

	/**
	 * 启动请假流程
	 * 
	 * @param leave
	 */
	@RequiresPermissions("oa:leave:edit")
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(Leave leave, RedirectAttributes redirectAttributes) {
		try {
			Map<String, Object> variables = Maps.newHashMap();
			leaveService.save(leave, variables);
			addMessage(redirectAttributes,
					"流程已启动，流程ID：" + leave.getProcessInstanceId());
		} catch (Exception e) {
			logger.error("启动请假流程失败：", e);
			addMessage(redirectAttributes, "系统内部错误！");
		}
		return "redirect:" + adminPath + "/oa/leave/form";
	}
	
	/**
	 * 工单执行（完成任务）
	 * @param testAudit
	 * @param model
	 * @return
	 */
	@RequiresPermissions("oa:leave:edit")
	@RequestMapping(value = "saveAudit")
	public String saveAudit(Leave leave, Model model) {
		if (StringUtils.isBlank(leave.getAct().getFlag())
				|| StringUtils.isBlank(leave.getAct().getComment())){
			addMessage(model, "请填写审核意见。");
			return form(leave, model);
		}
		leaveService.auditSave(leave);
		return "redirect:" + adminPath + "/act/task/todo/";
	}

	/**
	 * 任务列表
	 * 
	 * @param leave
	 */
	@RequiresPermissions("oa:leave:view")
	@RequestMapping(value = { "list/task", "" })
	public String taskList(HttpSession session, Model model) {
		String userId = UserUtils.getUser().getLoginName();// ObjectUtils.toString(UserUtils.getUser().getId());
		List<Leave> results = leaveService.findTodoTasks(userId);
		model.addAttribute("leaves", results);
		return "modules/oa/leaveTask";
	}

	/**
	 * 读取所有流程
	 * 
	 * @return
	 */
	@RequiresPermissions("oa:leave:view")
	@RequestMapping(value = { "list" })
	public String list(Leave leave, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		Page<Leave> page = leaveService.find(
				new Page<Leave>(request, response), leave);
		model.addAttribute("page", page);
		return "modules/oa/leaveList";
	}

	/**
	 * 读取详细数据
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "detail/{id}")
	@ResponseBody
	public String getLeave(@PathVariable("id") String id) {
		Leave leave = leaveService.get(id);
		return JsonMapper.getInstance().toJson(leave);
	}

	/**
	 * 读取详细数据
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "detail-with-vars/{id}/{taskId}")
	@ResponseBody
	public String getLeaveWithVars(@PathVariable("id") String id,
			@PathVariable("taskId") String taskId) {
		Leave leave = leaveService.get(id);
		Map<String, Object> variables = taskService.getVariables(taskId);
		leave.setVariables(variables);
		return JsonMapper.getInstance().toJson(leave);
	}

}
