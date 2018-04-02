package org.tiantao.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tiantao.bean.User;
import org.tiantao.service.UserService;
import org.tiantao.service.UserServiceImpl;

public class UserServiceImplTest {

	private static ApplicationContext ctx = null;

	private static final Logger logger = Logger.getLogger(UserServiceImplTest.class);

	static {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("田涛....");
	}

	// @Before
	// public void setCtx() {
	// ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	// System.out.println("田涛....");
	// }

	@Test
	public void testSelectUserById() {
		UserService userService = ctx.getBean("userServiceImpl", UserServiceImpl.class);
		User user = userService.selectUserById(10);
		logger.debug("查找结果" + user);
	}

}
