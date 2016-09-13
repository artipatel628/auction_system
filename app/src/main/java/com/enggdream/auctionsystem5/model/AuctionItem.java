package com.enggdream.auctionsystem5.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by PareshDudhat on 13-09-2016.
 */
@DatabaseTable(tableName = "auction_item")
public class AuctionItem {
    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField
    private String title;
    @DatabaseField
    private String description;
    @DatabaseField(columnName = "base_price")
    private double basePrice;
    @DatabaseField(foreign = true, columnName = "owner_id")
    private User owner;
    @DatabaseField(dataType = DataType.DATE, columnName = "created_date")
    private Date createDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }


    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
