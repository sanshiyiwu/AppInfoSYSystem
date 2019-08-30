package cn.app.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.app.dao.AppInfoMapper;
import cn.app.entity.AppInfo;
/**
 * app基础信息逻辑层
 * @author wjy
 *
 */
@Service("appInfoService")
@Transactional
public class AppInfoServiceImpl implements AppInfoService{
	
	@Resource
	private AppInfoMapper appInfoMapper;
	
	/**
	 *添加app基础信息
	 * @param appInfo
	 * @return
	 */
	public Integer addAppInfo(AppInfo appInfo) {
		return appInfoMapper.addAppInfo(appInfo);
	}
	
	/**
	 * 修改app基础信息
	 * @param appInfo
	 * @return
	 */
	public Integer updeteInfo(AppInfo appInfo) {
		return appInfoMapper.updeteInfo(appInfo);
	}
	/**
	 * 通过APKName获取AppInfo(验证)
	 * @param APKName
	 * @return
	 */
	public AppInfo getAppInfoByAPKName(String APKName) {
		return appInfoMapper.getAppInfoByAPKName(APKName);
	}
	/**
	 *  通过主键获取AppInfo
	 * @param id
	 * @return
	 */
	public AppInfo getAppInfoById(Integer id) {
		return appInfoMapper.getAppInfoById(id);
	}
	/**
	 * 修改最新版本号id
	 * @param id
	 * @return
	 */
	public Integer updeteVersionId(Map<String, Object> map) {
		return appInfoMapper.updeteVersionId(map);
	}

}
