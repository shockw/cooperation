/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/reache/cooperation">Cooperation</a> All rights reserved.
 */
package com.reache.cooperation.modules.cms.dao;

import java.util.List;

import com.reache.cooperation.common.persistence.CrudDao;
import com.reache.cooperation.common.persistence.annotation.MyBatisDao;
import com.reache.cooperation.modules.cms.entity.Article;
import com.reache.cooperation.modules.cms.entity.ArticleData;

/**
 * 文章DAO接口
 * @author ThinkGem
 * @version 2013-8-23
 */
@MyBatisDao
public interface ArticleDataDao extends CrudDao<ArticleData> {
	
	public List<ArticleData> findFullText(String parmers);
	
	
}
