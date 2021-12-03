package by.du4.study.wep_app.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student du4 = new Student( "Du4", LocalDate.of(1982, Month.JULY, 3), "du4@gmail.com");
            Student alex = new Student( "Alex", LocalDate.of(1992, Month.JULY, 4), "alex@gmail.com");

            repository.saveAll(List.of(du4, alex));
        };
    }
}
