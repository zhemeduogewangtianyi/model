package com.oak.model;

import com.oak.model.application.interceptor.config.MyWebAppConfigurer;
import com.oak.model.servlet.MyServlet1;
import com.oak.model.util.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import resource.Wisely2Settings;
import resource.WiselySettings;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@ServletComponentScan
@EnableConfigurationProperties({WiselySettings.class, Wisely2Settings.class})
@ComponentScan(basePackages={"cn.oak.model","org.oak.model","com.oak.model"})
public class ModelApplication {

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//// 设置文件大小限制 ,超了，页面会抛出异常信息，这时候就需要进行异常信息的处理了;
		factory.setMaxFileSize("12800KB"); //KB,MB
		/// 设置总上传数据总大小
		factory.setMaxRequestSize("25600KB");
		//Sets the directory location where files will be stored.
//		factory.setLocation("F:\\files");
		return factory.createMultipartConfig();
	}

	@Bean
	public MyWebAppConfigurer myWebAppConfigurer(){
		return new MyWebAppConfigurer();
	}

	/**
	 * 注册Servlet.不需要添加注解：@ServletComponentScan
	 * @return
	 */
	@Bean
	public ServletRegistrationBean MyServlet1(){
		return new ServletRegistrationBean(new MyServlet1(),"/myServlet/*");
	}

	@Bean
	public SpringUtil springUtil2(){
		return new SpringUtil();
	}

	public static void main(String[] args) {
		SpringApplication.run(ModelApplication.class, args);
	}
}
