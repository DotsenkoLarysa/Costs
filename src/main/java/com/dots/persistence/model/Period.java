package com.dots.persistence.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="period")
public class Period {

    @Id
    @Column(name="period_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long period_id;

    @Column(name="period_name", nullable = false, unique = true)
    private String period_name;

    public Period() {
    }

    public Period(long period_id,String period_name) {
        this.period_id = period_id;
        this.period_name = period_name;
    }

    public long getPeriod_id() {
        return period_id;
    }

    public void setPeriod_id(long period_id) {
        this.period_id = period_id;
    }

    public String getPeriod_name() {
        return period_name;
    }

    public void setPeriod_name(String period_name) {
        this.period_name = period_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Period period = (Period) o;
        return period_id == period.period_id &&
                Objects.equals(period_name, period.period_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(period_id, period_name);
    }

    @Override
    public String toString() {
        return "Period{" +
                "period_id=" + period_id +
                ", period_name='" + period_name + '\'' +
                '}';
    }
}
