package com.wzq.demo.controller;

import com.wzq.demo.bean.Paper;
import com.wzq.demo.service.PaperService;
import com.wzq.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wzq
 * @create 2023-02-13 21:52
 */
@RestController
@RequestMapping("/cdsic/paper")
public class PaperController {

    @Autowired
    PaperService paperService;

    @RequestMapping("/getAllPaper")
    public R<List<Paper>> getAllpaper() {
        return R.of(200, "success", paperService.getAllPaper());
    }

}
