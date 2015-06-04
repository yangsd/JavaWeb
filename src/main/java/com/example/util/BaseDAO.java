package com.example.util;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author sdyang
 * @date 2015年6月3日 下午5:32:36
 */
public class BaseDAO {

	/**
	 * 默认按照类型进行注入,必须注入值，不能为null,
	 */
	@Autowired(required = true)
	public SqlSession sqlSession;

	/*
	 * public SqlSession getSqlSession() { return sqlSession; }
	 * 
	 * @Resource(name = "sqlSession") public void setSqlSession(SqlSession
	 * sqlSession) { this.sqlSession = sqlSession; }
	 */

}
