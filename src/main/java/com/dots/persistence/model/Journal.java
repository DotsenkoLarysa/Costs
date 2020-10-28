package com.dots.persistence.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "journal")
public class Journal {

    @Id
    @Column(name = "event_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long event_id;

    @Column(name = "event_date", nullable = false)
    private Date event_date;

    @NotBlank(message = "Sum is mandatory")
    @Column(name = "event_sum", nullable = false)
    private Double event_sum;

    @Column(name = "description")
    private String description;


    public Journal() {
    }

    public Journal(Long event_id, Date event_date, Double event_sum, String description) {
        this.event_id = event_id;
        this.event_date = event_date;
        this.event_sum = event_sum;
        this.description = description;
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



    @Override
    public String toString() {
        return "Journal{" +
                "event_id=" + event_id +
                ", event_date=" + event_date +
                ", event_sum=" + event_sum +
                ", description='" + description + '\'' +
                '}';
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "category_id", nullable = false)
    private Set<Category> categories;
    public Set<Category> getCategories() { return categories; }
    public void setCategories(Set<Category> categories) { this.categories = categories; }


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "transaction_id", nullable = false)
    private Set<Transaction> transactions;
    public Set<Transaction> getTransactions() { return transactions; }
    public void setTransactions(Set<Transaction> transactions) { this.transactions = transactions; }


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "period_id", nullable = false)
    private Set<Period> periods;
    public Set<Period> getPeriods() { return periods; }
    public void setPeriods(Set<Period> periods) { this.periods = periods; }

}
