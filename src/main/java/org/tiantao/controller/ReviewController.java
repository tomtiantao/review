package org.tiantao.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tiantao.bean.Review;
import org.tiantao.bean.ReviewRecord;
import org.tiantao.bean.ReviewRecordVo;
import org.tiantao.service.ReviewRecordService;
import org.tiantao.service.ReviewService;

import com.mysql.jdbc.StringUtils;

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
	public Map<String, Object> listReview(@RequestParam(value = "page") Integer pageNum, @RequestParam(value = "limit") Integer pageSize,
			String keyword, String startDate, String endDate) throws IOException {
		if (pageNum == null) {
			pageNum = PAGENUM;
		}
		if (pageSize == null) {
			pageSize = PAGESIZE;
		}
		if (!StringUtils.isNullOrEmpty(keyword)) {
			keyword = new String(keyword.getBytes("ISO-8859-1"), "UTF-8");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", reviewService.findAllReviews(pageNum, pageSize, keyword, startDate, endDate));
		int countReviews = reviewService.countReviews();
		map.put("totalPage", countReviews % pageSize == 0 ? countReviews / pageSize : countReviews / pageSize + 1);
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("count", countReviews);
		map.put("code", 0);
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

	@RequestMapping(value = "/findReview.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findReview(String projectName) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		if (!StringUtils.isNullOrEmpty(projectName)) {
			projectName = new String(projectName.getBytes("ISO-8859-1"), "UTF-8");
		}
		map.put("data", reviewService.findReviewByProjectName(projectName));
		map.put("errorcode", "200");
		map.put("msg", "success");
		return map;
	}

	@RequestMapping(value = "/findAllProjectNames.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findAllProjectNames() throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", reviewService.findAllProjectName());
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
				reviewRecordService.updateReviewRecord(reviewRecord);
			} else {// 保存
				reviewRecordService.saveReviewRecord(reviewRecord);
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
		reviewRecordService.deleteReviewRecordById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("errorcode", "200");
		map.put("msg", "success");
		return map;
	}

	@RequestMapping(value = "/listReviewRecord.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listReviewRecord(@RequestParam(value = "page") Integer pageNum, @RequestParam(value = "limit") Integer pageSize,
			String keyword, String startDate, String endDate, String team, String projectName, String title) throws IOException {
		if (pageNum == null) {
			pageNum = PAGENUM;
		}
		if (pageSize == null) {
			pageSize = PAGESIZE;
		}
		if (!StringUtils.isNullOrEmpty(keyword)) {
			keyword = new String(keyword.getBytes("ISO-8859-1"), "UTF-8");
		}
		if (!StringUtils.isNullOrEmpty(team)) {
			team = new String(team.getBytes("ISO-8859-1"), "UTF-8");
		}
		if (!StringUtils.isNullOrEmpty(projectName)) {
			projectName = new String(projectName.getBytes("ISO-8859-1"), "UTF-8");
		}
		if (!StringUtils.isNullOrEmpty(title)) {
			title = new String(title.getBytes("ISO-8859-1"), "UTF-8");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", reviewRecordService.findAllReviewRecords(pageNum, pageSize, keyword, startDate, endDate, team, projectName, title));
		int countReviews = reviewRecordService.countReviewRecords();
		map.put("totalPage", countReviews % pageSize == 0 ? countReviews / pageSize : countReviews / pageSize + 1);
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("count", countReviews);
		map.put("code", 0);
		map.put("msg", "success");
		return map;
	}

	@RequestMapping(value = "/exportReviewRecord.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> exportReviewRecord(Integer pageNum, Integer pageSize,
			String keyword, String startDate, String endDate, String team, String projectName, String title, HttpServletResponse response) throws IOException {
		if (pageNum == null) {
			pageNum = PAGENUM;
		}
		if (pageSize == null) {
			pageSize = PAGESIZE;
		}
		if (!StringUtils.isNullOrEmpty(keyword)) {
			keyword = new String(keyword.getBytes("ISO-8859-1"), "UTF-8");
		}
		if (!StringUtils.isNullOrEmpty(team)) {
			team = new String(team.getBytes("ISO-8859-1"), "UTF-8");
		}
		if (!StringUtils.isNullOrEmpty(projectName)) {
			projectName = new String(projectName.getBytes("ISO-8859-1"), "UTF-8");
		}
		if (!StringUtils.isNullOrEmpty(title)) {
			title = new String(title.getBytes("ISO-8859-1"), "UTF-8");
		}
		List<ReviewRecordVo> reviewRecordVos = reviewRecordService.findAllReviewRecordVos(pageNum, pageSize, keyword, startDate, endDate, team, projectName, title);
		HSSFWorkbook wb = createWB(reviewRecordVos);
		// 第六步，将文件存到指定位置
		FileOutputStream fout = null;
		ServletOutputStream out = null;
		FileInputStream inputStream = null;
		try {
			String path = ReviewController.class.getClassLoader().getResource("").getPath() + File.separator;
			String fileName = "订单记录-" + System.currentTimeMillis() + ".xls";
			fout = new FileOutputStream(path + fileName);
			wb.write(fout);
			fout.close();
			// 1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
			response.setContentType("multipart/form-data");
			// 2.设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)
			response.setHeader("Content-Disposition",
					"attachment;fileName=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
			inputStream = new FileInputStream(path + fileName);
			// 3.通过response获取ServletOutputStream对象(out)
			out = response.getOutputStream();
			int b = 0;
			byte[] buffer = new byte[512];
			while (0 <= (b = inputStream.read(buffer))) {
				// 4.写到输出流(out)中
				out.write(buffer, 0, b);
			}
			inputStream.close();
			out.close();
			out.flush();
		} catch (Exception e) {
			logger.error("create excel error", e);
		} finally {
			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					logger.error("close io error", e);
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					logger.error("close io error", e);
				}
			}
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					logger.error("close io error", e);
				}
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "success");
		return map;
	}

	@RequestMapping(value = "/fingOneReviewRecord.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> fingOneReviewRecord(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", reviewRecordService.findOneReviewRecordById(id));
		map.put("errorcode", "200");
		map.put("msg", "success");
		return map;
	}

	private HSSFWorkbook createWB(List<ReviewRecordVo> reviewRecordVos) {
		// 生成excel
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("评审记录");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow((int) 0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		int cellIndex = 0;
		HSSFCell cell = row.createCell(cellIndex++);
		cell.setCellValue("编号");
		cell.setCellStyle(style);
		cell = row.createCell(cellIndex++);
		cell.setCellValue("组别");
		cell.setCellStyle(style);
		cell = row.createCell(cellIndex++);
		cell.setCellValue("项目名称");
		cell.setCellStyle(style);
		cell = row.createCell(cellIndex++);
		cell.setCellValue("评审主题");
		cell.setCellStyle(style);
		cell = row.createCell(cellIndex++);
		cell.setCellValue("问题");
		cell.setCellStyle(style);
		cell = row.createCell(cellIndex++);
		cell.setCellValue("提出人");
		cell.setCellStyle(style);
		cell = row.createCell(cellIndex++);
		cell.setCellValue("修改人");
		cell.setCellStyle(style);
		cell = row.createCell(cellIndex++);
		cell.setCellValue("修改时间");
		cell.setCellStyle(style);
		cell = row.createCell(cellIndex++);
		cell.setCellValue("是否修复");
		cell.setCellStyle(style);

		// 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		for (int i = 0; i < reviewRecordVos.size(); i++) {
			row = sheet.createRow((int) i + 1);
			ReviewRecordVo record = (ReviewRecordVo) reviewRecordVos.get(i);
			// 第四步，创建单元格，并设置值
			int cindex = 0;
			row.createCell(cindex++).setCellValue(i + 1);
			row.createCell(cindex++).setCellValue(record.getTeam());
			row.createCell(cindex++).setCellValue(record.getProjectName());
			row.createCell(cindex++).setCellValue(record.getTitle());
			row.createCell(cindex++).setCellValue(record.getProblem());
			row.createCell(cindex++).setCellValue(record.getIntroducer());
			row.createCell(cindex++).setCellValue(record.getModifier());
			row.createCell(cindex++).setCellValue(record.getFinishDate());
			row.createCell(cindex++).setCellValue(record.getStatus());
		}
		return wb;
	}
}
