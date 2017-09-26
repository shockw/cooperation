/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/reache/cooperation">Cooperation</a> All rights reserved.
 */
package com.reache.cooperation.modules.sys.dao;

import com.reache.cooperation.common.persistence.TreeDao;
import com.reache.cooperation.common.persistence.annotation.MyBatisDao;
import com.reache.cooperation.modules.sys.entity.Office;

/**
 * 机构DAO接口
 * @author ThinkGem
 * @version 2014-05-16
 */
@MyBatisDao
public interface OfficeDao extends TreeDao<Office> {
	
}
