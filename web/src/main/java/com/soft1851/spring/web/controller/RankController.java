package com.soft1851.spring.web.controller;

import com.soft1851.spring.web.service.RankService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/")
/**
 * Rank哔哩哔哩数据展示
 */
public class RankController {
    @Resource
    private RankService rankService;

    @GetMapping("/rank")
    public String topic(Model model){
        model.addAttribute("ranks",rankService.queryAll());
        return "rank";
    }
}
