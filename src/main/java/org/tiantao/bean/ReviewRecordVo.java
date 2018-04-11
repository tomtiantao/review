package org.tiantao.bean;

import java.io.Serializable;

/**
 * @ClassName: ReviewRecord
 * @Description: 评审记录
 * @author: tiant
 * @date: 2018年3月28日 上午10:21:03
 */
public class ReviewRecordVo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String projectName;
	private String count;
	private String total;
	private String finish;
	private String cent;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getFinish() {
		return finish;
	}

	public void setFinish(String finish) {
		this.finish = finish;
	}

	public String getCent() {
		return cent;
	}

	public void setCent(String cent) {
		this.cent = cent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ReviewRecordVo [projectName=" + projectName + ", count=" + count + ", total=" + total + ", finish=" + finish + ", cent=" + cent + "]";
	}

}
