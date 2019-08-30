package cn.app.service;

import java.util.List;

import cn.app.entity.AppVersion;
/**
 * App版本信息业务层接口
 * @author Administrator
 *
 */
public interface AppVersionService {
	/**
	 * 通过appId查询App版本信息
	 * @param appId
	 * @return
	 */
	public List<AppVersion>  getAppVersionListByAppId(Integer appId);
	/**
	 * 添加App版本信息
	 * @param id
	 * @return
	 */
	public Integer addAppVersion(AppVersion appVersion);
}
