package cn.app.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * String向Date转换的转换器
 * @author wjy
 * 
 *
 */
public class StringToDateConverter implements Converter<String, Date> {

	private String datePattern;//日期格式
	
	public StringToDateConverter(){}
	
	public StringToDateConverter(String datePattern){
		this.datePattern = datePattern;
	}
	
	public Date convert(String source) {
		Date date = null;
		try {
			date = new SimpleDateFormat(datePattern).parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}