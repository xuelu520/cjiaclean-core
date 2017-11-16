package com.huazhu.hvip.company.vo;

import com.huazhu.hvip.base.PageCondition;

/**
 * @author cmy
 * @create 2017-10-31 14:19
 **/
public class ProgramremarkVO extends PageCondition {

    private Integer id;
    private Long programId;
    private String optionType;
    private String reason;
    private String createDate;
    private String createBy;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public String getOptionType() {
        return optionType;
    }

    public void setOptionType(String optionType) {
        this.optionType = optionType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
