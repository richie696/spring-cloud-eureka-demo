package com.richie696.demo.account.domain;

import com.richie696.demo.commons.utils.HashUtils;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.Objects;

/**
 * 账户信息表实体类
 *
 * @author richie696
 * @version 1.0
 * @since 2021/02/01
 */
@Entity
@Table(name = "account_info")
public class AccountInfo {

    @Id
    private Long id;

    private String loginName;

    private String loginPassword;

    // 非数据库字段，不与DB同步，从JPA ORM关系映射中排除
    @Transient
    private String surePassword;

    private String passwordToken;

    private String userName;

    private Integer age;

    private Integer status;

    private Long version;

    private Date createdTime;

    private Date lastUpdatedTime;

    private boolean deletedFlag;

    public Long getId() {
        return id;
    }

    public AccountInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLoginName() {
        return loginName;
    }

    public AccountInfo setLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public AccountInfo setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
        return this;
    }

    public String getSurePassword() {
        return surePassword;
    }

    public AccountInfo setSurePassword(String surePassword) {
        this.surePassword = surePassword;
        return this;
    }

    public String getPasswordToken() {
        return passwordToken;
    }

    public AccountInfo setPasswordToken(String passwordToken) {
        this.passwordToken = passwordToken;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public AccountInfo setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public AccountInfo setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public AccountInfo setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Long getVersion() {
        return version;
    }

    public AccountInfo setVersion(Long version) {
        this.version = version;
        return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public AccountInfo setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public AccountInfo setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
        return this;
    }

    public boolean isDeletedFlag() {
        return deletedFlag;
    }

    public AccountInfo setDeletedFlag(boolean deletedFlag) {
        this.deletedFlag = deletedFlag;
        return this;
    }

    public boolean isValidRegisterInfo() {
        return StringUtils.isNotBlank(loginName)
                && StringUtils.isNotBlank(loginPassword)
                && loginPassword.equals(surePassword)
                && StringUtils.isNotBlank(userName)
                && (Objects.nonNull(age) && age > 0);
    }

    public boolean isInvalidPassword(String password) {
        String checkPassword = HashUtils.generateMD5(String.join("@", id.toString(), password, passwordToken));
        return !loginPassword.equals(checkPassword);
    }

    public AccountInfo clearPassword() {
        this.passwordToken = null;
        this.loginPassword = null;
        return this;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", surePassword='" + surePassword + '\'' +
                ", passwordToken='" + passwordToken + '\'' +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", status=" + status +
                ", version=" + version +
                ", createdTime=" + createdTime +
                ", lastUpdatedTime=" + lastUpdatedTime +
                ", deletedFlag=" + deletedFlag +
                '}';
    }
}
