package org.tiantao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiantao.bean.User;
import org.tiantao.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public User selectUserById(Integer userId) {
		return userDao.selectUserById(userId);
	}
}
