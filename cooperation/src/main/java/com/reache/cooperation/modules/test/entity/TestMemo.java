/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/reache/cooperation">cooperation</a> All rights reserved.
 */
package com.reache.cooperation.modules.test.entity;

import org.hibernate.validator.constraints.Length;

import com.reache.cooperation.common.persistence.DataEntity;

/**
 * 用户备忘录功能Entity
 * @author shock
 * @version 2017-09-26
 */
public class TestMemo extends DataEntity<TestMemo> {
	
	private static final long serialVersionUID = 1L;
	private String content;		// 记录内容
	
	public TestMemo() {
		super();
	}

	public TestMemo(String id){
		super(id);
	}

	@Length(min=1, max=255, message="记录内容长度必须介于 1 和 255 之间")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}