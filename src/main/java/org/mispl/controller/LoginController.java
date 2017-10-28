package org.mispl.controller;
import java.util.List;

import org.mispl.bean.Login;
import org.mispl.service.LoginService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;






@Controller("mispl")
public class LoginController {

	

	 ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");  
	 LoginService ps = (LoginService)ctx.getBean("login");  
	 
	 
	 
	 @RequestMapping(value = "/Login/{mobileNo}",method = RequestMethod.GET,headers = "Accept=application/json")
		public ResponseEntity<List<Login>> getAllProfiles(@PathVariable("mobileNo") String mobileNo) {
		
		 
		        System.out.println(mobileNo);
		      List<Login> result = ps.getLoginCredentials(mobileNo);
		       
			return new ResponseEntity<List<Login>>(result, HttpStatus.OK);
		}
	 
}
