package org.tiantao.service;

import java.util.List;

import org.tiantao.bean.Person;

public interface PersonService {

	/**
	 * @Description: 保存评审
	 * @param review
	 * @return: void
	 * @author: tiant
	 * @date 2018年3月31日 下午2:11:22
	 */
	void savePerson(Person person);

	/**
	 * @Description: 更新评审
	 * @param review
	 * @return: void
	 * @author: tiant
	 * @date 2018年4月2日 下午1:49:56
	 */
	void updatePerson(Person person);

	/**
	 * @Description: 查询所有评审
	 * @return: List<Review>
	 * @author: tiant
	 * @date 2018年3月31日 下午3:00:21
	 */
	List<Person> findAllPersons(int pageNum, int pageSize, String keyword);


	/**
	 * @Description: 统计评审条数
	 * @return: int
	 * @author: tiant
	 * @date 2018年4月2日 下午3:16:10
	 */
	int countPersons();

	/**
	 * @Description: 根据ID删除评审
	 * @param id
	 * @return: void
	 * @author: tiant
	 * @date 2018年4月2日 下午2:36:25
	 */
	void deletePersonById(Integer id);

	/**
	 * @Description: 根据ID查询评审
	 * @param id
	 * @return: Review
	 * @author: tiant
	 * @date 2018年4月2日 上午10:53:33
	 */
	Person findOnePersonById(Integer id);

	/**
	 * @Description: 根据项目名称查询评审
	 * @param projectName
	 * @return: List<Review>
	 * @author: tiant
	 * @date 2018年4月3日 下午3:47:30
	 */
	List<Person> findPerson(String person);

	List<Person> findPersonByTeam(String team);

	Person findOnePersonByName(String name);

}
