package com.keyManage.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * Province entity. @author MyEclipse Persistence Tools
 */

public class Province  implements java.io.Serializable {


    // Fields    

     private String id;
     private String provinceName;
     private String isDelete;
     private String createBy;
     private Timestamp createDate;
     private String updateBy;
     private Timestamp updateDate;
     private Set departments = new HashSet(0);


    // Constructors

    /** default constructor */
    public Province() {
    }

	/** minimal constructor */
    public Province(String id) {
        this.id = id;
    }
    
    /** full constructor */
    public Province(String id, String provinceName, String isDelete, String createBy, Timestamp createDate, String updateBy, Timestamp updateDate, Set departments) {
        this.id = id;
        this.provinceName = provinceName;
        this.isDelete = isDelete;
        this.createBy = createBy;
        this.createDate = createDate;
        this.updateBy = updateBy;
        this.updateDate = updateDate;
        this.departments = departments;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getProvinceName() {
        return this.provinceName;
    }
    
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getIsDelete() {
        return this.isDelete;
    }
    
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateBy() {
        return this.createBy;
    }
    
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Timestamp getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return this.updateBy;
    }
    
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Timestamp getUpdateDate() {
        return this.updateDate;
    }
    
    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public Set getDepartments() {
        return this.departments;
    }
    
    public void setDepartments(Set departments) {
        this.departments = departments;
    }
   








}