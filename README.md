# Spring Boot + Liquibase + Multiple Datasource + Postgres + lombok

#Implementação do proejeto
  - Nesse projeto iremos criar dois datasources um para tabelas corporativas e outro para o projeto da intranet(suposição).
  
#Banco de Dados
  - Nesse projeto iremos usar Postgres.
  
#Organização dos pacotes
  - É importante lembrar que as models deve ser colocadas em pacotes diferentes.
  
        -- src
          -- main
            -- java
              -- com
                -- springbootmultipledatasourceliquibase
                  -- domain
                    -- corporativo
                    -- intranet
 
# Configuração de conexão com o Banco de Dados
    Abaixo temos as duas configurações de conexão com os databases
    application.properties
       
      spring.jpa.database=default
      spring.main.allow-bean-definition-overriding=true
      spring.liquibase.change-log
      spring.jpa.show-sql=true
      
      //Essa linha é importante para desabilitar o liquibase quando a aplicação for "estartada"
      spring.liquibase.enabled=false

      # PostgreSQL DB - Corporativo
      spring.primarydatasource.url=jdbc:postgresql://localhost:5432/corporativo
      spring.primarydatasource.username=admin
      spring.primarydatasource.password=admin
      spring.primarydatasource.driver-class-name=org.postgresql.Driver

      # PostgreSQL DB - Intranet
      spring.secondDatasource.url=jdbc:postgresql://localhost:5432/intranet
      spring.secondDatasource.username=admin
      spring.secondDatasource.password=admin
      assis.secondDatasource.driver-class-name=org.postgresql.Driver
      
# Criação de Database, Schema, Tabelas...
- Cada Database terá o seu properties e suas configurações
- Abaixo temos como ficará os pacotes 

      --src
        --main
          --resources
            --liquibase
              --liquibase-dev-corp.properties
              --liquibase-dev-intra.properties
              
- Conexão do Banco de Dados e a chamada para o changeLogFile

      changeLogFile:src/main/resources/liquibase/db/corp/liquibase_corp.xml

      driver:org.postgresql.Driver
      changelogSchemaName:public
      verbose:true 
      dropFirst:false
      url:jdbc:postgresql://localhost:5432/corporativo
      username:admin
      password:admin

# Configuração do pom.xml
- Configurações dos profiles para cada datasource
        
          <profile>
            <id>corporativo</id>
            <build>
                <plugins>
                    <plugin>
                        <groupId>org.liquibase</groupId>
                        <artifactId>liquibase-maven-plugin</artifactId>
                        <version>${liquibase.version}</version>
                        <configuration>
                            <propertyFile>src/main/resources/liquibase/liquibase-dev-corp.properties
                            </propertyFile>
                            <url>${dbUrl2}</url>
                            <driver>org.postgresql.Driver</driver>
                            <username>${dbUser}</username>
                            <password>${dbPass}</password>
                            <defaultSchemaName>public</defaultSchemaName>
                            <propertyFileWillOverride>true</propertyFileWillOverride>
                            <promptOnNonLocalDatabase>false</promptOnNonLocalDatabase>
                            <outputDefaultSchema>true</outputDefaultSchema>
                            <dropFirst>${dropFirst}</dropFirst>
                        </configuration>
                        <executions>
                            <execution>
                                <phase>process-resources</phase>
                                <goals>
                                    <goal>update</goal>
                                </goals>
                            </execution>
                        </executions>
                    </plugin>
                </plugins>
            </build>
        </profile>
        
# Classe de Configuração das conexões dos databases

    /*
     * 1 - O nome do ententyManager tem quer ter o nome diferente dos outros;
     * 2 - O nome da transactionManagerRef tem que ser diferente das outras;
     * 3 - O Path (basePackages) também tem que ser diferente dos outros
     * 4 - O config do dataSource pode ser extraído do properties
     * 5 - A anotação @Primary define qual será a primeira configuração a ser rodada
     * */
     
- Segue uma das configurações

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

