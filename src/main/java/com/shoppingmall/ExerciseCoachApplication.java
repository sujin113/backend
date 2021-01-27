package com.shoppingmall;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.shoppingmall.model.Users;


@MappedTypes(Users.class)
@MapperScan("com.shoppingmall.mapper")
@SpringBootApplication
public class ExerciseCoachApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExerciseCoachApplication.class, args);
	}

}
 