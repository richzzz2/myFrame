package com.richz.frame.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.richz.frame.aspect.annotation.LogAnnotation;
import com.richz.frame.constant.LogTypeConstant;
import com.richz.frame.entity.Issue;
import com.richz.frame.entity.vo.ResponseData;
import com.richz.frame.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "test")
public class TestController {
    @Autowired
    private IssueService issueService;
    @GetMapping(value = "test")
    @LogAnnotation(logType = LogTypeConstant.CLASS_TEST)
    public ResponseData test(@RequestParam("id") Integer id,@RequestParam("age")String age){
        List<Issue> list = issueService.list(new LambdaQueryWrapper<Issue>().select(Issue::getCommitIssue));
        return new ResponseData(list);
    }
}
