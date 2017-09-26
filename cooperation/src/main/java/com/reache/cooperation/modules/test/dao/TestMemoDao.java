/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/cooperation">cooperation</a> All rights reserved.
 */
package com.reache.cooperation.modules.test.dao;

import com.reache.cooperation.common.persistence.CrudDao;
import com.reache.cooperation.common.persistence.annotation.MyBatisDao;
import com.reache.cooperation.modules.test.entity.TestMemo;

/**
 * 用户备忘录功能DAO接口
 * @author shock
 * @version 2017-09-26
 */
@MyBatisDao
public interface TestMemoDao extends CrudDao<TestMemo> {
	
}