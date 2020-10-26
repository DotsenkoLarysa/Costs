package com.dots.persistence.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "journal")
public class Journal {

    @Id
    @Column(name="event_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long event_id;

    @Column(name="event_date", nullable = false)
    private Date event_date;

    @NotBlank(message="Sum is mandatory")
    @Column(name="event_sum", nullable = false)
    private Double event_sum;

    @Column(name="description")
    private String description;

    @NotBlank(message="Specify cost category")
    @Column(name="categoryId", nullable = false)
    private int categoryId;

    @Column(name="transactionId", nullable = false)
    private int transactionId;

    @Column(name="periodId", nullable = false)
    private int periodId;

    public Journal() {
    }

    public Journal(Long event_id, Date event_date, Double event_sum, String description, int categoryId, int transactionId, int periodId) {
        this.event_id = event_id;
        this.event_date = event_date;
        this.event_sum = event_sum;
        this.description = description;
        this.categoryId = categoryId;
        this.transactionId = transactionId;
        this.periodId = periodId;
    }

    public long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
    }

    public Date getEvent_date() {
        return event_date;
    }

    public void setEvent_date(Date event_date) {
        this.event_date = event_date;
    }

    public Double getEvent_sum() {
        return event_sum;
    }

    public void setEvent_sum(Double event_sum) {
        this.event_sum = event_sum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getPeriodId() {
        return periodId;
    }

    public void setPeriodId(int periodId) {
        this.periodId = periodId;
    }


    @Override
    public String toString() {
        return "Journal{" +
                "event_id=" + event_id +
                ", event_date=" + event_date +
                ", event_sum=" + event_sum +
                ", description='" + description + '\'' +
                ", categoryId=" + categoryId +
                ", transactionId=" + transactionId +
                ", periodId=" + periodId +
                '}';
    }
}
