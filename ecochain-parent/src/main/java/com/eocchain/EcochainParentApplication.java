package com.eocchain;

import io.swagger.annotations.Api;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude={MybatisAutoConfiguration.class, DataSourceAutoConfiguration.class})
@EnableSwagger2
public class EcochainParentApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcochainParentApplication.class, args);
	}
}
