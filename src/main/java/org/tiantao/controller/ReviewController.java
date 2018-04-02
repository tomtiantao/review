package org.tiantao.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tiantao.bean.Review;
import org.tiantao.bean.ReviewRecord;
import org.tiantao.service.ReviewRecordService;
import org.tiantao.service.ReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {
	private static final Logger logger = Logger.getLogger(ReviewController.class);
	// 默认首页 10个
	private static final int PAGESIZE = 10;
	private static final int PAGENUM = 1;
	@Resource
	private ReviewService reviewService;
	@Resource
	private ReviewRecordService reviewRecordService;

	@RequestMapping(value = "/saveReview.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> saveReview(Review review) {
		logger.info("保存review:" + review);
		// 根据ID判断是否存在，存在即更新，不存在即保存
		if (review != null) {
			// 更新
			if (review.getId() != null) {
				reviewService.updateReview(review);
			} else {// 保存
				reviewService.saveReview(review);
			}
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("errorcode", "200");
		map.put("msg", "success");
		return map;
	}

	@RequestMapping(value = "/deleteReview.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> deleteReview(Integer id) {
		reviewService.deleteReviewById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("errorcode", "200");
		map.put("msg", "success");
		return map;
	}

	@RequestMapping(value = "/listReview.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listReview(Integer pageNum, Integer pageSize) {
		if (pageNum == null) {
			pageNum = PAGENUM;
		}
		if (pageSize == null) {
			pageSize = PAGESIZE;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", reviewService.findAllReviews(pageNum, pageSize));
		int countReviews = reviewService.countReviews();
		map.put("totalPage", countReviews % pageSize == 0 ? countReviews / pageSize : countReviews / pageSize + 1);
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("count", countReviews);
		map.put("errorcode", "200");
		map.put("msg", "success");
		return map;
	}

	@RequestMapping(value = "/fingOneReview.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> fingOneReview(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", reviewService.findOneReviewById(id));
		map.put("errorcode", "200");
		map.put("msg", "success");
		return map;
	}

	@RequestMapping(value = "/saveReviewRecord.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> saveReviewRecord(ReviewRecord reviewRecord) {
		logger.info("保存reviewRecord:" + reviewRecord);
		// 根据ID判断是否存在，存在即更新，不存在即保存
		if (reviewRecord != null) {
			// 更新
			if (reviewRecord.getId() != null) {
				reviewRecordService.saveReviewRecord(reviewRecord);
			} else {// 保存
				reviewRecordService.updateReviewRecord(reviewRecord);
			}
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("errorcode", "200");
		map.put("msg", "success");
		return map;
	}

	@RequestMapping(value = "/deleteReviewRecord.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> deleteReviewRecord(Integer id) {
		reviewService.deleteReviewById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("errorcode", "200");
		map.put("msg", "success");
		return map;
	}

	@RequestMapping(value = "/listReviewRecord.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listReviewRecord(Integer pageNum, Integer pageSize) {
		if (pageNum == null) {
			pageNum = PAGENUM;
		}
		if (pageSize == null) {
			pageSize = PAGESIZE;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", reviewService.findAllReviews(pageNum, pageSize));
		int countReviews = reviewService.countReviews();
		map.put("totalPage", countReviews % pageSize == 0 ? countReviews / pageSize : countReviews / pageSize + 1);
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("count", countReviews);
		map.put("errorcode", "200");
		map.put("msg", "success");
		return map;
	}

	@RequestMapping(value = "/fingOneReviewRecord.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> fingOneReviewRecord(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", reviewService.findOneReviewById(id));
		map.put("errorcode", "200");
		map.put("msg", "success");
		return map;
	}
}
