package org.decsion.config;

import org.decision.dao.UserDao;
import org.decision.dao.UserDaoImpl;

//import java.sql.Connection;
//import java.sql.SQLException;

//import javax.activation.DataSource;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.AbstractDriverBasedDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("org.decision")

public class WebMvcConfig {

	@Bean
	InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver vr = new InternalResourceViewResolver();

		vr.setPrefix("/");
		vr.setSuffix(".jsp");
		return vr;

	}

	@Bean
	DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		//please change ##### to your database name, my time zone is EST, please fix it to your time zone
		ds.setUrl("jdbc:mysql://localhost:3306/#####?autoReconnect=true&useSSL=false&serverTimezone=EST");
		ds.setUsername("####"); //please change it to your own database username 
		ds.setPassword("####"); //please change it to your own password 

		return ds;

	}
	

	

	@Bean
	public UserDao getUserDao() {
		return new UserDaoImpl(getDataSource());
	}
	

}
