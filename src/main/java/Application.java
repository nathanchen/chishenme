import com.chishenme.user.dao.UserMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * User: nathanchen Date: 18/12/2014 Time: 4:23 PM Description:
 */
@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    @Scope(value = "singleton")
    public DataSource getDataSource()
    {
        DriverManagerDataSource driverManeagerDataSource = new DriverManagerDataSource();
        driverManeagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManeagerDataSource.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8");
        driverManeagerDataSource.setUsername("root");
        driverManeagerDataSource.setPassword("081200");

        try
        {
            Connection connection = driverManeagerDataSource.getConnection();
            Statement statement = connection.createStatement();
            String createUserSQL = "CREATE TABLE IF NOT EXISTS tbl_users ( "
                    + "id serial PRIMARY KEY, "
                    + "name varchar(100) UNIQUE NOT NULL, "
                    + "created timestamp DEFAULT CURRENT_TIMESTAMP ); ";
            statement.execute(createUserSQL);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return driverManeagerDataSource;
    }

    @Bean
    public SqlSessionFactory getSqlSessionFactory()
    {
        Resource[] resources = new Resource[] { new ClassPathResource(
                new ClassPathResource(getMapperXMLPath(UserMapper.class)).getPath()
        )};
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(getDataSource());
        sqlSessionFactoryBean.setMapperLocations(resources);

        SqlSessionFactory sqlSessionFactory = null;

        try
        {
            sqlSessionFactory = sqlSessionFactoryBean.getObject();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(0);
        }
        return sqlSessionFactory;
    }

    @Bean
    public UserMapper getUserMapper()
    {
        SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(getSqlSessionFactory());
        return sessionTemplate.getMapper(UserMapper.class);
    }

    public static String getMapperXMLPath(Class<?> clazz)
    {
        return new ClassPathResource(clazz.getName().replace(".", File.separator).concat(".xml")).getPath();
    }
}