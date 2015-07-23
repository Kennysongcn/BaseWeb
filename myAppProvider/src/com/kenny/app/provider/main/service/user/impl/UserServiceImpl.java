package com.kenny.app.provider.main.service.user.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenny.app.provider.common.bao.BaseDao;
import com.kenny.app.provider.common.util.Pager;
import com.kenny.app.provider.common.util.SystemContext;
import com.kenny.app.provider.main.model.user.User;
import com.kenny.app.provider.main.service.user.IUserService;


@Service
public class UserServiceImpl  implements IUserService {
	@SuppressWarnings("rawtypes")
	@Autowired
	private BaseDao dao;
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(Long userId, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findOne(int userId) {
		try {
			User user=(User) dao.findForObject("UserMapper.findUserById", userId);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		return null;
	}

	@Override
	public User findByUsername(String username) {
		try {
			User user = (User)dao.findForObject("UserMapper.findUserByUserName", username);
			return user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Set<String> findRoles(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> findPermissions(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Pager<User> findPagerAll() {
		int offset=SystemContext.getOffset();
		int size = SystemContext.getSize();
		Map queryMap = new HashMap();
		Pager<User> us =null;
		try {
			queryMap.put("offset", offset);
			queryMap.put("size", size);
			List<User> datas=dao.findForList("UserMapper.findUserList", queryMap);
			us = new Pager<User>();
			us.setDatas(datas);
			us.setOffset(offset);
			us.setSize(size);
			long total = (long) dao.findForObject("UserMapper.totalResult", "");
			us.setTotal(total);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return us;
	}
	

}
