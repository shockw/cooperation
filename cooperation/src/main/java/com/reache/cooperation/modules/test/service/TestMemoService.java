/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/reache/cooperation">cooperation</a> All rights reserved.
 */
package com.reache.cooperation.modules.test.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reache.cooperation.common.persistence.Page;
import com.reache.cooperation.common.service.CrudService;
import com.reache.cooperation.modules.test.entity.TestMemo;
import com.reache.cooperation.modules.test.dao.TestMemoDao;

/**
 * 用户备忘录功能Service
 * @author shock
 * @version 2017-09-26
 */
@Service
@Transactional(readOnly = true)
public class TestMemoService extends CrudService<TestMemoDao, TestMemo> {

	public TestMemo get(String id) {
		return super.get(id);
	}
	
	public List<TestMemo> findList(TestMemo testMemo) {
		return super.findList(testMemo);
	}
	
	public Page<TestMemo> findPage(Page<TestMemo> page, TestMemo testMemo) {
		return super.findPage(page, testMemo);
	}
	
	@Transactional(readOnly = false)
	public void save(TestMemo testMemo) {
		super.save(testMemo);
	}
	
	@Transactional(readOnly = false)
	public void delete(TestMemo testMemo) {
		super.delete(testMemo);
	}
	
}