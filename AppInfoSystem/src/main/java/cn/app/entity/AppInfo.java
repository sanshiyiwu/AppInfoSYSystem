package cn.app.entity;

import java.util.Date;

/**
 * app基础信息
 * @author lenovo
 *
 */
public class AppInfo {
	/**
	 * 序号
	 */
	private Integer id;
	/**
	 * 软件名
	 */
	private String softwareName;
	/**
	 * APP名
	 */
	private String APKName;
	/**
	 * 支持的ROM
	 */
	private String supportROM;
	/**
	 * 界面语言
	 */
	private String interfaceLanguage;
	/**
	 * 软件大小
	 */
	private Double softwareSize;
	/**
	 * 更新时间
	 */
	private Date updateDate;
	/**
	 * 用户ID
	 */
	private Integer devId;
	/**
	 * 软件信息
	 */
	private String appInfo;
	/**
	 * 开售时间
	 */
	private Date onSaleDate;
	/**
	 * 停售时间
	 */
	private Date offSaleDate;
	/**
	 * 平台ID
	 */
	private Integer flatFormId;
	/**
	 * 第三级分类
	 */
	private Integer categoryLevel3;
	/**
	 * 下载
	 */
	private Integer downloads;
	/**
	 * 创建者
	 */
	private Integer createdBy;
	/**
	 * 创建时间
	 */
	private Date creationDate;
	/**
	 * 修改者
	 */
	private Integer modifyBy;
	/**
	 * 修改时间
	 */
	private Date modifyDate;
	/**
	 * 第一级分类
	 */
	private Integer categoryLevel1;
	/**
	 * 第二级分类
	 */
	private Integer categoryLevel2;
	/**
	 * logo图片文件目录
	 */
	private String logoPicPath;
	/**
	 * logo图片文件目录
	 */
	private String logoLocPath;
	/**
	 * 版本ID
	 */
	private Integer versionId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSoftwareName() {
		return softwareName;
	}
	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}
	public String getAPKName() {
		return APKName;
	}
	public void setAPKName(String aPKName) {
		APKName = aPKName;
	}
	public String getSupportROM() {
		return supportROM;
	}
	public void setSupportROM(String supportROM) {
		this.supportROM = supportROM;
	}
	public String getInterfaceLanguage() {
		return interfaceLanguage;
	}
	public void setInterfaceLanguage(String interfaceLanguage) {
		this.interfaceLanguage = interfaceLanguage;
	}
	public Double getSoftwareSize() {
		return softwareSize;
	}
	public void setSoftwareSize(Double softwareSize) {
		this.softwareSize = softwareSize;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Integer getDevId() {
		return devId;
	}
	public void setDevId(Integer devId) {
		this.devId = devId;
	}
	public String getAppInfo() {
		return appInfo;
	}
	public void setAppInfo(String appInfo) {
		this.appInfo = appInfo;
	}
	public Date getOnSaleDate() {
		return onSaleDate;
	}
	public void setOnSaleDate(Date onSaleDate) {
		this.onSaleDate = onSaleDate;
	}
	public Date getOffSaleDate() {
		return offSaleDate;
	}
	public void setOffSaleDate(Date offSaleDate) {
		this.offSaleDate = offSaleDate;
	}
	public Integer getFlatFormId() {
		return flatFormId;
	}
	public void setFlatFormId(Integer flatFormId) {
		this.flatFormId = flatFormId;
	}
	public Integer getCategoryLevel3() {
		return categoryLevel3;
	}
	public void setCategoryLevel3(Integer categoryLevel3) {
		this.categoryLevel3 = categoryLevel3;
	}
	public Integer getDownloads() {
		return downloads;
	}
	public void setDownloads(Integer downloads) {
		this.downloads = downloads;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Integer getCategoryLevel1() {
		return categoryLevel1;
	}
	public void setCategoryLevel1(Integer categoryLevel1) {
		this.categoryLevel1 = categoryLevel1;
	}
	public Integer getCategoryLevel2() {
		return categoryLevel2;
	}
	public void setCategoryLevel2(Integer categoryLevel2) {
		this.categoryLevel2 = categoryLevel2;
	}
	public String getLogoPicPath() {
		return logoPicPath;
	}
	public void setLogoPicPath(String logoPicPath) {
		this.logoPicPath = logoPicPath;
	}
	public String getLogoLocPath() {
		return logoLocPath;
	}
	public void setLogoLocPath(String logoLocPath) {
		this.logoLocPath = logoLocPath;
	}
	public Integer getVersionId() {
		return versionId;
	}
	public void setVersionId(Integer versionId) {
		this.versionId = versionId;
	}
	
	
}
