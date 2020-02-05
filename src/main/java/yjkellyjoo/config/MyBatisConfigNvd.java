package yjkellyjoo.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "yjkellyjoo.nvd.dao", sqlSessionFactoryRef = "sqlSessionFactoryNvd", sqlSessionTemplateRef = "sqlSessionTemplateNvd")
//SqlSessionFactory is created from dsOne and then a SqlSessionTemplate is created from the created SqlSessionFactory.
public class MyBatisConfigNvd {
    @Resource(name = "dataSourceNvd")
    DataSource dataSourceNvd;

    @Bean
    SqlSessionFactory sqlSessionFactoryNvd() {
        SqlSessionFactory sessionFactory = null;
        try {
            SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
            bean.setDataSource(dataSourceNvd);
            sessionFactory = bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }

    @Bean
    SqlSessionTemplate sqlSessionTemplateNvd() {
        return new SqlSessionTemplate(sqlSessionFactoryNvd());
    }
}
