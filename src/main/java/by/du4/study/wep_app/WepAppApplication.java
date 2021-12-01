package by.du4.study.wep_app;

import by.du4.study.wep_app.stedent.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class WepAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WepAppApplication.class, args);
	}

	@GetMapping
	public List<Student> hello() {
		return List.of(new Student(1L,"Du4",39, LocalDate.of(1982, Month.JULY, 3),"du4@gmail.com"));
	}

}
