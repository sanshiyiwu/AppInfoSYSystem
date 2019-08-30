package cn.app.service;

import java.util.List;

import cn.app.entity.AppCategory;
/**
 * 分类表逻辑层接口
 * @author wjy
 *
 */
public interface AppCategoryService {
	
	/**
	 * 获取所有分类
	 * @return
	 */
	public List<AppCategory> getAppCategoryList();
	/**
	 * 	通过ParentId获取所有分类
	 * @return
	 */
	public List<AppCategory> getAppCategoryListByParentId(Integer parentId);
}
