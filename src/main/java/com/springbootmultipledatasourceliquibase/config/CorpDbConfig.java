package com.springbootmultipledatasourceliquibase.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "corp_entityManagerFactory",
        basePackages = {"com.springbootmultipledatasourceliquibase.domain.corporativo.repository"}, transactionManagerRef = "corp_transactionManager")
public class CorpDbConfig {

    /*
     * 1 - O nome do ententyManager tem quer ter o nome diferente dos outros;
     * 2 - O nome da transactionManagerRef tem que ser diferente das outras;
     * 3 - O Path (basePackages) também tem que ser diferente dos outros
     * 4 - O config do dataSource pode ser extraído do properties
     * */

    @Primary
    @Bean(name = "corpDataSource")
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/corporativo");
        dataSourceBuilder.username("admin");
        dataSourceBuilder.password("admin");
        return dataSourceBuilder.build();
    }

    @Primary
    @Bean(name = "corp_entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                       @Qualifier("corpDataSource") DataSource dataSource) {

        Map<String, Object> properties = new HashMap<>();
        properties.put("spring.jpa.hibernate.ddl-auto", "create-drop");
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

        return builder.dataSource(dataSource).properties(properties)
                .packages("com.springbootmultipledatasourceliquibase.domain.corporativo.entidade")
                .persistenceUnit("Pessoa")
                .build();
    }

    @Primary
    @Bean(name = "corp_transactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("corp_entityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
