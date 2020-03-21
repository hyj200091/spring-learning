package com.soft1851.spring.web.controller;

import com.alibaba.fastjson.JSON;
import com.soft1851.spring.web.service.ForumService;
import com.soft1851.spring.web.util.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/3/21
 */
@RestController
@RequestMapping(value = "forum")
public class ForumController {

    @Autowired
    private ForumService forumService;

    /**
     * 查询所有
     * @return List
     */
    @RequestMapping(value = "/list",produces = "application/json;charset=utf-8")
    public String getForums(){
        ResponseObject ro = new ResponseObject(1,"成功",forumService.selectAll());
        return JSON.toJSONString(ro);
    }

    /**
     * 根据id查询
     * @param forumId forumId
     * @return List
     */
    @GetMapping(value = "/get",produces = "application/json;charset=utf-8")
    public String getById(@RequestParam Integer forumId) {
        ResponseObject ro = new ResponseObject(1,"成功",forumService.get(forumId));
        return JSON.toJSONString(ro);
    }

    @GetMapping(value = "/delete",produces = "application/json;charset=utf-8")
    public String deleteById(@RequestParam Integer forumId){
        ResponseObject ro = new ResponseObject(1,"成功",forumService.delete(forumId));
        return JSON.toJSONString(ro);
    }


}
