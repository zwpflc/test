package com.zwp.common.ctrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.zwp.common.entity.Student;
import com.zwp.common.service.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;
 
/**
 * 
 * @author wezhao
 *
 */
@RestController
@RequestMapping("api")
@Api("StudentController相关的api")
public class StudentController {
    @Autowired
    private StudentService studentService;
 
    private static final Logger logger= LoggerFactory.getLogger(StudentController.class);
 
 
    @ApiOperation(value = "根据id查询学生信息", notes = "查询数据库中某个的学生信息")
    @ApiImplicitParam(name = "id", value = "学生ID", paramType = "path", required = true, dataType = "Integer")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    public Student getStudent(@PathVariable int id) {
        logger.info("开始查询某个学生信息");
        return studentService.selectStudentById(id);
    }
 
 

 	@ApiOperation(value = "测试post请求",notes="注意事项")
 	@ApiImplicitParam(dataType = "Student",name = "student",value = "用户信息",required = true)
 	@RequestMapping(value = "/testPost",method = RequestMethod.POST)
 	public String testPost(@RequestBody Student student){
 		return JSONObject.toJSONString(student);
 	}


 	@ApiOperation(value = "测试get请求",notes="注意事项")
 	@ApiImplicitParam(name = "id",value = "用户id",dataType = "String",paramType = "path")
 	@RequestMapping(value = "/testGet/{id}",method = RequestMethod.GET)
 	public String testGet(@PathVariable String id){
 		return id;
 	}

 	@ApiOperation(value = "测试组合注解",notes="注意事项")
 	@ApiImplicitParams({
 			@ApiImplicitParam(dataType = "Student",name = "student",value = "用户信息",required = true,paramType = "body"),
 			@ApiImplicitParam(dataType = "string",name = "id",value = "用户id",required = true,paramType = "path")
 	})
 	@RequestMapping(value = "/joinAnnotation/{id}",method = RequestMethod.POST)
 	public Student joinAnnotation(@PathVariable String id,@RequestBody Student student){
 		return new Student();
 	}
 	
 	@ApiIgnore
 	public String testIgnore(){
 		return "success";
 	}
}