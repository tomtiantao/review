package org.tiantao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiantao.bean.ReviewRecord;
import org.tiantao.bean.User;
import org.tiantao.dao.ReviewRecordDao;
import org.tiantao.service.ReviewRecordService;

@Service
public class ReviewRecordServiceImpl implements ReviewRecordService {
	@Autowired
	private ReviewRecordDao reviewRecordDao;

	@Override
	public User selectUserById(Integer userId) {
		return reviewRecordDao.selectUserById(userId);
	}

	@Override
	public void saveReviewRecord(ReviewRecord review) {
		reviewRecordDao.saveReviewRecord(review);
	}

	@Override
	public List<ReviewRecord> findAllReviewRecords(int pageNum, int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageSize", pageSize);
		map.put("pageNum", (pageNum - 1) * pageSize);
		return reviewRecordDao.findAllReviewRecords(map);
	}

	@Override
	public ReviewRecord findOneReviewRecordById(Integer id) {
		return reviewRecordDao.getOneReviewRecordById(id);
	}

	@Override
	public void updateReviewRecord(ReviewRecord review) {
		reviewRecordDao.updateReviewRecord(review);
	}

	@Override
	public void deleteReviewRecordById(Integer id) {
		reviewRecordDao.deleteReviewRecordById(id);
	}

	@Override
	public int countReviewRecords() {
		return reviewRecordDao.countReviewRecords();
	}

}
