package com.mitienda.spring;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import menu.menuMain;

@SpringBootApplication
public class StartApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	
	}

	@Override
	public void run(String... args) throws ParseException {
		log.info("StartApplication...");

		/**
		 * Aqui controlar los Menus y el cambio entre ellos. Y En cada menu; usar su
		 * respectivo Controller y Repository
		 */
		menuMain.iniciando();
	}

}