package cn.app.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.app.dao.AppInfoMapper;
import cn.app.dao.AppVersionMapper;
import cn.app.entity.AppInfo;
import cn.app.entity.AppVersion;
import cn.app.entity.DevUser;

/**
 * App版本信息控制层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/dev_user/app_version")
public class AppVersionController {
	
	private Logger log = Logger.getLogger(AppVersionController.class);
	@Resource
	private AppVersionMapper appVersionMapper;
	@Resource
	private AppInfoMapper appInfoMapper;
	/**
	 * 跳转到App版本信息添加页面
	 * @return
	 */
	@RequestMapping(value = "/addAppVersion/{id}",method = RequestMethod.GET)
	public String addAppVersion(@PathVariable Integer id,Model model,HttpSession session) {
		log.info("进入addAppVersion方法:参数:id>>"+id);
		AppInfo appInfo = appInfoMapper.getAppInfoById(id);
		session.setAttribute("appInfo", appInfo);
		List<AppVersion> appVersionList = 
				appVersionMapper.getAppVersionListByAppId(appInfo.getVersionId());
		model.addAttribute("appVersionList", appVersionList);
		return "app_version/addAppVersion";
	}
	/**
	 * App版本信息添加
	 * @param appVersion
	 * @param request
	 * @param session
	 * @param attach
	 * @return
	 */
	@RequestMapping(value = "/addAppVersionSave")
	public String addAppVersionSave(AppVersion appVersion,HttpServletRequest request,
			HttpSession session,
			@RequestParam(value = "attach",required = false) MultipartFile attach) {
		log.info("进入addAppVersionSave方法;参数:>>"+appVersion);
		boolean isResult = true;//是否出错
		String errorInfo = "";//错误信息
		String fileName = "";//生成的文件名
		String apkFileName = "";
		String apkLocPath = "";
		String savePath = 
				session.getServletContext().getRealPath("statics"+File.separator+"uploadfiles");
		File saveFile = new File(savePath);
		if(!saveFile.exists()) {
			saveFile.mkdirs();
		}
		log.info("文件保存路径："+savePath);
		if(!attach.isEmpty()) {
			//获取原文件名
			String oldName = attach.getOriginalFilename();
			//获取原后缀
			String oldSuffix = FilenameUtils.getExtension(oldName);
			int fileSize = 50000;
			if(attach.getSize()>fileSize){
				errorInfo = "文件大小不得超过50KB";
				isResult = false;
			}else if(oldSuffix.equalsIgnoreCase("apk")) {
				fileName = 
						System.currentTimeMillis()
						+RandomUtils.nextInt(1000000)
						+"_Persion.jpg";
				File targetFile = 
						new File(saveFile, fileName);
				if(!targetFile.exists()){
					targetFile.mkdirs();
				}
				try {
					attach.transferTo(targetFile);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
					errorInfo = "文件上传失败";
					isResult = false;
				}
				apkFileName = fileName;
				apkLocPath = savePath;
			}else{
				errorInfo = "文件格式必须为apk";
				isResult = false;
			}
		}
		if(isResult) {
			DevUser devUser = (DevUser)session.getAttribute("presentCust");
			AppInfo appInfo = (AppInfo)session.getAttribute("appInfo");
			appVersion.setCreatedBy(devUser.getId());
			appVersion.setCreationDate(new Date());
			appVersion.setApkFileName(apkFileName);
			appVersion.setApkLocPath(apkLocPath);
			appVersion.setAppId(appInfo.getId());
			Integer result = appVersionMapper.addAppVersion(appVersion);
			if(result==1) {
				return "";
			}else {
				return "app_version/addAppVersion";
			}
		}else {
			request.setAttribute("errorInfo" , errorInfo);
			return "app_version/addAppVersion";
		}
	}
}
