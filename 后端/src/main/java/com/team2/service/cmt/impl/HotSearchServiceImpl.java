package com.team2.service.cmt.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team2.dao.cmt.HotSearchDao;
import com.team2.pojo.base.SearchInfo;
import com.team2.pojo.cmt.HotSearch;
import com.team2.pojo.cmt.Information;
import com.team2.vo.cmt.HotSearchQuery;
import com.team2.vo.cmt.InformationQuery;
import com.team2.service.cmt.HotSearchService;
import com.team2.service.cmt.InformationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class HotSearchServiceImpl implements HotSearchService {

	@Autowired
	public HotSearchDao hotSearchDao;
	@Autowired
	public InformationService informationService;

	@Override
	public Long delById(Long id) {
		hotSearchDao.delById(id);
		return id;
	}

	@Override
	public Long save(HotSearch record) {
		hotSearchDao.save(record);
		return record.getId();
	}

	@Override
	public HotSearch getById(Long id) {
		return hotSearchDao.getById(id);
	}

	@Override
	public Long editById(HotSearch record) {
		hotSearchDao.editById(record);
		return record.getId();
	}

	@Override
	public PageInfo<HotSearch> list(int pagenum, int pagesize, HotSearchQuery param) {
		PageHelper.startPage(pagenum, pagesize);
		List<HotSearch> datalist = hotSearchDao.list(param);
		PageInfo<HotSearch> resultPage = new PageInfo<HotSearch>(datalist);
		return resultPage;
	}

	@Override
	public List<HotSearch> listAll(HotSearchQuery param) {
		List<HotSearch> datalist = hotSearchDao.list(param);
		return datalist;
	}

	@Override
	@Transactional
	public PageInfo<Information> doSearch(SearchInfo info) {
		InformationQuery param = new InformationQuery();
		if (info.getSearchContent() != null && !info.getSearchContent().equals(""))
			param.setTitle(info.getSearchContent());
		if (info.getType() != null && !info.getType().equals(""))
			param.setType(info.getType());
		PageInfo<Information> infos = informationService.list(info.getPageNum(), info.getPageSize(), param);
		
		
		HotSearch hotSearch = hotSearchDao.getByHotWord(info.getSearchContent());
		if (hotSearch!=null) {
			hotSearch.setFrequency(hotSearch.getFrequency() + 1);
            hotSearchDao.editById(hotSearch);
		} else {
			hotSearch = new HotSearch();
			hotSearch.setHotWord(info.getSearchContent());
			hotSearch.setFrequency(1L);
            hotSearchDao.save(hotSearch);
		}
		return infos;
	}

}
