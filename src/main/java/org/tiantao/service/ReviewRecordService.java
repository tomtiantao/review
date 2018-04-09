package org.tiantao.service;

import java.util.List;

import org.tiantao.bean.ReviewRecord;
import org.tiantao.bean.User;

public interface ReviewRecordService {


	User selectUserById(Integer userId);

	/**
	 * @Description: 保存评审
	 * @param review
	 * @return: void
	 * @author: tiant
	 * @date 2018年3月31日 下午2:11:22
	 */
	void saveReviewRecord(ReviewRecord reviewRecord);

	/**
	 * @Description: 更新评审
	 * @param review
	 * @return: void
	 * @author: tiant
	 * @date 2018年4月2日 下午1:49:56
	 */
	void updateReviewRecord(ReviewRecord review);

	/**
	 * @Description: 查询所有评审
	 * @return: List<ReviewRecord>
	 * @author: tiant
	 * @date 2018年3月31日 下午3:00:21
	 */
	List<ReviewRecord> findAllReviewRecords(int pageNum, int pageSize, String keyword, String startDate, String endDate, String team, String projectName, String title);

	List<ReviewRecord> findAllReviewRecordVos(int pageNum, int pageSize, String keyword, String startDate, String endDate, String team, String projectName, String title);

	/**
	 * @Description: 统计评审条数
	 * @return: int
	 * @author: tiant
	 * @date 2018年4月2日 下午3:16:10
	 */
	int countReviewRecords();

	/**
	 * @Description: 根据ID删除评审
	 * @param id
	 * @return: void
	 * @author: tiant
	 * @date 2018年4月2日 下午2:36:25
	 */
	void deleteReviewRecordById(Integer id);

	/**
	 * @Description: 根据ID查询评审
	 * @param id
	 * @return: ReviewRecord
	 * @author: tiant
	 * @date 2018年4月2日 上午10:53:33
	 */
	ReviewRecord findOneReviewRecordById(Integer id);

	List<String> findAllProjectName(String teamId);
}
