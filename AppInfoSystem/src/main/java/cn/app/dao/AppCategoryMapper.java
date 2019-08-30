package cn.app.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.app.entity.AppCategory;

/**
 * 分类列表映射接口
 * @author wjy
 *
 */
@Repository("appCategoryMapper")
public interface AppCategoryMapper {
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
