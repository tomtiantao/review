package org.tiantao.bean;

import java.io.Serializable;

/**
 * @ClassName: Review
 * @Description: 代码评审
 * @author: tiant
 * @date: 2018年3月28日 上午10:15:15
 */
public class Review implements Serializable {
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	// 编号
	private Integer id;
	// 项目名称
	private String projectName;
	// 主题
	private String title;
	// 主持人
	private String master;
	// 组别
	private String team;
	// 周数
	private String week;
	// 日期
	private String date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", projectName=" + projectName + ", title=" + title + ", master=" + master + ", team=" + team + ", week=" + week + ", date=" + date + "]";
	}

}
