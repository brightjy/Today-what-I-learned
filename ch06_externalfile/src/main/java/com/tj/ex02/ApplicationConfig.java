package com.tj.ex02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class ApplicationConfig {
	@Value("${admin.id}")
	private String adminId;
	@Value("${admin.pw}")
	private String adminPw;
	@Value("${sub_admin.id}")
	private String subAdminId;
	@Value("${sub_admin.pw}")
	private String subAdminPw;
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		Resource[] locations = new Resource[2];
		locations[0] = new ClassPathResource("admin.properties");
		locations[1] = new ClassPathResource("sub_admin.properties");
		configurer.setLocations(locations);
		return configurer;
	}
	@Bean
	public AdminInfo adminInfo() {
		AdminInfo info = new AdminInfo();
		info.setAdminId(adminId);
		info.setAdminPw(adminPw);
		info.setSubAdminId(subAdminId);
		info.setSubAdminPw(subAdminPw);
		return info;
	}
}
