package com.skillmanagement.cvparser.Student;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;


	public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents(){
		return studentRepository.findAll();
	}


    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail =
        studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
        System.out.println(student);

    }


    public void deleteStudent(Long studentId) {
        boolean studentexists = studentRepository.existsById(studentId);
        if(!studentexists){
            throw new IllegalStateException("student with id" + studentId + "does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
          Student student =  studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("student with id" + studentId + "does not exist"));
        
        if(name != null && name.length() != 0 && !Objects.equals(name, student.getName())){
            student.setName(name);
        }

        if(email != null && email.length() != 0 && !Objects.equals(email, student.getEmail())){
        Optional<Student> studentByEmail =
        studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
            
        }
        student.setEmail(email);
    }
    
    
}

}
