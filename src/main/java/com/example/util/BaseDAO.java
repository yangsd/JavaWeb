package com.example.util;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author sdyang
 * @date 2015��6��3�� ����5:32:36
 */
public class BaseDAO {

	/**
	 * Ĭ�ϰ������ͽ���ע��,����ע��ֵ������Ϊnull,
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
