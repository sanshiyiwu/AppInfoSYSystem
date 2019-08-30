package cn.app.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.app.dao.DataDictionaryMapper;
import cn.app.entity.DataDictionary;

/**
 * 数据字典逻辑层
 * @author wjy
 *
 */
@Service("dataDictionaryService")
@Transactional
public class DataDictionaryServiceImpl implements DataDictionaryService{
	@Resource
	private DataDictionaryMapper dataDictionaryMapper;
	public List<DataDictionary> getDataDictionaryList(String typeName) {
		return dataDictionaryMapper.getDataDictionaryList(typeName);
	}

}
