package org.tiantao.dao;

import java.util.List;
import java.util.Map;

import org.tiantao.annotation.MapperAnnotation;
import org.tiantao.bean.ReviewRecord;
import org.tiantao.bean.User;

@MapperAnnotation
public interface ReviewRecordDao {
	public User selectUserById(Integer userId);

	/**
	 * @Description: 保存评审
	 * @param review
	 * @return: void
	 * @author: tiant
	 * @date 2018年3月31日 下午2:12:10
	 */
	void saveReviewRecord(ReviewRecord review);

	/**
	 * @Description: 更新评审
	 * @param review
	 * @return: void
	 * @author: tiant
	 * @date 2018年4月2日 下午1:50:30
	 */
	void updateReviewRecord(ReviewRecord review);

	/**
	 * @Description: 根据ID删除评审
	 * @param id
	 * @return: void
	 * @author: tiant
	 * @date 2018年4月2日 下午2:37:08
	 */
	void deleteReviewRecordById(Integer id);

	/**
	 * @Description: 查询所有评审
	 * @return: List<ReviewRecord>
	 * @author: tiant
	 * @date 2018年3月31日 下午3:00:21
	 */
	List<ReviewRecord> findAllReviewRecords(Map<String, Object> map);

	/**
	 * @Description: 统计
	 * @return: int
	 * @author: tiant
	 * @date 2018年4月2日 下午3:16:51
	 */
	int countReviewRecords();

	/**
	 * @Description: 根据ID查询评审
	 * @param id
	 * @return: ReviewRecord
	 * @author: tiant
	 * @date 2018年4月2日 上午10:54:17
	 */
	ReviewRecord getOneReviewRecordById(Integer id);
}
