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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.app.dao.AppCategoryMapper;
import cn.app.dao.AppInfoMapper;
import cn.app.dao.DataDictionaryMapper;
import cn.app.entity.AppCategory;
import cn.app.entity.AppInfo;
import cn.app.entity.DataDictionary;
import cn.app.entity.DevUser;

/**
 * appInfo控制器
 * @author wjy
 *
 */
@Controller
@RequestMapping("/dev_user/app_info")
public class AppInfoController {
	
	private  Logger log = Logger.getLogger(AppInfoController.class);
	@Resource
	private AppInfoMapper appInfoMapper;
	@Resource
	private DataDictionaryMapper dataDictionaryMapper;
	@Resource
	private AppCategoryMapper appCategoryMapper;
	/**
	 * 	跳转到app基础信息添加页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addAppInfo",method = RequestMethod.GET)
	public String addAppInfo(Model model) {
		log.info("进入addAppInfo方法;参数:>>");
		List<DataDictionary> dataDictionaryList_f = 
				dataDictionaryMapper.getDataDictionaryList("所属平台");
		List<DataDictionary> dataDictionaryList_s = 
				dataDictionaryMapper.getDataDictionaryList("APP状态");
		List<AppCategory> appCategoryList = 
				appCategoryMapper.getAppCategoryList();
		model.addAttribute("dataDictionaryList_f", dataDictionaryList_f);
		model.addAttribute("dataDictionaryList_s", dataDictionaryList_s);
		model.addAttribute("appCategoryList", appCategoryList);
		log.info("addAppInfo方法结束;结果:跳转到添加页面>>"+appCategoryList.size());
		return "app_info/addAppInfo";
	}
	/**
	 * app基础信息添加
	 * @return
	 */
	@RequestMapping(value = "/addAppInfoSave")
	public String addAppInfoSave(AppInfo appInfo,HttpSession session,
			HttpServletRequest request,
			@RequestParam(value="attach",required=false)MultipartFile attach) {
		log.info("进入addAppInfoSave方法;参数:>>"+appInfo);
		boolean isResult = true;//是否出错
		String errorInfo = "";//错误信息
		String fileName = "";//生成的文件名
		String logoLocPath = "";
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
			}else if(oldSuffix.equalsIgnoreCase("jpg")
					||oldSuffix.equalsIgnoreCase("png")
					||oldSuffix.equalsIgnoreCase("jpeg")) {
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
				logoLocPath = fileName;
			}else{
				errorInfo = "文件格式必须为jpg、png、jpeg";
				isResult = false;
			}
		}
		if(isResult) {
			DevUser devUser = (DevUser)session.getAttribute("presentCust");
			appInfo.setModifyBy(devUser.getId());
			//appInfo.setCreatedBy(1);
			appInfo.setCreationDate(new Date());
			appInfo.setLogoLocPath(logoLocPath);
			Integer result = appInfoMapper.addAppInfo(appInfo);
			log.info("addAppInfoSave方法结束;结果result:"+result+">>");
			if(result == 1 ) {
				return "dev_user/login";
			}else {
				return "app_info/addAppInfo";
			}
			
		}else {
			request.setAttribute("errorInfo" , errorInfo);
			return "app_info/addAppInfo";
		}
	}
	/**
	 * 	级联下拉列表
	 * @param requset
	 * @param appCategory
	 * @return
	 */
	@RequestMapping(value = "/getCategoryLevel1")
	@ResponseBody
	public List<AppCategory> getCategoryLevel1(HttpServletRequest requset ,AppCategory appCategory) {
		log.info("进入getCategoryLevel1方法;参数:appCategory>>"+appCategory);
		String id0 = requset.getParameter("id");
		Integer id = Integer.parseInt(id0);
		appCategory.setParentId(id);
		List<AppCategory> appCategoryList = 
				appCategoryMapper.getAppCategoryListByParentId(id);
		log.info("getCategoryLevel1方法结束;结果appCategoryList:"+appCategoryList.size()+">>");
		return appCategoryList;
	}
	/**
	 * 	级联下拉列表
	 * @param requset
	 * @param appCategory
	 * @return
	 */
	@RequestMapping(value = "/getCategoryLevel2")
	@ResponseBody
	public List<AppCategory> getCategoryLevel2(HttpServletRequest requset ,AppCategory appCategory) {
		log.info("进入getCategoryLevel2方法;参数:appCategory>>"+appCategory);
		String id0 = requset.getParameter("id");
		Integer id = Integer.parseInt(id0);
		appCategory.setParentId(id);
		List<AppCategory> appCategoryList = 
				appCategoryMapper.getAppCategoryListByParentId(id);
		log.info("getCategoryLevel2方法结束;结果appCategoryList:"+appCategoryList.size()+">>");
		return appCategoryList;
	}
	/**
	      *     验证 APKName是否存在
	 * @param requset
	 * @param appInfo
	 * @return
	 */
	@RequestMapping(value = "/isExistAPKName")
	@ResponseBody
	public String isExistAPKName(HttpServletRequest requset ,String APKName) {
		log.info("进入isExistAPKName方法;参数:APKName>>"+APKName);
		AppInfo appInfo = appInfoMapper.getAppInfoByAPKName(APKName);
		String result;
		log.info("isExistAPKName方法结束;结果appInfo:"+appInfo+">>");
		if(appInfo!=null) {
			result = "1";
		}else {
			result = "0";
		}
		return result;
	}
	/**
	 * 	跳转到修改AppInfo页面
	 * @return
	 */
	@RequestMapping(value = "/updeteAppInfo/{id}",method = RequestMethod.GET)
	public String updeteAppInfo(@PathVariable Integer id ,Model model) {
		log.info("进入updeteAppInfo方法;参数:id>>"+id);
		List<DataDictionary> dataDictionaryList_f = 
				dataDictionaryMapper.getDataDictionaryList("所属平台");
		List<DataDictionary> dataDictionaryList_s = 
				dataDictionaryMapper.getDataDictionaryList("APP状态");
		AppInfo appInfo = appInfoMapper.getAppInfoById(id);
		model.addAttribute("dataDictionaryList_f", dataDictionaryList_f);
		model.addAttribute("dataDictionaryList_s", dataDictionaryList_s);
		model.addAttribute("appInfo", appInfo);
		log.info("updeteAppInfo方法结束;结果model:"+model+">>");
		return "app_info/updeteAppInfo";
	}
	/**
	 *	 修改AppInfo
	 * @return
	 */
	@RequestMapping(value = "/updeteAppInfoSave",method = RequestMethod.POST)
	public String updeteAppInfoSave(AppInfo appInfo,HttpSession session,
			HttpServletRequest request,
			@RequestParam(value = "attach",required = false) MultipartFile attach) {
		log.info("进入updeteAppInfoSave方法;参数:appInfo>>"+appInfo);
		boolean isResult = true;//是否出错
		String errorInfo = "";//错误信息
		String fileName = "";//生成的文件名
		String logoLocPath = "";
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
			}else if(oldSuffix.equalsIgnoreCase("jpg")
					||oldSuffix.equalsIgnoreCase("png")
					||oldSuffix.equalsIgnoreCase("jpeg")) {
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
				logoLocPath = fileName;
			}else{
				errorInfo = "文件格式必须为jpg、png、jpeg";
				isResult = false;
			}
		}
		if(isResult) {
			
			DevUser devUser = (DevUser)session.getAttribute("presentCust");
			appInfo.setModifyBy(devUser.getId());
			//appInfo.setModifyBy(1);
			appInfo.setModifyDate(new Date());
			appInfo.setLogoLocPath(logoLocPath);
			Integer result = appInfoMapper.updeteInfo(appInfo);
			log.info("updeteAppInfoSave方法结束;结果result:"+result+">>");
			if(result == 1 ) {
				return "";
			}else {
				return "app_info/updeteAppInfo";
			}
			
		}else {
			request.setAttribute("errorInfo" , errorInfo);
			return "app_info/updeteAppInfo";
		}
	}
	
}
