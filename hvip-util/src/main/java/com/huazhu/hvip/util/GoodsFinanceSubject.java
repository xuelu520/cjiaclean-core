package com.huazhu.hvip.util;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class GoodsFinanceSubject {

    private Long goodsId;

    private String debitCode;

    private String debitAdjustCode;

    private String remark;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getDebitCode() {
        return debitCode;
    }

    public void setDebitCode(String debitCode) {
        this.debitCode = debitCode;
    }

    public String getDebitAdjustCode() {
        return debitAdjustCode;
    }

    public void setDebitAdjustCode(String debitAdjustCode) {
        this.debitAdjustCode = debitAdjustCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
