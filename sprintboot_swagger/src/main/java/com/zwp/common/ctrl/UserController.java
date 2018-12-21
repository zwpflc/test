package com.zwp.common.ctrl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
 
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/user")
@Api("userController相关api")
public class UserController {
	 	@ApiOperation("获取用户信息")
	    @ApiImplicitParams({
	        @ApiImplicitParam(paramType="query",name="username",dataType="String",required=true,value="用户的姓名",defaultValue="zhouzhigang"),
	        @ApiImplicitParam(paramType="query",name="password",dataType="String",required=true,value="用户的密码",defaultValue="123456")
	    })
	    @ApiResponses({
	        @ApiResponse(code=400,message="请求参数没填好"),
	        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	    })
	    @RequestMapping(value="/getUser",method=RequestMethod.GET)
	    public void getUser(@RequestParam("username") String username, @RequestParam("password") String password) {
	        System.out.println("username is:"+username);
	        System.out.println("password is:"+password);
	    }
 
}
