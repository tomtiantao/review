package org.tiantao.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.tiantao.annotation.MapperAnnotation;
import org.tiantao.bean.Person;

@MapperAnnotation
public interface PersonDao {
	void savePerson(Person person);

	void updatePerson(Person person);

	void deletePersonById(Integer id);

	List<Person> findAllPersons(Map<String, Object> map);

	List<Person> findPerson(String name);

	List<Person> findPersonByTeam(@Param("team") String team);

	int countPersons();

	Person getOnePersonByName(String name);

	Person getOnePersonById(Integer id);
}
