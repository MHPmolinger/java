package com.neusoft.struts2.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class DateConverter extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {

         if(toClass!=java.util.Date.class){
        	 return null;
         }
         SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM-dd");
         try {
			return sdf.parse(values[0]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String convertToString(Map context, Object o) {
		// TODO Auto-generated method stub
		return null;
	}

}
