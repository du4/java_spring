package by.du4.study.wep_app.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudents() {
        return List.of(new Student(1L,"Du4",39, LocalDate.of(1982, Month.JULY, 3),"du4@gmail.com"));
    }

}
