package com.huazhu.hvip.order.vo;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class OrderCountVO implements Serializable {

    private Integer totalCount; //订单总数
    private Integer pendingCount; //待处理数
    private Integer waitPayCount; //待付款数
    private Integer paidCount; //已付款数
    private Integer cancelCount; //取消数
    private Integer completeCount; //已完成数
    private Integer refundCount; //已退款数
    private Integer postingCount; //已入账数
    private Integer adjustCount; //已调账数
    private Integer reserveLeaseCount; //预订租赁中数目
    private Integer leaseCount; // 租赁中的数目
    private Integer returnLeaseCount; //归还

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPendingCount() {
        return pendingCount;
    }

    public void setPendingCount(Integer pendingCount) {
        this.pendingCount = pendingCount;
    }

    public Integer getWaitPayCount() {
        return waitPayCount;
    }

    public void setWaitPayCount(Integer waitPayCount) {
        this.waitPayCount = waitPayCount;
    }

    public Integer getPaidCount() {
        return paidCount;
    }

    public void setPaidCount(Integer paidCount) {
        this.paidCount = paidCount;
    }

    public Integer getCancelCount() {
        return cancelCount;
    }

    public void setCancelCount(Integer cancelCount) {
        this.cancelCount = cancelCount;
    }

    public Integer getCompleteCount() {
        return completeCount;
    }

    public void setCompleteCount(Integer completeCount) {
        this.completeCount = completeCount;
    }

    public Integer getRefundCount() {
        return refundCount;
    }

    public void setRefundCount(Integer refundCount) {
        this.refundCount = refundCount;
    }

    public Integer getPostingCount() {
        return postingCount;
    }

    public void setPostingCount(Integer postingCount) {
        this.postingCount = postingCount;
    }

    public Integer getAdjustCount() {
        return adjustCount;
    }

    public void setAdjustCount(Integer adjustCount) {
        this.adjustCount = adjustCount;
    }

    public Integer getReserveLeaseCount() {
        return reserveLeaseCount;
    }

    public void setReserveLeaseCount(Integer reserveLeaseCount) {
        this.reserveLeaseCount = reserveLeaseCount;
    }

    public Integer getLeaseCount() {
        return leaseCount;
    }

    public void setLeaseCount(Integer leaseCount) {
        this.leaseCount = leaseCount;
    }

    public Integer getReturnLeaseCount() {
        return returnLeaseCount;
    }

    public void setReturnLeaseCount(Integer returnLeaseCount) {
        this.returnLeaseCount = returnLeaseCount;
    }
}
