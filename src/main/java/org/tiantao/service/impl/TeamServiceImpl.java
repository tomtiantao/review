package org.tiantao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiantao.bean.Team;
import org.tiantao.dao.TeamDao;
import org.tiantao.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {
	@Autowired
	private TeamDao teamDao;

	@Override
	public void saveTeam(Team team) {
		teamDao.saveTeam(team);
	}

	@Override
	public List<Team> findAllTeams(int pageNum, int pageSize, String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageSize", pageSize);
		map.put("pageNum", (pageNum - 1) * pageSize);
		map.put("keyword", keyword);
		return teamDao.findAllTeams(map);
	}

	@Override
	public Team findOneTeamById(Integer id) {
		return teamDao.getOneTeamById(id);
	}

	@Override
	public void updateTeam(Team team) {
		teamDao.updateTeam(team);
	}

	@Override
	public void deleteTeamById(Integer id) {
		teamDao.deleteTeamById(id);
	}

	@Override
	public int countTeams() {
		return teamDao.countTeams();
	}

	@Override
	public List<Team> findTeam(String team) {
		return teamDao.findTeam(team);
	}
}
