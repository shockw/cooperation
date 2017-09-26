/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/reache/cooperation">Cooperation</a> All rights reserved.
 */
package com.reache.cooperation.modules.cms.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reache.cooperation.common.persistence.Page;
import com.reache.cooperation.common.service.CrudService;
import com.reache.cooperation.modules.cms.dao.ArticleDataDao;
import com.reache.cooperation.modules.cms.entity.Article;
import com.reache.cooperation.modules.cms.entity.ArticleData;

/**
 * 站点Service
 * @author ThinkGem
 * @version 2013-01-15
 */
@Service
@Transactional(readOnly = true)
public class ArticleDataService extends CrudService<ArticleDataDao, ArticleData> {

}
