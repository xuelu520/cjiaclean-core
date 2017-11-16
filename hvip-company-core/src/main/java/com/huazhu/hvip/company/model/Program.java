package com.huazhu.hvip.company.model;

import javax.persistence.*;

/**
 * @author cmy
 * @create 2017-10-31 14:15
 **/
@Entity
@Table(name = "program", schema = "", catalog = "cjiaclean_company")
public class Program {
    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @javax.persistence.Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String programType;

    @Basic
    @javax.persistence.Column(name = "ProgramType")
    public String getProgramType() {
        return programType;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }

    private String programName;

    @Basic
    @javax.persistence.Column(name = "ProgramName")
    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    private String startDate;

    @Basic
    @javax.persistence.Column(name = "StartDate")
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    private String endDate;

    @Basic
    @javax.persistence.Column(name = "EndDate")
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    private String paymentName;

    @Basic
    @javax.persistence.Column(name = "PaymentName")
    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    private String paymentAccount;

    @Basic
    @javax.persistence.Column(name = "PaymentAccount")
    public String getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(String paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    private String status;

    @Basic
    @javax.persistence.Column(name = "Status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private Integer startOrStop;

    @Basic
    @javax.persistence.Column(name = "StartOrStop")
    public Integer getStartOrStop() {
        return startOrStop;
    }

    public void setStartOrStop(Integer startOrStop) {
        this.startOrStop = startOrStop;
    }

    private String address;

    @Basic
    @javax.persistence.Column(name = "Address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String customer;

    @Basic
    @javax.persistence.Column(name = "Customer")
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    private String customerPhone;

    @Basic
    @javax.persistence.Column(name = "CustomerPhone")
    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    private Integer totalFloor;

    @Basic
    @javax.persistence.Column(name = "TotalFloor")
    public Integer getTotalFloor() {
        return totalFloor;
    }

    public void setTotalFloor(Integer totalFloor) {
        this.totalFloor = totalFloor;
    }

    private Integer totalRoom;

    @Basic
    @javax.persistence.Column(name = "TotalRoom")
    public Integer getTotalRoom() {
        return totalRoom;
    }

    public void setTotalRoom(Integer totalRoom) {
        this.totalRoom = totalRoom;
    }

    private String businessPerson;

    @Basic
    @javax.persistence.Column(name = "BusinessPerson")
    public String getBusinessPerson() {
        return businessPerson;
    }

    public void setBusinessPerson(String businessPerson) {
        this.businessPerson = businessPerson;
    }

    private String businessPhone;

    @Basic
    @javax.persistence.Column(name = "BusinessPhone")
    public String getBusinessPhone() {
        return businessPhone;
    }

    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
    }

    private String servicesUpervisor;

    @Basic
    @javax.persistence.Column(name = "ServicesUpervisor")
    public String getServicesUpervisor() {
        return servicesUpervisor;
    }

    public void setServicesUpervisor(String servicesUpervisor) {
        this.servicesUpervisor = servicesUpervisor;
    }

    private String servicesUpervisorName;

    @Basic
    @javax.persistence.Column(name = "ServicesUpervisorName")
    public String getServicesUpervisorName() {
        return servicesUpervisorName;
    }

    public void setServicesUpervisorName(String servicesUpervisorName) {
        this.servicesUpervisorName = servicesUpervisorName;
    }

    private String projectExecutive;

    @Basic
    @javax.persistence.Column(name = "ProjectExecutive")
    public String getProjectExecutive() {
        return projectExecutive;
    }

    public void setProjectExecutive(String projectExecutive) {
        this.projectExecutive = projectExecutive;
    }

    private String projectExecutiveName;

    @Basic
    @javax.persistence.Column(name = "ProjectExecutiveName")
    public String getProjectExecutiveName() {
        return projectExecutiveName;
    }

    public void setProjectExecutiveName(String projectExecutiveName) {
        this.projectExecutiveName = projectExecutiveName;
    }

    private String programStatus;

    @Basic
    @javax.persistence.Column(name = "ProgramStatus")
    public String getProgramStatus() {
        return programStatus;
    }

    public void setProgramStatus(String programStatus) {
        this.programStatus = programStatus;
    }

    private String reason;

    @Basic
    @javax.persistence.Column(name = "Reason")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    private String createDate;

    @Basic
    @javax.persistence.Column(name = "CreateDate")
    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    private String createBy;

    @Basic
    @javax.persistence.Column(name = "CreateBy")
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    private String updateDate;

    @Basic
    @javax.persistence.Column(name = "UpdateDate")
    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    private String updateBy;

    @Basic
    @javax.persistence.Column(name = "UpdateBy")
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    private String programNo;

    @Basic
    @javax.persistence.Column(name = "ProgramNo")
    public String getProgramNo() {
        return programNo;
    }

    public void setProgramNo(String programNo) {
        this.programNo = programNo;
    }

    private String hotelNo;

    @Basic
    @javax.persistence.Column(name = "HotelNo")
    public String getHotelNo() {
        return hotelNo;
    }

    public void setHotelNo(String hotelNo) {
        this.hotelNo = hotelNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Program program = (Program) o;

        if (id != null ? !id.equals(program.id) : program.id != null) return false;
        if (programType != null ? !programType.equals(program.programType) : program.programType != null) return false;
        if (programName != null ? !programName.equals(program.programName) : program.programName != null) return false;
        if (startDate != null ? !startDate.equals(program.startDate) : program.startDate != null) return false;
        if (endDate != null ? !endDate.equals(program.endDate) : program.endDate != null) return false;
        if (paymentName != null ? !paymentName.equals(program.paymentName) : program.paymentName != null) return false;
        if (paymentAccount != null ? !paymentAccount.equals(program.paymentAccount) : program.paymentAccount != null)
            return false;
        if (status != null ? !status.equals(program.status) : program.status != null) return false;
        if (startOrStop != null ? !startOrStop.equals(program.startOrStop) : program.startOrStop != null) return false;
        if (address != null ? !address.equals(program.address) : program.address != null) return false;
        if (customer != null ? !customer.equals(program.customer) : program.customer != null) return false;
        if (customerPhone != null ? !customerPhone.equals(program.customerPhone) : program.customerPhone != null)
            return false;
        if (totalFloor != null ? !totalFloor.equals(program.totalFloor) : program.totalFloor != null) return false;
        if (totalRoom != null ? !totalRoom.equals(program.totalRoom) : program.totalRoom != null) return false;
        if (businessPerson != null ? !businessPerson.equals(program.businessPerson) : program.businessPerson != null)
            return false;
        if (businessPhone != null ? !businessPhone.equals(program.businessPhone) : program.businessPhone != null)
            return false;
        if (servicesUpervisor != null ? !servicesUpervisor.equals(program.servicesUpervisor) : program.servicesUpervisor != null)
            return false;
        if (servicesUpervisorName != null ? !servicesUpervisorName.equals(program.servicesUpervisorName) : program.servicesUpervisorName != null)
            return false;
        if (projectExecutive != null ? !projectExecutive.equals(program.projectExecutive) : program.projectExecutive != null)
            return false;
        if (projectExecutiveName != null ? !projectExecutiveName.equals(program.projectExecutiveName) : program.projectExecutiveName != null)
            return false;
        if (programStatus != null ? !programStatus.equals(program.programStatus) : program.programStatus != null)
            return false;
        if (reason != null ? !reason.equals(program.reason) : program.reason != null) return false;
        if (createDate != null ? !createDate.equals(program.createDate) : program.createDate != null) return false;
        if (createBy != null ? !createBy.equals(program.createBy) : program.createBy != null) return false;
        if (updateDate != null ? !updateDate.equals(program.updateDate) : program.updateDate != null) return false;
        if (updateBy != null ? !updateBy.equals(program.updateBy) : program.updateBy != null) return false;
        if (programNo != null ? !programNo.equals(program.programNo) : program.programNo != null) return false;
        if (hotelNo != null ? !hotelNo.equals(program.hotelNo) : program.hotelNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (programType != null ? programType.hashCode() : 0);
        result = 31 * result + (programName != null ? programName.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (paymentName != null ? paymentName.hashCode() : 0);
        result = 31 * result + (paymentAccount != null ? paymentAccount.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (startOrStop != null ? startOrStop.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (customerPhone != null ? customerPhone.hashCode() : 0);
        result = 31 * result + (totalFloor != null ? totalFloor.hashCode() : 0);
        result = 31 * result + (totalRoom != null ? totalRoom.hashCode() : 0);
        result = 31 * result + (businessPerson != null ? businessPerson.hashCode() : 0);
        result = 31 * result + (businessPhone != null ? businessPhone.hashCode() : 0);
        result = 31 * result + (servicesUpervisor != null ? servicesUpervisor.hashCode() : 0);
        result = 31 * result + (servicesUpervisorName != null ? servicesUpervisorName.hashCode() : 0);
        result = 31 * result + (projectExecutive != null ? projectExecutive.hashCode() : 0);
        result = 31 * result + (projectExecutiveName != null ? projectExecutiveName.hashCode() : 0);
        result = 31 * result + (programStatus != null ? programStatus.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (updateBy != null ? updateBy.hashCode() : 0);
        result = 31 * result + (programNo != null ? programNo.hashCode() : 0);
        result = 31 * result + (hotelNo != null ? hotelNo.hashCode() : 0);
        return result;
    }
}
