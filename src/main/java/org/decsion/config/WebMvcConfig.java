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
		//ds.setUrl("jdbc:mysql://localhost:3306/websparrow");
		ds.setUrl("jdbc:mysql://localhost:3306/Test?autoReconnect=true&useSSL=false&serverTimezone=EST");
		//jdbc:mysql://localhost:3306/Peoples?autoReconnect=true&useSSL=false
		ds.setUsername("root");
		ds.setPassword("JetLee920816");

		return ds;

	}
	

	

	@Bean
	public UserDao getUserDao() {
		return new UserDaoImpl(getDataSource());
		//return new UserDaoImpl(dbMan);
	}
	

}
