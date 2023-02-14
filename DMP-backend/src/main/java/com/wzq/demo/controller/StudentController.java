package com.wzq.demo.controller;

import com.wzq.demo.bean.Student;
import com.wzq.demo.service.StudentService;
import com.wzq.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wzq
 * @create 2023-02-13 22:22
 */
@RestController
@RequestMapping("/cdsic/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("getAllStudent")
    public R<List<Student>> getAllStudent() {
        List<Student> allStudent = studentService.getAllStudent();

//        return allStudent.toString();
        return R.of(200, "success", allStudent);
    }

}
