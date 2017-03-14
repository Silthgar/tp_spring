package com.erwan.nikonikospring;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.erwan.nikonikospring.dao.INikoNikoCrudRepository;
import com.erwan.nikonikospring.models.NikoNiko;
import com.erwan.nikonikospring.models.Project;
import com.erwan.nikonikospring.models.User;

@SpringBootApplication
public class NikoNikoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(NikoNikoSpringApplication.class, args);

	}
}
