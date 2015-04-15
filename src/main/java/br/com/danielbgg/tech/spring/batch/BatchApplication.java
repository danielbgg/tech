package br.com.danielbgg.tech.spring.batch;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@SpringBootApplication
public class BatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BatchApplication.class, args);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... strings) throws Exception {

		List<Person> results = jdbcTemplate.query(
				"SELECT first_name, last_name FROM people",
				new RowMapper<Person>() {
					@Override
					public Person mapRow(ResultSet rs, int row)
							throws SQLException {
						return new Person(rs.getString(1), rs.getString(2));
					}
				});

		for (Person person : results) {
			System.out.println("Found <" + person + "> in the database.");
		}

	}
}