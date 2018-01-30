package com.micro.webframework.spark;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class WebPage {
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.setClassForTemplateLoading(AppFreemakerStyle.class, "/");
		StringWriter strWr = new StringWriter();
		
		Spark.get("/hello", new Route(){

			public Object handle(Request arg0, Response arg1) throws Exception {
				
		try {
			Template helloTemp = config.getTemplate("hello.ftl");
			
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
		return strWr;
			}
        	
        });
	}

}
