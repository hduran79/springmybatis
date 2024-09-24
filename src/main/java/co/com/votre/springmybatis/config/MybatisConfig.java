package co.com.votre.springmybatis.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;

import org.apache.ibatis.session.SqlSessionFactory;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan(value = "co.com.votre.springmybatis.infraestructure.mapper", 
sqlSessionFactoryRef = "votreSessionFactory")
public class MybatisConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.votre")
    public DataSourceProperties votreDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "votreDatasource")
    public DataSource dataSourceVotre() {
        HikariDataSource dataSource = (HikariDataSource) votreDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
        dataSource.setConnectionTestQuery("values 1");

        return dataSource;
    }

    @Primary
    @Bean(name = "votreTransactionManager")
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSourceVotre());
    }

    @Primary
    @Bean(name = "votreSessionFactory")
    public SqlSessionFactory votreSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSourceVotre());
        //factoryBean.setTypeHandlersPackage("votre.com.co.apache_camel.infraestructure.mapper.handler");
        //factoryBean.setTypeAliasesPackage("votre.com.co.apache_camel.dto");
        return factoryBean.getObject();
    }

}
