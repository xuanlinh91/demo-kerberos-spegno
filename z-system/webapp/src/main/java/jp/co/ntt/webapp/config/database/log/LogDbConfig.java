package jp.co.ntt.webapp.config.database.log;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "logDbEntityManagerFactory", basePackages = {
		"jp.co.ntt.common.repository.logdb"}, transactionManagerRef = "logDbTransactionManager")
public class LogDbConfig {

	@Bean(name = "logDbDataSourceProperties")
	@ConfigurationProperties("spring.logdb-datasource")
	public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean(name = "logDbDataSource")
	@ConfigurationProperties("spring.fatpc-datasource.configuration")
	public HikariDataSource dataSource(@Qualifier("logDbDataSourceProperties") DataSourceProperties dataSourceProperties) {
		return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class)
				.build();
	}

	@Bean(name = "logDbEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("logDbDataSource") DataSource dataSource) {
		return builder
				.dataSource(dataSource)
				.packages("jp.co.ntt.common.entity")
				.persistenceUnit("logdb")
				.build();
	}

	@Bean(name = "logDbTransactionManager")
	public PlatformTransactionManager logDbTransactionManager(
			@Qualifier("logDbEntityManagerFactory") EntityManagerFactory
					entityManagerFactory
	) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
