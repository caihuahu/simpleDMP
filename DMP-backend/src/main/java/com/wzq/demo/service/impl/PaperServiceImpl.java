package com.wzq.demo.service.impl;

import com.wzq.demo.bean.Paper;
import com.wzq.demo.dao.PaperDao;
import com.wzq.demo.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wzq
 * @create 2023-02-13 21:54
 */
@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    PaperDao paperDao;

    @Override
    public List<Paper> getAllPaper() {
        return paperDao.getAllPaper();
    }
}
