package com.wzq.demo.dao;

import com.wzq.demo.bean.Paper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wzq
 * @create 2023-02-13 21:52
 */
@Repository
public interface PaperDao {

    List<Paper> getAllPaper();

}
