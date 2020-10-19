package com.dots.persistence.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "journal")
public class Journal {

    @Id
    @Column(name="event_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long event_id;

    @Column(name="event_date", nullable = false)
    private Date event_date;

    @Column(name="event_sum", nullable = false)
    private Double event_sum;

    @Column(name="description")
    private String description;

    @Column(name="categoryId", nullable = false)
    private int categoryId;

    @Column(name="transactionId", nullable = false)
    private int transactionId;

    @Column(name="periodId", nullable = false)
    private int periodId;

    public Journal() {
    }

    public Journal(long event_id, Date event_date, Double event_sum, String description, int categoryId, int transactionId, int periodId) {
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

    public void setEvent_id(long event_id) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Journal journal = (Journal) o;
        return event_id == journal.event_id &&
                categoryId == journal.categoryId &&
                transactionId == journal.transactionId &&
                periodId == journal.periodId &&
                Objects.equals(event_date, journal.event_date) &&
                Objects.equals(event_sum, journal.event_sum) &&
                Objects.equals(description, journal.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(event_id, event_date, event_sum, description, categoryId, transactionId, periodId);
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
