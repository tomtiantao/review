package org.tiantao.dao;

import org.tiantao.annotation.MapperAnnotation;
import org.tiantao.bean.User;

@MapperAnnotation
public interface UserDao {
	public User selectUserById(Integer userId);
}
