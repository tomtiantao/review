package org.tiantao.bean;

import java.io.Serializable;

/**
 * @ClassName: Review
 * @Description: 代码评审
 * @author: tiant
 * @date: 2018年3月28日 上午10:15:15
 */
public class Team implements Serializable {
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	// 编号
	private Integer id;
	private String team;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", team=" + team + "]";
	}

}
