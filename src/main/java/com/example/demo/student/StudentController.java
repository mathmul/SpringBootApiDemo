package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @ResponseBody
    public List<Student> getStudents() {
        return this.studentService.getStudents();
    }

    @GetMapping(path = "{studentId}")
    @ResponseBody
    public Optional<Student> getStudent(@PathVariable("studentId") Long studentId) {
        return this.studentService.getStudent(studentId);
    }

    @PostMapping
    @ResponseBody
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    @ResponseBody
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    @ResponseBody
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam (required = false) String name,
            @RequestParam (required = false) String email
    ) {
        studentService.updateStudent(studentId, name, email);
    }
}
