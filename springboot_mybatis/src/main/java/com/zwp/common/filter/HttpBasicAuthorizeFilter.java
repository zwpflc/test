package com.zwp.common.filter;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpBasicAuthorizeFilter implements Filter {

	private static String Name = "user";
	private static String Password = "pwd";
			
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		ResultStatusCode resultStatusCode = checkHTTPBasicAuthorize(request);
		if (resultStatusCode != ResultStatusCode.OK)
		{
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.setCharacterEncoding("UTF-8");  
			httpResponse.setContentType("application/json; charset=utf-8"); 
			httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
 
			ObjectMapper mapper = new ObjectMapper();
			
			ResultMsg resultMsg = new ResultMsg(ResultStatusCode.PERMISSION_DENIED.getErrcode(), ResultStatusCode.PERMISSION_DENIED.getErrmsg(), null);
			httpResponse.getWriter().write(mapper.writeValueAsString(resultMsg));
			return;
		}
		else
		{
			chain.doFilter(request, response);
		}

	}

	private ResultStatusCode checkHTTPBasicAuthorize(ServletRequest request) {
		try
		{
			HttpServletRequest httpRequest = (HttpServletRequest)request;
			String auth = httpRequest.getHeader("Authorization");
			if ((auth != null) && (auth.length() > 6))
			{
				String HeadStr = auth.substring(0, 5).toLowerCase();
				if (HeadStr.compareTo("basic") == 0)
				{
					auth = auth.substring(6, auth.length());  
		            String decodedAuth = getFromBASE64(auth);
		            if (decodedAuth != null)
		            {
		            	String[] UserArray = decodedAuth.split(":");
		            	
		            	if (UserArray != null && UserArray.length == 2)
		            	{
		            		if (UserArray[0].compareTo(Name) == 0
			            			&& UserArray[1].compareTo(Password) == 0)
		            		{
		            			return ResultStatusCode.OK;
		            		}
		            	}
		            }
				}
			}
			return ResultStatusCode.PERMISSION_DENIED;
		}
		catch(Exception ex)
		{
			return ResultStatusCode.PERMISSION_DENIED;
		}
		
	}

	private String getFromBASE64(String s) {
		if (s == null)  
            return null;  

		final Base64.Decoder decoder = Base64.getDecoder();
        try {  
            byte[] b = decoder.decode(s);  
            return new String(b);  
        } catch (Exception e) {  
            return null;  
        }

	}

	public static void main(String[] args) {
		final Base64.Encoder encoder = Base64.getEncoder();
		System.out.println(new String(encoder.encode("user:pwd".getBytes())));
	}
}
