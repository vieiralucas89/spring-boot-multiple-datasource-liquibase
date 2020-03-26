package com.springbootmultipledatasourceliquibase.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
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
@EnableJpaRepositories(entityManagerFactoryRef = "intra_EntityManagerFactory",
        transactionManagerRef = "intra_transactionManager",
        basePackages = {"com.springbootmultipledatasourceliquibase.domain.intranet.repository"})
public class IntranetDbConfig {

    /*
     * 1 - O nome do ententyManager tem quer ter o nome diferente dos outros;
     * 2 - O nome da transactionManagerRef tem que ser diferente das outras;
     * 3 - O Path (basePackages) também tem que ser diferente dos outros
     * 4 - O config do dataSource pode ser extraído do properties
     * */

    @Bean(name = "intra_datasource")
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/intranet");
        dataSourceBuilder.username("admin");
        dataSourceBuilder.password("admin");
        return dataSourceBuilder.build();
    }

    @Bean(name = "intra_EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean barEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("intra_datasource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages("com.springbootmultipledatasourceliquibase.domain.intranet.entidade")
                .persistenceUnit("Carro")
                .build();
    }

    @Bean(name = "intra_transactionManager")
    public PlatformTransactionManager barTransactionManager(
            @Qualifier("intra_EntityManagerFactory") EntityManagerFactory assisEntityManagerFactory) {
        return new JpaTransactionManager(assisEntityManagerFactory);
    }

}
