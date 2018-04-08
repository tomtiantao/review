package org.tiantao.dao;

import java.util.List;
import java.util.Map;

import org.tiantao.annotation.MapperAnnotation;
import org.tiantao.bean.Team;

@MapperAnnotation
public interface TeamDao {
	void saveTeam(Team team);

	void updateTeam(Team team);

	void deleteTeamById(Integer id);

	List<Team> findAllTeams(Map<String, Object> map);

	List<Team> findTeam(String name);

	int countTeams();

	Team getOneTeamById(Integer id);
}
