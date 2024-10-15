package com.richz.frame.mapper;

import com.richz.frame.entity.Issue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author honor
* @description 针对表【issue(问题表)】的数据库操作Mapper
* @createDate 2024-10-14 14:23:09
* @Entity com.richz.frame.entity.Issue
*/
@Mapper
public interface IssueMapper extends BaseMapper<Issue> {

}




