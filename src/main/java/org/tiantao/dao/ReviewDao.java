package org.tiantao.dao;

import java.util.List;
import java.util.Map;

import org.tiantao.annotation.MapperAnnotation;
import org.tiantao.bean.Review;
import org.tiantao.bean.User;

@MapperAnnotation
public interface ReviewDao {
	public User selectUserById(Integer userId);

	/**
	 * @Description: 保存评审
	 * @param review
	 * @return: void
	 * @author: tiant
	 * @date 2018年3月31日 下午2:12:10
	 */
	void saveReview(Review review);

	/**
	 * @Description: 更新评审
	 * @param review
	 * @return: void
	 * @author: tiant
	 * @date 2018年4月2日 下午1:50:30
	 */
	void updateReview(Review review);

	/**
	 * @Description: 根据ID删除评审
	 * @param id
	 * @return: void
	 * @author: tiant
	 * @date 2018年4月2日 下午2:37:08
	 */
	void deleteReviewById(Integer id);

	/**
	 * @Description: 查询所有评审
	 * @return: List<Review>
	 * @author: tiant
	 * @date 2018年3月31日 下午3:00:21
	 */
	List<Review> findAllReviews(Map<String, Object> map);

	/**
	 * @Description: 根据项目名称查询评审
	 * @param projectName
	 * @return: List<Review>
	 * @author: tiant
	 * @date 2018年4月3日 下午3:48:17
	 */
	List<Review> findReviewByProjectName(String projectName);

	/**
	 * @Description: 查询所有的项目名
	 * @return: List<String>
	 * @author: tiant
	 * @date 2018年4月3日 下午5:38:02
	 */
	List<String> findAllProjectName(String teamId);

	/**
	 * @Description: 统计
	 * @return: int
	 * @author: tiant
	 * @date 2018年4月2日 下午3:16:51
	 */
	int countReviews();

	/**
	 * @Description: 根据ID查询评审
	 * @param id
	 * @return: Review
	 * @author: tiant
	 * @date 2018年4月2日 上午10:54:17
	 */
	Review getOneReviewById(Integer id);
}
