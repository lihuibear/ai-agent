package com.lihui.aiagent.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName userprofile
 */
@TableName(value ="userprofile")
@Data
public class Userprofile implements Serializable {
    /**
     * 
     */
    @TableField(value = "name")
    private String name;

    /**
     * 
     */
    @TableField(value = "age")
    private Integer age;

    /**
     * 
     */
    @TableField(value = "gender")
    private String gender;

    /**
     * 
     */
    @TableField(value = "constellation")
    private String constellation;

    /**
     * 
     */
    @TableField(value = "occupation")
    private String occupation;

    /**
     * 
     */
    @TableField(value = "hobbies")
    private String hobbies;

    /**
     * 
     */
    @TableField(value = "partnerExpectation")
    private String partnerexpectation;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Userprofile other = (Userprofile) that;
        return (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getConstellation() == null ? other.getConstellation() == null : this.getConstellation().equals(other.getConstellation()))
            && (this.getOccupation() == null ? other.getOccupation() == null : this.getOccupation().equals(other.getOccupation()))
            && (this.getHobbies() == null ? other.getHobbies() == null : this.getHobbies().equals(other.getHobbies()))
            && (this.getPartnerexpectation() == null ? other.getPartnerexpectation() == null : this.getPartnerexpectation().equals(other.getPartnerexpectation()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getConstellation() == null) ? 0 : getConstellation().hashCode());
        result = prime * result + ((getOccupation() == null) ? 0 : getOccupation().hashCode());
        result = prime * result + ((getHobbies() == null) ? 0 : getHobbies().hashCode());
        result = prime * result + ((getPartnerexpectation() == null) ? 0 : getPartnerexpectation().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", name=").append(name);
        sb.append(", age=").append(age);
        sb.append(", gender=").append(gender);
        sb.append(", constellation=").append(constellation);
        sb.append(", occupation=").append(occupation);
        sb.append(", hobbies=").append(hobbies);
        sb.append(", partnerexpectation=").append(partnerexpectation);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}