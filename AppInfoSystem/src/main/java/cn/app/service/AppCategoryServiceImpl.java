package cn.app.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.app.dao.AppCategoryMapper;
import cn.app.entity.AppCategory;

/**
 * 分类表逻辑层
 * @author Administrator
 *
 */
@Service("appCategoryService")
@Transactional
public class AppCategoryServiceImpl implements AppCategoryService{
	@Resource
	private AppCategoryMapper appCategoryMapper;
	/**
	 * 获取所有分类
	 * @return
	 */
	public List<AppCategory> getAppCategoryList() {
		return appCategoryMapper.getAppCategoryList();
	}
	
	/**
	 * 	通过ParentId获取所有分类
	 * @return
	 */
	public List<AppCategory> getAppCategoryListByParentId(Integer parentId) {
		return appCategoryMapper.getAppCategoryListByParentId(parentId);
	}

}
