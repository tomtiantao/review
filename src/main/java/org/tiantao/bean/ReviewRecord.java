package org.tiantao.bean;

import java.io.Serializable;

/**
 * @ClassName: ReviewRecord
 * @Description: 评审记录
 * @author: tiant
 * @date: 2018年3月28日 上午10:21:03
 */
public class ReviewRecord implements Serializable {
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
	// 所属小组
	private String team;
	// 周次
	private String week;
	// 问题
	private String problem;
	// 类名
	private String className;
	// 行数
	private String line;
	// 提出人
	private String introducer;
	// 修改人
	private String modifier;
	// 提出时间
	private String createDate;
	// 完成时间
	private String finishDate;
	// 截止时间
	private String endDate;
	// 状态 0-未完成 1-已完成
	private String status;

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

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getIntroducer() {
		return introducer;
	}

	public void setIntroducer(String introducer) {
		this.introducer = introducer;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ReviewRecord [id=" + id + ", projectName=" + projectName + ", team=" + team + ", week=" + week + ", problem=" + problem + ", className=" + className + ", line=" + line + ", introducer=" + introducer + ", modifier=" + modifier + ", createDate=" + createDate + ", finishDate=" + finishDate + ", endDate=" + endDate + ", status=" + status + "]";
	}
}
