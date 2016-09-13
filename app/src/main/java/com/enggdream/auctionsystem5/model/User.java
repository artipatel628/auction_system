package com.enggdream.auctionsystem5.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by PareshDudhat on 12-09-2016.
 */

@DatabaseTable(tableName = "tbl_user")
public class User {
    @DatabaseField(generatedId = true,columnName = "user_id")
    private long userId;
    @DatabaseField
    private String username;
    @DatabaseField(columnName = "full_name")
    private String fullName;
    @DatabaseField
    private String password;
    @DatabaseField(dataType = DataType.DATE)
    private Date createdDate;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
