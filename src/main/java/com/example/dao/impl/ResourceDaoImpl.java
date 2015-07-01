package com.example.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.constants.RoleConstant;
import com.example.constants.UrlConstant;
import com.example.dao.ResourceDao;

/**
 * 
 * @author sdyang
 * @date 2015年6月29日 下午5:26:17
 */
@Transactional
@Service("ResourceDao")
public class ResourceDaoImpl implements ResourceDao {

	public Map<String, String> getResources() {
		Map<String, String> map = new HashMap<String, String>();
		map.put(UrlConstant.ADMIN, RoleConstant.ROLE_ADMIN);
		map.put(UrlConstant.HOME, RoleConstant.ROLE_USER);
		return map;
	}
}
