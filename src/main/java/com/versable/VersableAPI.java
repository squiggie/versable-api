package com.versable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class VersableAPI {

	public static void main(String[] args) {
		Map<String, String> env = System.getenv();
        Map<String, Object> db = new HashMap<>();
        db.put("spring.data.mongodb.uri", env.get("DB_URI"));
		new SpringApplicationBuilder().properties(db).sources(VersableAPI.class).run(args);
		//SpringApplication.run(VersableAPI.class, args);
	}
}
