package com.zhiyou100.qa.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author:Rain
 * @date 2019/11/1 10:16
 * @desc
 */
@Entity
@Table(name = "tb_problem")
public class Problem {

    @Id
/*  @GenericGenerator(name = "aa",strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "aa" )*/
    private String id;//ID
    private String title;//标题
    private String content;//内容
    private java.util.Date createtime;//创建日期
    private java.util.Date updatetime;//修改日期
    private String userid;//用户ID
    private String nickname;//昵称
    private Long visits;//浏览量
    private Long thumbup;//点赞数
    private Long reply;//回复数
    private String solve;//是否解决
    private String replyname;//回复人昵称
    private Date replytime;//回复日期

    public Problem() {
    }

    public Problem(String id, String title, String content, Date createtime, Date updatetime, String userid, String nickname, Long visits, Long thumbup, Long reply, String solve, String replyname, Date replytime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.userid = userid;
        this.nickname = nickname;
        this.visits = visits;
        this.thumbup = thumbup;
        this.reply = reply;
        this.solve = solve;
        this.replyname = replyname;
        this.replytime = replytime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Long getVisits() {
        return visits;
    }

    public void setVisits(Long visits) {
        this.visits = visits;
    }

    public Long getThumbup() {
        return thumbup;
    }

    public void setThumbup(Long thumbup) {
        this.thumbup = thumbup;
    }

    public Long getReply() {
        return reply;
    }

    public void setReply(Long reply) {
        this.reply = reply;
    }

    public String getSolve() {
        return solve;
    }

    public void setSolve(String solve) {
        this.solve = solve;
    }

    public String getReplyname() {
        return replyname;
    }

    public void setReplyname(String replyname) {
        this.replyname = replyname;
    }

    public Date getReplytime() {
        return replytime;
    }

    public void setReplytime(Date replytime) {
        this.replytime = replytime;
    }
}
