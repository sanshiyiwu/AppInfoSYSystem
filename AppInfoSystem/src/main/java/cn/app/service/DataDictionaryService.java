package cn.app.service;

import java.util.List;

import cn.app.entity.DataDictionary;
/**
 * 数据字典逻辑层接口
 * @author wjy
 *
 */
public interface DataDictionaryService {

	/**
	 * 通过typeName获取数据字典列表
	 * @param typeName
	 * @return
	 */
	public List<DataDictionary> getDataDictionaryList(String typeName);	
}
