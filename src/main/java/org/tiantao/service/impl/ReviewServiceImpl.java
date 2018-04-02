package org.tiantao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiantao.bean.Review;
import org.tiantao.bean.User;
import org.tiantao.dao.ReviewDao;
import org.tiantao.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewDao reviewDao;

	@Override
	public User selectUserById(Integer userId) {
		return reviewDao.selectUserById(userId);
	}

	@Override
	public void saveReview(Review review) {
		reviewDao.saveReview(review);
	}

	@Override
	public List<Review> findAllReviews(int pageNum, int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageSize", pageSize);
		map.put("pageNum", (pageNum - 1) * pageSize);
		return reviewDao.findAllReviews(map);
	}

	@Override
	public Review findOneReviewById(Integer id) {
		return reviewDao.getOneReviewById(id);
	}

	@Override
	public void updateReview(Review review) {
		reviewDao.updateReview(review);
	}

	@Override
	public void deleteReviewById(Integer id) {
		reviewDao.deleteReviewById(id);
	}

	@Override
	public int countReviews() {
		return reviewDao.countReviews();
	}
}
