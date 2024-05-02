package com.philip.khzExamen;

import com.philip.khzExamen.models.CarEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@SpringBootApplication
public class KhzExamenApplication {


	public static void main(String[] args) {
		SpringApplication.run(KhzExamenApplication.class, args);




	}
}
