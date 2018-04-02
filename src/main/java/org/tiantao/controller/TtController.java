package org.tiantao.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tiantao.bean.User;

@Controller
@RequestMapping("/tt")
public class TtController {
	private static final Logger logger = Logger.getLogger(TtController.class);
	@RequestMapping(value = "/test98.do", method = RequestMethod.GET)
	@ResponseBody
	public List<User> test98() {
		logger.info("欢迎进入。。。");
		System.out.println("ttt...");
		List<User> users = new ArrayList<User>();
		User user1 = new User();
		user1.setUserId(45);
		user1.setUserEmail("349539@qq.com");
		user1.setUserName("司马昭");
		user1.setUserPassword("999999");
		User user2 = new User();
		user2.setUserId(51);
		user2.setUserEmail("45645@qq.com");
		user2.setUserName("司马懿");
		user2.setUserPassword("1111211");
		User user3 = new User();
		user3.setUserId(21);
		user3.setUserEmail("45645@qq.com");
		user3.setUserName("曹睿");
		user3.setUserPassword("1111211");
		users.add(user1);
		users.add(user2);
		users.add(user3);
		System.out.println(users);
		return users;
	}

	@RequestMapping(value = "/test99.do", method = RequestMethod.POST)
	@ResponseBody
	public List<User> postUser(@RequestBody User user) {
		System.out.println(user);
		List<User> users = new ArrayList<User>();
		User user1 = new User();
		user1.setUserId(45);
		user1.setUserEmail("349539@qq.com");
		user1.setUserName("司马昭");
		user1.setUserPassword("999999");
		User user2 = new User();
		user2.setUserId(51);
		user2.setUserEmail("45645@qq.com");
		user2.setUserName("司马懿");
		user2.setUserPassword("1111211");
		User user3 = new User();
		user3.setUserId(21);
		user3.setUserEmail("45645@qq.com");
		user3.setUserName("曹睿");
		user3.setUserPassword("1111211");
		users.add(user1);
		users.add(user2);
		users.add(user3);
		return users;
	}
}
