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
import org.tiantao.bean.Team;
import org.tiantao.service.TeamService;

import com.mysql.jdbc.StringUtils;

@Controller
@RequestMapping("/team")
public class TeamController {
	private static final Logger logger = Logger.getLogger(TeamController.class);
	// 默认首页 10个
	private static final int PAGESIZE = 10;
	private static final int PAGENUM = 1;
	@Resource
	private TeamService teamService;

	@RequestMapping(value = "/saveTeam.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> saveTeam(Team team) {
		logger.info("保存team:" + team);
		// 根据ID判断是否存在，存在即更新，不存在即保存
		if (team != null) {
			// 更新
			if (team.getId() != null) {
				teamService.updateTeam(team);
			} else {// 保存
				teamService.saveTeam(team);
			}
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("errorcode", "200");
		map.put("msg", "success");
		return map;
	}

	@RequestMapping(value = "/deleteTeam.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> deleteTeam(Integer id) {
		teamService.deleteTeamById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("errorcode", "200");
		map.put("msg", "success");
		return map;
	}

	@RequestMapping(value = "/listTeam.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listTeam(@RequestParam(value = "page") Integer pageNum, @RequestParam(value = "limit") Integer pageSize,
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
		map.put("data", teamService.findAllTeams(pageNum, pageSize, keyword));
		int countReviews = teamService.countTeams();
		map.put("totalPage", countReviews % pageSize == 0 ? countReviews / pageSize : countReviews / pageSize + 1);
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("count", countReviews);
		map.put("code", 0);
		map.put("msg", "success");
		return map;
	}

	@RequestMapping(value = "/fingOneTeam.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> fingOneTeam(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", teamService.findOneTeamById(id));
		map.put("errorcode", "200");
		map.put("msg", "success");
		return map;
	}

	@RequestMapping(value = "/findTeam.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findTeam(String team) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		if (!StringUtils.isNullOrEmpty(team)) {
			team = new String(team.getBytes("ISO-8859-1"), "UTF-8");
		}
		map.put("data", teamService.findTeam(team));
		map.put("errorcode", "200");
		map.put("msg", "success");
		return map;
	}

}
