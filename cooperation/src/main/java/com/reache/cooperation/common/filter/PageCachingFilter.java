/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/reache/cooperation">Cooperation</a> All rights reserved.
 */
package com.reache.cooperation.common.filter;

import com.reache.cooperation.common.utils.CacheUtils;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.constructs.web.filter.SimplePageCachingFilter;

/**
 * 页面高速缓存过滤器
 * @author ThinkGem
 * @version 2013-8-5
 */
public class PageCachingFilter extends SimplePageCachingFilter {

	@Override
	protected CacheManager getCacheManager() {
		return CacheUtils.getCacheManager();
	}
	
}
