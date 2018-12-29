package com.zwp.common;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zwp.common.filter.HttpBasicAuthorizeFilter;

@EnableTransactionManagement
@SpringBootApplication

@MapperScan(basePackages= {"com.zwp.common.mapper"})
public class SpringbootMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisApplication.class, args);
	}

	@Bean
    public FilterRegistrationBean  filterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		HttpBasicAuthorizeFilter httpBasicFilter = new HttpBasicAuthorizeFilter();
		registrationBean.setFilter(httpBasicFilter);
		List<String> urlPatterns = new ArrayList<String>();
	    urlPatterns.add("/user/*");
	    registrationBean.setUrlPatterns(urlPatterns);
	    return registrationBean;
    }

}

