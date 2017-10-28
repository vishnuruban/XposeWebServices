package org.mispl.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
public class LogFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		
		
			 String url = ((HttpServletRequest)request).getRequestURL().toString();
	
			
		  String ipAddress = IP();
		  String hostname = request.getRemoteHost();
	       /* if (request != null) {
	        	ipAddress = request.getHeader("X-REAL-IP");
	            if (ipAddress == null || "".equals(ipAddress)) {
	            	ipAddress = request.getRemoteAddr();
	            }
	        }*/

	     //   return remoteAddr;
	
		
		//Get the IP address of client machine.
	//	String ipAddress = request.getRemoteAddr();
		
		//Log the IP address and current timestamp.
		System.out.println("IP "+ipAddress + ", Time " 
							+ new Date().toString() +"HOST_NAME "+hostname);
		System.out.println(url);
		
		chain.doFilter(req, res);
	}
	
	
	
	
	
	
	
	
	public String IP() {
        URL ipAdress;
        String ip ="";
        try {
            ipAdress = new URL("http://ipecho.net/plain");

            BufferedReader in = new BufferedReader(new InputStreamReader(ipAdress.openStream()));

            ip = in.readLine();
            System.out.println(ip);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return ip; 
	}
	
	
	
	public void init(FilterConfig config) throws ServletException {
		
		//Get init parameter
		String testParam = config.getInitParameter("test-param");
		
		//Print the init parameter
		System.out.println("Test Param: " + testParam);
	}
	public void destroy() {
		//add code to release any resource
	}
}