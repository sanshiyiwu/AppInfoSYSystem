package cn.app.entity;
/**
 * user实体类
 * @author Administrator
 *
 */
public class User {
	private Integer id;//主键id
	private String devCode;//开发者帐号
	private String devName;//开发者名称
	private String devPassword;//开发者密码
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDevCode() {
		return devCode;
	}
	public void setDevCode(String devCode) {
		this.devCode = devCode;
	}
	public String getDevName() {
		return devName;
	}
	public void setDevName(String devName) {
		this.devName = devName;
	}
	public String getDevPassword() {
		return devPassword;
	}
	public void setDevPassword(String devPassword) {
		this.devPassword = devPassword;
	}
	
}
