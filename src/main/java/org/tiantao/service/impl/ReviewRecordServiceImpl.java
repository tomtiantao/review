package org.tiantao.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.tiantao.bean.ReviewRecord;
import org.tiantao.bean.User;
import org.tiantao.dao.ReviewDao;
import org.tiantao.dao.ReviewRecordDao;
import org.tiantao.service.ReviewRecordService;

@Service
public class ReviewRecordServiceImpl implements ReviewRecordService {
	private static final Logger logger = Logger.getLogger(ReviewRecordServiceImpl.class);
	@Autowired
	private ReviewRecordDao reviewRecordDao;
	@Autowired
	private ReviewDao reviewDao;

	@Override
	public User selectUserById(Integer userId) {
		return reviewRecordDao.selectUserById(userId);
	}

	@Override
	public void saveReviewRecord(ReviewRecord reviewRecord) {
		// 计算周次
		if (reviewRecord != null) {
			if (!StringUtils.isEmpty(reviewRecord.getCreateDate())) {
				reviewRecord.setWeek(this.getWeek(reviewRecord.getCreateDate()));
			}
			// 已修复
			if ("1".equals(reviewRecord.getStatus())) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				reviewRecord.setFinishDate(sdf.format(new Date()));
			}
			reviewRecordDao.saveReviewRecord(reviewRecord);
		}
	}

	private String getWeek(String str) {
		if (!StringUtils.isEmpty(str)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date;
			try {
				date = sdf.parse(str);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				// 第几周
				int week = calendar.get(Calendar.WEEK_OF_YEAR);
				return "" + week;
			} catch (ParseException e) {
				logger.error(e.getMessage(), e);
			}
		}
		return "";
	}

	@Override
	public List<ReviewRecord> findAllReviewRecords(Integer pageNum, Integer pageSize, String keyword, String startDate, String endDate, String team, String projectName, String title) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageSize", pageSize);
		if (pageNum != null && pageSize != null) {
			map.put("pageNum", (pageNum - 1) * pageSize);
		} else {
			map.put("pageNum", null);
		}
		map.put("keyword", keyword);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("team", team);
		map.put("projectName", projectName);
		map.put("title", title);
		return reviewRecordDao.findAllReviewRecords(map);
	}

	@Override
	public List<ReviewRecord> findAllReviewRecordVos(int pageNum, int pageSize, String keyword, String startDate, String endDate, String team, String projectName, String title) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageSize", pageSize);
		map.put("pageNum", (pageNum - 1) * pageSize);
		map.put("keyword", keyword);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("team", team);
		map.put("projectName", projectName);
		map.put("title", title);
		return reviewRecordDao.findAllReviewRecordVos(map);
	}

	@Override
	public ReviewRecord findOneReviewRecordById(Integer id) {
		return reviewRecordDao.getOneReviewRecordById(id);
	}

	@Override
	public void updateReviewRecord(ReviewRecord reviewRecord) {
		// 计算周次
		if (reviewRecord != null) {
			if (!StringUtils.isEmpty(reviewRecord.getCreateDate())) {
				reviewRecord.setWeek(this.getWeek(reviewRecord.getCreateDate()));
			}
			// 已修复
			if ("1".equals(reviewRecord.getStatus())) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				reviewRecord.setFinishDate(sdf.format(new Date()));
			}
			reviewRecordDao.updateReviewRecord(reviewRecord);
		}
	}

	@Override
	public void deleteReviewRecordById(Integer id) {
		reviewRecordDao.deleteReviewRecordById(id);
	}

	@Override
	public int countReviewRecords() {
		return reviewRecordDao.countReviewRecords();
	}

	@Override
	public List<String> findAllProjectName(String teamId) {
		return reviewRecordDao.findAllProjectName(teamId);
	}

	@Override
	public List<String> findProjectCounts(String projectName, String week) {
		return reviewRecordDao.findCreateDate(projectName, week);
	}

	@Override
	public int findCount(String projectName, String status, String week) {
		return reviewRecordDao.counts(projectName, status, week);
	}

}
