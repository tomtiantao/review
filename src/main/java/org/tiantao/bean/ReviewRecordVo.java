package org.tiantao.bean;

import java.io.Serializable;

/**
 * @ClassName: ReviewRecord
 * @Description: 评审记录
 * @author: tiant
 * @date: 2018年3月28日 上午10:21:03
 */
public class ReviewRecordVo implements Serializable {
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	private String team;
	// 项目名称
	private String projectName;
	// 主题
	private String title;
	// 问题
	private String problem;
	// 提出人
	private String introducer;
	// 修改人
	private String modifier;
	// 完成日期
	private String finishDate;
	// 状态 0-未完成 1-已完成 2-修改中
	private String status;

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
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

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
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

	public String getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
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
		return "ReviewRecordVo [team=" + team + ", projectName=" + projectName + ", title=" + title + ", problem=" + problem + ", introducer=" + introducer + ", modifier=" + modifier + ", finishDate=" + finishDate + ", status=" + status + "]";
	}

}
