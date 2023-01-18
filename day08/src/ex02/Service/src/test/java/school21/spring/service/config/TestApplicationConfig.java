package school21.spring.service.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import school21.spring.service.repositories.UsersRepositoryJdbcImpl;
import school21.spring.service.repositories.UsersRepositoryJdbcTemplateImpl;
import school21.spring.service.services.UsersService;
import school21.spring.service.services.UsersServiceImpl;

@Configuration
@ComponentScan("school21.spring.service")
public class TestApplicationConfig {
	@Bean
	DataSource dataSource() {
		DataSource dataSource = new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.HSQL)
				.addScript("table.sql")
				.build();

		return dataSource;
	}

	@Bean("usersServiceJdbc")
	UsersService usersServiceJdbc(DataSource dataSource) {
		return new UsersServiceImpl(new UsersRepositoryJdbcImpl(dataSource));
	}

	@Bean("usersServiceJdbcTemplate")
	UsersService usersServiceJdbcTemplate(DataSource dataSource) {
		return new UsersServiceImpl(new UsersRepositoryJdbcTemplateImpl(dataSource));
	}
}