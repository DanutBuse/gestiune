package com.tema.testare.gestiune.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@Profile("local")
@EnableTransactionManagement
public class PostgreSqlConfig {

    @Value("${postgres.db.url}")
    String POSTGRES_DB_URL;

    @Value("${postgres.db.user}")
    String POSTGRES_DB_USER;

    @Value("${postgres.db.password}")
    String POSTGRES_DB_PASSWORD;

    @Value("${postgres.db.driver}")
    String POSTGRES_DB_DRIVER;

    @Value("${postgres.db.ddl.command}")
    String POSTGRES_DB_DDL_COMMAND;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(POSTGRES_DB_DRIVER);
        dataSource.setUrl(
            System.getenv("POSTGRES_URL") != null ? System.getenv("POSTGRES_URL") : POSTGRES_DB_URL);
        dataSource.setUsername(
            System.getenv("POSTGRES_USER") != null ? System.getenv("POSTGRES_USER") : POSTGRES_DB_USER);
        dataSource.setPassword(
            System.getenv("POSTGRES_PASS") != null ? System.getenv("POSTGRES_PASS") : POSTGRES_DB_PASSWORD);

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] { "com.tema.testare.gestiune.domain.entity" });

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());

        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", POSTGRES_DB_DDL_COMMAND);
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.connection.autocommit", "true");
        properties.setProperty("hibernate.connection.provider_disables_autocommit", "false");
        return properties;
    }
}
