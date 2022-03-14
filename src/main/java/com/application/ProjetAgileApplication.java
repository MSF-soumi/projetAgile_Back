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
import org.springframework.web.bind.annotation.CrossOrigin;

import com.application.models.Enseignant;
import com.application.models.Sexe;
@CrossOrigin(origins = "*")
@SpringBootApplication
public class ProjetAgileApplication implements CommandLineRunner{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetAgileApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		String sql = "select * from v_sexe";
		List<Sexe> sexes = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Sexe.class));
		
		sexes.forEach(System.out :: println);
	}

}
