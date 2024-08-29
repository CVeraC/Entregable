package com.dh.Entregable;

import com.dh.Entregable.dao.BD;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EntregableApplication {

	public static void main(String[] args) {
		BD.createTable();
		SpringApplication.run(EntregableApplication.class, args);
	}

}
