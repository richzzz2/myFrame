package com.richz.frame.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.richz.frame.entity.Issue;
import com.richz.frame.entity.vo.ResponseData;
import com.richz.frame.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "test")
public class TestController {
    @Autowired
    private IssueService issueService;
    @RequestMapping(value = "test")
    public ResponseData test(){
        List<Issue> list = issueService.list(new LambdaQueryWrapper<Issue>().select(Issue::getCommitIssue));
        return new ResponseData(list);
    }
}
