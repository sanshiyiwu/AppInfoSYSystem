package cn.app.dao;

import org.springframework.stereotype.Repository;

import cn.app.entity.AppInfo;

/**
 * 基础信息映射层
 * @author wjy
 *
 */
@Repository("appInfoMapper")
public interface AppInfoMapper {
	/**
	 * 添加app基础信息
	 * @param appInfo
	 * @return
	 */
	public Integer addAppInfo(AppInfo appInfo) ;
	/**
	 * 修改app基础信息
	 * @param appInfo
	 * @return
	 */
	public Integer updeteInfo(AppInfo appInfo);
	/**
	 * 通过APKName获取AppInfo(验证)
	 * @param APKName
	 * @return
	 */
	public AppInfo getAppInfoByAPKName(String APKName);
	/**
	 *  通过主键获取AppInfo
	 * @param id
	 * @return
	 */
	public AppInfo getAppInfoById(Integer id);
}
