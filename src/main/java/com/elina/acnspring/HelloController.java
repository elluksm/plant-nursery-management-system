package com.elina.acnspring;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.elina.acnspring.jpa.Student;
import com.elina.acnspring.repositories.StudentRepository;

@RestController
@RequestMapping("api-hello")
public class HelloController {
	
	@Autowired
	StudentRepository studentRepository;
	
	
//    @GetMapping({"/", "/hello"})
	@RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return "hello";
    }
    //Šis ir līdzīgi, kā augstāk #25-tajā rindā;
    @GetMapping({"/students"})
    @ResponseBody
    public String helloStudents() {
    	List<Student> students = this.studentRepository.findAll( );    	
    	String studString = students.stream().map(st -> st.getName()).collect(Collectors.joining("</br>"));
    	
    	return "hello Students</br></br>"+studString+"<br>END OF LIST";
    }
    
    
}