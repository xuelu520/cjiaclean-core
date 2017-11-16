package com.huazhu.hvip.member.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author cmy
 * @create 2017-08-10 13:46
 **/
@Entity
@Table(name = "feedback")
public class Feedback {
    private Long feedbackId;
    private String feedbackContent;
    private Long memberId;
    private String status;
    private String messageType;
    private String createUser;
    private Timestamp createTime;
    private String updateUser;
    private Timestamp updateTime;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "feedbackId")
    public Long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    @Basic
    @Column(name = "feedbackContent")
    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    @Basic
    @Column(name = "memberId")
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "messageType")
    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    @Basic
    @Column(name = "createUser")
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Basic
    @Column(name = "createTime")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "updateUser")
    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Basic
    @Column(name = "updateTime")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Feedback feedback = (Feedback) o;

        if (feedbackId != null ? !feedbackId.equals(feedback.feedbackId) : feedback.feedbackId != null) return false;
        if (feedbackContent != null ? !feedbackContent.equals(feedback.feedbackContent) : feedback.feedbackContent != null)
            return false;
        if (memberId != null ? !memberId.equals(feedback.memberId) : feedback.memberId != null) return false;
        if (status != null ? !status.equals(feedback.status) : feedback.status != null) return false;
        if (messageType != null ? !messageType.equals(feedback.messageType) : feedback.messageType != null)
            return false;
        if (createUser != null ? !createUser.equals(feedback.createUser) : feedback.createUser != null) return false;
        if (createTime != null ? !createTime.equals(feedback.createTime) : feedback.createTime != null) return false;
        if (updateUser != null ? !updateUser.equals(feedback.updateUser) : feedback.updateUser != null) return false;
        if (updateTime != null ? !updateTime.equals(feedback.updateTime) : feedback.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = feedbackId != null ? feedbackId.hashCode() : 0;
        result = 31 * result + (feedbackContent != null ? feedbackContent.hashCode() : 0);
        result = 31 * result + (memberId != null ? memberId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (messageType != null ? messageType.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateUser != null ? updateUser.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
