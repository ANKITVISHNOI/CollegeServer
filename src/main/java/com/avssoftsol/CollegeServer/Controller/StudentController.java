package com.avssoftsol.CollegeServer.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avssoftsol.CollegeServer.Model.Student;
import com.avssoftsol.CollegeServer.Repository.StudentRepository;

/**
 * @author ANKIT
 *
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/student")
public class StudentController 	{
	@Autowired 
	StudentRepository studentRepository;

	@GetMapping("/listStudent")
	public List<Student> getStudentList(){
		return studentRepository.findAll();
	}

	@PostMapping("/saveStudent")
	public Student saveStudent(@Valid @RequestBody Student student){
		return studentRepository.save(student);
	}

	@GetMapping("/getById/{id}")
	public Optional<Student> getStudentById(@PathVariable(value = "id") Long id){
		return studentRepository.findById(id);
	}

	@PutMapping("/updateStudent/{id}")
	public Student updateStudent(@PathVariable(value = "id") Long id, @Valid @RequestBody Student student){
		Student studentOld = studentRepository.getOne(id);
		if (studentOld != null) {
			studentOld.setFirstName(student.getFirstName());
			studentOld.setLastName(student.getLastName());
			studentOld.setEmail(student.getEmail());
			studentOld.setPhone(student.getPhone());
		}
		return studentRepository.save(studentOld);
	}

	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable(value="id") Long id){
		Student student = studentRepository.getOne(id);
		studentRepository.delete(student);
		return ResponseEntity.ok().build();
	}

}
