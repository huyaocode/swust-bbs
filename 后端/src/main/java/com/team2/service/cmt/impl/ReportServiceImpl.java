package com.team2.service.cmt.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team2.dao.cmt.InformationDao;
import com.team2.dao.cmt.ReportDao;
import com.team2.pojo.base.ReportInfo;
import com.team2.pojo.cmt.Information;
import com.team2.pojo.cmt.Report;
import com.team2.pojo.sys.User;
import com.team2.vo.cmt.ReportQuery;
import com.team2.service.cmt.ReportService;
import com.team2.utils.UserUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class ReportServiceImpl implements ReportService{

	@Autowired
	public ReportDao reportDao;
	@Autowired
	public InformationDao informationDao;
	@Override
	public Long delById(Long id) {
	   reportDao.delById(id);
	   return id;
	}

	@Override
	public Long save(Report record) {
		User userId=UserUtil.getLoginUser();
		record.setUserId(userId.getId());
		record.setStatus("0");
		reportDao.save(record);
		return record.getId();
	}

	@Override
	public Report getById(Long id) {
		return reportDao.getById(id);
	}


	@Override
	public Long editById(Report record) {
		reportDao.editById(record);
		return record.getId();
	}

	@Override
	public PageInfo<Report> list(int pagenum, int pagesize,ReportQuery param) {
		PageHelper.startPage(pagenum, pagesize);
		List<Report> datalist = reportDao.list(param);
		PageInfo<Report> resultPage = new PageInfo<Report>(datalist);
		return resultPage;
	}

@Override
	public List<Report> listAll(ReportQuery param) {
		List<Report> datalist = reportDao.list(param);
		return datalist;
	}

@Override
@Transactional
public Long setBanned(ReportInfo info) {
	Report report=reportDao.getById(info.getId());
	if(info.getType().equals("1"))
	   informationDao.setBanned(report.getInformationId());
	reportDao.setVerified(info.getId());
	return info.getId();
}

}
