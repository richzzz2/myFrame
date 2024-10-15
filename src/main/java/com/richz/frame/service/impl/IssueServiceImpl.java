package com.richz.frame.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.richz.frame.entity.Issue;
import com.richz.frame.service.IssueService;
import com.richz.frame.mapper.IssueMapper;
import org.springframework.stereotype.Service;

/**
* @author honor
* @description 针对表【issue(问题表)】的数据库操作Service实现
* @createDate 2024-10-14 14:23:09
*/
@Service
public class IssueServiceImpl extends ServiceImpl<IssueMapper, Issue>
    implements IssueService{

}




