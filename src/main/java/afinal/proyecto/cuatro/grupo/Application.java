package afinal.proyecto.cuatro.grupo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.Date;
import java.util.TimeZone;

@SpringBootApplication
public class Application  {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    public void init(){
        TimeZone.setDefault(TimeZone.getTimeZone("America/Argentina/Buenos_Aires"));
        System.out.println("Spring boot application running in 'America/Argentina/Buenos_Aires' timezone :"+ new Date());
        System.out.println("DATASOURCE = " + dataSource);
        ComboPooledDataSource ds = (ComboPooledDataSource) dataSource;
        System.out.println("Instace of DBCP basic data source: " + ds);
        System.out.println("Connection Pool size : " + ds.getMaxPoolSize());
        System.out.println("Min connection pool size: " + ds.getMinPoolSize());
        System.out.println("Max statements: " + ds.getMaxStatements());
        System.out.println("Url: " + ds.getJdbcUrl());
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
}
