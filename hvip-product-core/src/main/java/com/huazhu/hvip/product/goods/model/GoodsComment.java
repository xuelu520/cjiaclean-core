package com.huazhu.hvip.product.goods.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author cmy
 * @create 2017-08-25 15:48
 **/
@Entity
@Table(name = "vip_goodscomment")
public class GoodsComment {
    private Long commentId;
    private Long goodsId;
    private String commentContext;
    private String commentStatus;
    private String showFlag;
    private String createUser;
    private Date createTime;

    @Id
    @Column(name = "commentId")
    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }


    @Basic
    @Column(name = "goodsId")
    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "commentContext")
    public String getCommentContext() {
        return commentContext;
    }

    public void setCommentContext(String commentContext) {
        this.commentContext = commentContext;
    }

    @Basic
    @Column(name = "commentStatus")
    public String getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus;
    }

    @Basic
    @Column(name = "showFlag")
    public String getShowFlag() {
        return showFlag;
    }

    public void setShowFlag(String showFlag) {
        this.showFlag = showFlag;
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
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsComment that = (GoodsComment) o;

        if (commentId != null ? !commentId.equals(that.commentId) : that.commentId != null) return false;
        if (goodsId != null ? !goodsId.equals(that.goodsId) : that.goodsId != null) return false;
        if (commentContext != null ? !commentContext.equals(that.commentContext) : that.commentContext != null)
            return false;
        if (commentStatus != null ? !commentStatus.equals(that.commentStatus) : that.commentStatus != null)
            return false;
        if (showFlag != null ? !showFlag.equals(that.showFlag) : that.showFlag != null) return false;
        if (createUser != null ? !createUser.equals(that.createUser) : that.createUser != null) return false;
        return !(createTime != null ? !createTime.equals(that.createTime) : that.createTime != null);

    }
    @Override
    public int hashCode() {
        int result = commentId != null ? commentId.hashCode() : 0;
        result = 31 * result + (goodsId != null ? goodsId.hashCode() : 0);
        result = 31 * result + (commentContext != null ? commentContext.hashCode() : 0);
        result = 31 * result + (commentStatus != null ? commentStatus.hashCode() : 0);
        result = 31 * result + (showFlag != null ? showFlag.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
