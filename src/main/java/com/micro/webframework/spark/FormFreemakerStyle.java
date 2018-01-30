package com.micro.webframework.spark;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class FormFreemakerStyle {



	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.setClassForTemplateLoading(FormFreemakerStyle.class, "/");
		StringWriter strWr = new StringWriter();
		Spark.get("/", new Route(){

			public Object handle(Request arg0, Response arg1) throws Exception {
				
		try {
			Template formTemp = config.getTemplate("form.ftl");
			
			Map<String,Object> dataMap = new HashMap<String,Object>();
			dataMap.put("fruits", Arrays.asList("apple","grape","orange","peach"));
			
			formTemp.process(dataMap, strWr);
			
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
		
		
		Spark.post("/fav_fruit", new Route(){

		public Object handle(Request arg0, Response arg1) throws Exception {
			
			String fruit = arg0.queryParams("fruit");
			if(fruit==null){
				
				return "Why dont you select the fruit?";
			}else{
				return "Your fav fruit: "+fruit; 
			}
		}
	});
	}

}
