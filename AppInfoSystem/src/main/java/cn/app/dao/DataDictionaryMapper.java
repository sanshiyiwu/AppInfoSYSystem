package cn.app.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.app.entity.DataDictionary;

/**
 * 数据字典映射层接口
 * @author Administrator
 *
 */
@Repository("dataDictionaryMapper")
public interface DataDictionaryMapper {
	/**
	 * 通过typeName获取数据字典列表
	 * @param typeName
	 * @return
	 */
	public List<DataDictionary> getDataDictionaryList(String typeName);
}
