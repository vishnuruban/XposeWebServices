package org.mispl.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mispl.bean.Login;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class LoginService {

	
	private JdbcTemplate jdbcTemplate;  
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  
	
	public List<Login> getLoginCredentials(String mobileNumber){  
		
		String id = getId(mobileNumber);
		
		final List<Login> loginDetails = new ArrayList<Login>();
		
		if(id.equals(""))
		{
			  Login lg = new Login();
			  lg.setIp("");
	          lg.setBrand("");
	          lg.setStatus("error");  
	        loginDetails.add(lg);
	        return loginDetails;
		}
		String query="SELECT BRAND,IP,DB_IP,DB_CHILD,DB_COMP,DB_USERNAME,DB_PASSWORD,DB_INSTANCE from brandmaster WHERE SNO IN ("+id+")";
		 return jdbcTemplate.query(query,new ResultSetExtractor<List<Login>>(){  
	
		     public List<Login> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		    
		      /*
		      if(!rs.next())
		      {
		    	    lg.setIp("");
		        	lg.setBrand("");
		        	lg.setStatus("error");  
		        	return loginDetails;
		      }*/
		        while(rs.next()) {  
		        	  Login lg = new Login();
		        	System.out.println(rs.getString("IP"));
		        	lg.setIp(rs.getString("IP"));
		        	lg.setBrand(rs.getString("BRAND"));
		        	lg.setStatus("true");
		        	loginDetails.add(lg);
		        }  
		         return loginDetails;
		        }  
		    });  
		  }  
	
	
	
	
	
	public String  getId(String mobileNumber)
	{
		
		String query ="select brand_id from mobileappsuser where mobile_number='"+mobileNumber+"'";
		
		return jdbcTemplate.query(query,new ResultSetExtractor<String>() {

			@Override
			public String extractData(ResultSet rs1) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				
				
				if(rs1.next())
				{
					String brandid = rs1.getString("brand_id");
					return brandid;
				}
				else
				{
				return "";
				}
			}
		});
		
		
		
		
		
	}
}
