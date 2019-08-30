package cn.app.dao;
/**
 * App版本信息映射层接口
 * @author Administrator
 *
 */

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.app.entity.AppVersion;
@Repository("appVersionMapper")
public interface AppVersionMapper {
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
	/**
	 * 获取App版本信息(添加versionid用)
	 * @param appVersion
	 * @return
	 */
	public AppVersion getAppVersion(AppVersion appVersion);
}
