package com.micro.webframework.spark;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class AppFreemakerStyle {

	public static void main(String[] args) {
		final Configuration config = new Configuration();
		config.setClassForTemplateLoading(AppFreemakerStyle.class, "/");
		
		try {
			Template helloTemp = config.getTemplate("hello.ftl");
			final StringWriter strWr = new StringWriter();
			Map<String,Object> dataMap = new HashMap<String,Object>();
			dataMap.put("name", "Kingsly starts Freemarker");
			helloTemp.process(dataMap, strWr);
			
			System.out.println("String Writter"+strWr);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
