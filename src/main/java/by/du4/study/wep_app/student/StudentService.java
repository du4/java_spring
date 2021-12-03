package by.du4.study.wep_app.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> maybeStudent = studentRepository.findStudentByEmail(student.getEmail());
        if (maybeStudent.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalStateException("Student with id " + id + " does't exist.");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("Student with id " + id + " does't exist."));
        if (name!=null && !name.isBlank() && name.length()>0 && !student.getName().equals(name)){
            student.setName(name);
        }
        if (email!=null && !email.isBlank() && email.length() > 0 && !student.getEmail().equals(email)) {
            if(studentRepository.findStudentByEmail(email).isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }
}
