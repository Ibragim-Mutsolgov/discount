package vip.redcode.discount.core.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "discountEntityManagerFactory",
        transactionManagerRef = "discountTransactionManager",
        basePackages = "vip.redcode.discount.core.repository"
)
public class DiscountHibernateConfiguration {

    @Bean("discountDataSource")
    public DataSource dataSource() {
        String url = "jdbc:postgresql://172.16.3.6:5432/discount";
        String driver = "org.postgresql.Driver";
        String username = "nsa";
        String password = "SSDbuyitCheap2022";
        return DataSourceBuilder
                .create()
                .username(username)
                .password(password)
                .url(url)
                .driverClassName(driver)
                .build();
    }

    @Bean("discountEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPersistenceUnitName("discountEntityManagerFactory");
        factoryBean.setPackagesToScan("vip.redcode.discount.core.model");
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        Properties properties = new Properties();
        properties.put("hibernate.hbm2ddl.auto", "update");
        factoryBean.setJpaProperties(properties);
        return factoryBean;
    }

    @Bean("discountTransactionManager")
    public PlatformTransactionManager platformTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }
}
