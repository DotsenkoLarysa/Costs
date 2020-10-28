package com.dots.persistence.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "period")
public class Period {

    @Id
    @Column(name = "period_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long period_id;

    @Column(name = "period_name", nullable = false, unique = true)
    private Date period_name;

    public Period() {
    }

    public Period(Long period_id, Date period_name) {
        this.period_id = period_id;
        this.period_name = period_name;
    }

    public long getPeriod_id() {
        return period_id;
    }

    public void setPeriod_id(Long period_id) {
        this.period_id = period_id;
    }

    public Date getPeriod_name() {
        return period_name;
    }

    public void setPeriod_name(Date period_name) {
        this.period_name = period_name;
    }


    @Override
    public String toString() {
        return "Period{" +
                "period_id=" + period_id +
                ", period_name='" + period_name + '\'' +
                '}';
    }

    @OneToOne(optional = false, mappedBy = "balance")
    private Balance balance;
    public Balance balance() {
        return balance;
    }
    public void setBalance(Balance balance) {
        this.balance = balance;
    }


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "journal")
    private Set<Journal> journals;
    public Set<Journal> getJournals() { return journals; }
    public void setJournals(Set<Journal> journals) { this.journals = journals; }
}
