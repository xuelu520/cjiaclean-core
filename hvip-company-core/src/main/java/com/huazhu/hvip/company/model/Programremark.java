package com.huazhu.hvip.company.model;

import javax.persistence.*;

/**
 * @author cmy
 * @create 2017-10-31 14:15
 **/
@Entity
@Table(name = "programremark", schema = "", catalog = "cjiaclean_company")
public class Programremark {
    private Integer id;
    private Long programId;
    private String optionType;
    private String reason;
    private String createDate;
    private String createBy;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ProgramID")
    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    @Basic
    @Column(name = "OptionType")
    public String getOptionType() {
        return optionType;
    }

    public void setOptionType(String optionType) {
        this.optionType = optionType;
    }

    @Basic
    @Column(name = "Reason")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Basic
    @Column(name = "CreateDate")
    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "CreateBy")
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Programremark that = (Programremark) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (programId != null ? !programId.equals(that.programId) : that.programId != null) return false;
        if (optionType != null ? !optionType.equals(that.optionType) : that.optionType != null) return false;
        if (reason != null ? !reason.equals(that.reason) : that.reason != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (createBy != null ? !createBy.equals(that.createBy) : that.createBy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (programId != null ? programId.hashCode() : 0);
        result = 31 * result + (optionType != null ? optionType.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        return result;
    }
}
