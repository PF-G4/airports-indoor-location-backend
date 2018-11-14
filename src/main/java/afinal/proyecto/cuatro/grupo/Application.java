package afinal.proyecto.cuatro.grupo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.TimeZone;

@SpringBootApplication
public class Application  {

    @PostConstruct
    public void init(){
        TimeZone.setDefault(TimeZone.getTimeZone("America/Argentina/Buenos_Aires"));
        System.out.println("Spring boot application running in 'America/Argentina/Buenos_Aires' timezone :"+ new Date());
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
}
