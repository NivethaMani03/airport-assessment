package airportassessment.config;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = {"airportassessment.repositories"}, entityManagerFactoryRef = "airportEntityManager"
        , transactionManagerRef = "airportTransactionManager")
@EnableTransactionManagement(proxyTargetClass = true, mode = AdviceMode.PROXY)
public class AirportAssessmentConfig {

    @PersistenceContext(unitName = "airportPersistenceContext")
    @Bean(name = "airportEntityManager")
    public LocalContainerEntityManagerFactoryBean airportEntityManager(EntityManagerFactoryBuilder builder, @Qualifier("airportDataSource") DataSource airportDataSource) {
        return builder.dataSource(airportDataSource).packages("airportassessment.models").persistenceUnit("airportPersistenceUnit").build();
    }

    @Bean(name = "airportTransactionManager")
    public PlatformTransactionManager airportTransactionManager(@Qualifier("airportEntityManager") LocalContainerEntityManagerFactoryBean airManagerFactoryBean) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(airManagerFactoryBean.getObject());
        return transactionManager;
    }

    @Bean(name = "airportDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource airportDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
}
