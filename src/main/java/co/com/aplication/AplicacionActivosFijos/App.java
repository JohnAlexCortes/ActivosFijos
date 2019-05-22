package co.com.aplication.AplicacionActivosFijos;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableAutoConfiguration
public class App {
    public static void main( String[] args ) throws IOException {
     SpringApplication.run(App.class, args);
     
     }
}
