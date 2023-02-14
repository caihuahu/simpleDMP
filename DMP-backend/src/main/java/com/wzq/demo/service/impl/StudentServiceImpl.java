package com.wzq.demo.service.impl;

import com.wzq.demo.bean.Student;
import com.wzq.demo.dao.StudentDao;
import com.wzq.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wzq
 * @create 2023-02-13 22:24
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Override
    public List<Student> getAllStudent() {
        return studentDao.getAllStudent();
    }
}
