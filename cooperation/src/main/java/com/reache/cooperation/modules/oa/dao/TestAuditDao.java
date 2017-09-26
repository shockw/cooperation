/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/reache/cooperation">Cooperation</a> All rights reserved.
 */
package com.reache.cooperation.modules.oa.dao;

import com.reache.cooperation.common.persistence.CrudDao;
import com.reache.cooperation.common.persistence.annotation.MyBatisDao;
import com.reache.cooperation.modules.oa.entity.TestAudit;

/**
 * 审批DAO接口
 * @author reache
 * @version 2014-05-16
 */
@MyBatisDao
public interface TestAuditDao extends CrudDao<TestAudit> {

	public TestAudit getByProcInsId(String procInsId);
	
	public int updateInsId(TestAudit testAudit);
	
	public int updateHrText(TestAudit testAudit);
	
	public int updateLeadText(TestAudit testAudit);
	
	public int updateMainLeadText(TestAudit testAudit);
	
}
