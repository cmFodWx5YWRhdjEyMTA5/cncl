package cn.net.cncl.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.net.cncl.common.Constant;
import cn.net.cncl.entity.News;
import cn.net.cncl.mapper.NewsMapper;
import cn.net.cncl.service.NewsService;

@Service
@Transactional
public class NewsServiceImpl implements NewsService {

	private static Logger logger = LoggerFactory.getLogger(NewsServiceImpl.class);

	@Autowired
	private NewsMapper newsMapper;

	/**
	 * 资讯 查询
	 */
	@Override
	public PageInfo<News> selectNews(Integer pageNum) {
		PageHelper.startPage(pageNum, Constant.PAGE_SIZE);
		List<News> list = newsMapper.selectNews();
		PageInfo<News> pageInfo = new PageInfo<News>(list);
		return pageInfo;
	}

	/**
	 * 资讯编辑 新增
	 */
	@Override
	public int addNews(News news) {
		news.setNewsId(new Date().getTime());
		// getUser
		news.setAdminUserIdFk(10000000000000001L);
		news.setCeateTime(new Date());
		news.setBrowseCount(0);
		return newsMapper.insertNews(news);
	}

	/**
	 * 资讯编辑 修改
	 */
	@Override
	public int editNews(News news) {
		return newsMapper.updateNews(news);
	}

	/**
	 * 资讯编辑 删除
	 */
	@Override
	public int deleteNews(Long newsId) {
		return newsMapper.deleteByPrimaryKey(newsId);
	}

	/**
	 * 根据ID查询
	 */
	@Override
	public News queryNewsByID(Long newsId) {
		return newsMapper.selectNewsByID(newsId);
	}

}
