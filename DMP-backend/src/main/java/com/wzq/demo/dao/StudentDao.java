package com.wzq.demo.dao;

import com.wzq.demo.bean.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wzq
 * @create 2023-02-13 22:25
 */
@Repository
public interface StudentDao {

    List<Student> getAllStudent();

}
