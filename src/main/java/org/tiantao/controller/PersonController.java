package org.tiantao.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tiantao.bean.Person;
import org.tiantao.service.PersonService;

import com.mysql.jdbc.StringUtils;

@Controller
@RequestMapping("/person")
public class PersonController {
	private static final Logger logger = Logger.getLogger(PersonController.class);
	// 默认首页 10个
	private static final int PAGESIZE = 10;
	private static final int PAGENUM = 1;
	@Resource
	private PersonService personService;

	@RequestMapping(value = "/savePerson.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> savePerson(Person person) {
		logger.info("保存person:" + person);
		// 根据ID判断是否存在，存在即更新，不存在即保存
		if (person != null) {
			// 更新
			if (person.getId() != null) {
				personService.updatePerson(person);
			} else {// 保存
				personService.savePerson(person);
			}
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("errorcode", "200");
		map.put("msg", "success");
		return map;
	}

	@RequestMapping(value = "/deletePerson.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> deletePerson(String ids) {
		logger.info("ids:" + ids);
		if (!StringUtils.isNullOrEmpty(ids)) {
			String[] is = ids.split(",");
			for (String id : is) {
				personService.deletePersonById(Integer.parseInt(id));
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("errorcode", "200");
		map.put("msg", "success");
		return map;
	}

	@RequestMapping(value = "/listPerson.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listPerson(@RequestParam(value = "page") Integer pageNum, @RequestParam(value = "limit") Integer pageSize,
			String keyword) throws IOException {
		if (pageNum == null) {
			pageNum = PAGENUM;
		}
		if (pageSize == null) {
			pageSize = PAGESIZE;
		}
		if (!StringUtils.isNullOrEmpty(keyword)) {
			keyword = new String(keyword.getBytes("ISO-8859-1"), "UTF-8");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", personService.findAllPersons(pageNum, pageSize, keyword));
		int countReviews = personService.countPersons();
		map.put("totalPage", countReviews % pageSize == 0 ? countReviews / pageSize : countReviews / pageSize + 1);
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("count", countReviews);
		map.put("code", 0);
		map.put("msg", "success");
		return map;
	}

	@RequestMapping(value = "/fingOnePerson.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> fingOnePerson(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", personService.findOnePersonById(id));
		map.put("errorcode", "200");
		map.put("msg", "success");
		return map;
	}

	@RequestMapping(value = "/findPerson.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findPerson(String person) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		if (!StringUtils.isNullOrEmpty(person)) {
			person = new String(person.getBytes("ISO-8859-1"), "UTF-8");
		}
		map.put("data", personService.findPerson(person));
		map.put("errorcode", "200");
		map.put("msg", "success");
		return map;
	}

	@RequestMapping(value = "/findPersonByTeam.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findPersonByTeam(String team) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		if (!StringUtils.isNullOrEmpty(team)) {
			team = new String(team.getBytes("ISO-8859-1"), "UTF-8");
		}
		map.put("data", personService.findPersonByTeam(team));
		map.put("errorcode", "200");
		map.put("msg", "success");
		return map;
	}

}
