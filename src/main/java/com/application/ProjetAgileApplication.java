package com.application;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.application.models.Enseignant;

@SpringBootApplication
public class ProjetAgileApplication implements CommandLineRunner{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetAgileApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		String sql = "select * from enseignant";
		List<Enseignant> enseignants = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Enseignant.class));
		
		enseignants.forEach(System.out :: println);
	}

}
