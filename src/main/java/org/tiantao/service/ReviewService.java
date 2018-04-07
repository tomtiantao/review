package org.tiantao.service;

import java.util.List;

import org.tiantao.bean.Review;
import org.tiantao.bean.User;

public interface ReviewService {

	User selectUserById(Integer userId);

	/**
	 * @Description: 保存评审
	 * @param review
	 * @return: void
	 * @author: tiant
	 * @date 2018年3月31日 下午2:11:22
	 */
	void saveReview(Review review);

	/**
	 * @Description: 更新评审
	 * @param review
	 * @return: void
	 * @author: tiant
	 * @date 2018年4月2日 下午1:49:56
	 */
	void updateReview(Review review);

	/**
	 * @Description: 查询所有评审
	 * @return: List<Review>
	 * @author: tiant
	 * @date 2018年3月31日 下午3:00:21
	 */
	List<Review> findAllReviews(int pageNum, int pageSize, String keyword, String startDate, String endDate);

	/**
	 * @Description: 查询所有的项目名
	 * @return: List<String>
	 * @author: tiant
	 * @date 2018年4月3日 下午5:37:10
	 */
	List<String> findAllProjectName();

	/**
	 * @Description: 统计评审条数
	 * @return: int
	 * @author: tiant
	 * @date 2018年4月2日 下午3:16:10
	 */
	int countReviews();

	/**
	 * @Description: 根据ID删除评审
	 * @param id
	 * @return: void
	 * @author: tiant
	 * @date 2018年4月2日 下午2:36:25
	 */
	void deleteReviewById(Integer id);

	/**
	 * @Description: 根据ID查询评审
	 * @param id
	 * @return: Review
	 * @author: tiant
	 * @date 2018年4月2日 上午10:53:33
	 */
	Review findOneReviewById(Integer id);

	/**
	 * @Description: 根据项目名称查询评审
	 * @param projectName
	 * @return: List<Review>
	 * @author: tiant
	 * @date 2018年4月3日 下午3:47:30
	 */
	List<Review> findReviewByProjectName(String projectName);
}
