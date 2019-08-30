package cn.app.service;

import java.util.Map;

import cn.app.entity.AppInfo;
/**
 * app基础信息逻辑层接口
 * @author wjy
 *
 */
public interface AppInfoService {
	
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
	/**
	 * 修改最新版本号id
	 * @param id
	 * @return
	 */
	public Integer updeteVersionId(Map<String, Object> map);
}
