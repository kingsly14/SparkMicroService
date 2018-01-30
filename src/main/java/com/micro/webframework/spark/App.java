package com.micro.webframework.spark;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Spark.get("/hello", new Route(){

			public Object handle(Request arg0, Response arg1) throws Exception {
				return "Hello Buddy my first Spark";
			}
        	
        });
    }
}
