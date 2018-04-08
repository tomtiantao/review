package org.tiantao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiantao.bean.Person;
import org.tiantao.dao.PersonDao;
import org.tiantao.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonDao personDao;

	@Override
	public void savePerson(Person person) {
		personDao.savePerson(person);
	}

	@Override
	public List<Person> findAllPersons(int pageNum, int pageSize, String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageSize", pageSize);
		map.put("pageNum", (pageNum - 1) * pageSize);
		map.put("keyword", keyword);
		return personDao.findAllPersons(map);
	}

	@Override
	public Person findOnePersonById(Integer id) {
		return personDao.getOnePersonById(id);
	}

	@Override
	public void updatePerson(Person person) {
		personDao.updatePerson(person);
	}

	@Override
	public void deletePersonById(Integer id) {
		personDao.deletePersonById(id);
	}

	@Override
	public int countPersons() {
		return personDao.countPersons();
	}

	@Override
	public List<Person> findPerson(String person) {
		return personDao.findPerson(person);
	}

	@Override
	public List<Person> findPersonByTeam(String team) {
		return personDao.findPersonByTeam(team);
	}
}
