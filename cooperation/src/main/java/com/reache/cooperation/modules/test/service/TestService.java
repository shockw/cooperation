/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/reache/cooperation">Cooperation</a> All rights reserved.
 */
package com.reache.cooperation.modules.test.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reache.cooperation.common.service.CrudService;
import com.reache.cooperation.modules.test.entity.Test;
import com.reache.cooperation.modules.test.dao.TestDao;

/**
 * 测试Service
 * @author ThinkGem
 * @version 2013-10-17
 */
@Service
@Transactional(readOnly = true)
public class TestService extends CrudService<TestDao, Test> {

}
