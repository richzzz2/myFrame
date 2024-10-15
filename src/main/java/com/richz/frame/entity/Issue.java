package com.richz.frame.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 问题表
 * @TableName issue
 */
@TableName(value ="issue")
@Data
public class Issue implements Serializable {
    /**
     * ID
     */
    @TableId
    private String id;

    /**
     * 线路ID（编码）
     */
    private String lineId;

    /**
     * 问题分类1
     */
    private String cate1;

    /**
     * 问题分类2
     */
    private String cate2;

    /**
     * 问题处理方式
     */
    private String sourceType;

    /**
     * 问题来源ID
     */
    private String sourceId;

    /**
     * 问题描述
     */
    private String issueDesc;

    /**
     * 问题内容
     */
    private String content;

    /**
     * 问题解决方式（项目解决：1，运维解决：2）
     */
    private Integer solutionType;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 县审核 1-通过  2-驳回
     */
    private Integer examineStatus;

    /**
     * 审核时间
     */
    private Date examineTime;

    /**
     * 问题反馈
     */
    private String issueExplain;

    /**
     * 文件ID
     */
    private String fileId;

    /**
     * 问题设备
     */
    private String issueDevice;

    /**
     * 是否反馈
     */
    private String isFeedback;

    /**
     * 问题来源类型
     */
    private String suorceProblemType;

    /**
     * 是否提交  Y : N
     */
    private String commitIssue;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}