package com.dots.persistence.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="balance")
public class Balance {

    @Id
    @Column(name="balance_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long balance_id;

    @Column(name="create_date", nullable = false)
    private Date create_date;

    @Column(name="necessary_plus", nullable = false)
    private Double necessary_plus;

    @Column(name="necessary_minus", nullable = false)
    private Double necessary_minus;

    @Column(name="necessary_balance", nullable = false)
    private Double necessary_balance;

    @Column(name="education_plus", nullable = false)
    private Double education_plus;

    @Column(name="education_minus", nullable = false)
    private Double education_minus;

    @Column(name="education_balance", nullable = false)
    private Double education_balance;

    @Column(name="accumulation_plus", nullable = false)
    private Double accumulation_plus;

    @Column(name="accumulation_minus", nullable = false)
    private Double accumulation_minus;

    @Column(name="accumulation_balance", nullable = false)
    private Double accumulation_balance;

    @Column(name="stocks_plus", nullable = false)
    private Double stocks_plus;

    @Column(name="stocks_minus", nullable = false)
    private Double stocks_minus;

    @Column(name="stocks_balance", nullable = false)
    private Double stocks_balance;

    @Column(name="leisure_plus", nullable = false)
    private Double leisure_plus;

    @Column(name="leisure_minus", nullable = false)
    private Double leisure_minus;

    @Column(name="leisure_balance", nullable = false)
    private Double leisure_balance;

    @Column(name="charity_plus", nullable = false)
    private Double charity_plus;

    @Column(name="charity_minus", nullable = false)
    private Double charity_minus;

    @Column(name="charity_balance", nullable = false)
    private Double charity_balance;

    @Column(name="cashbook_plus", nullable = false)
    private Double cashbook_plus;

    @Column(name="cashbook_minus", nullable = false)
    private Double cashbook_minus;

    @Column(name="cashbook_balance", nullable = false)
    private Double cashbook_balance;

    @Column(name="periodId_balance", nullable = false)
    private int periodId_balance;

    public Balance() {
    }

    public Balance(Long balance_id, Date create_date, Double necessary_plus, Double necessary_minus, Double necessary_balance, Double education_plus, Double education_minus, Double education_balance, Double accumulation_plus, Double accumulation_minus, Double accumulation_balance, Double stocks_plus, Double stocks_minus, Double stocks_balance, Double leisure_plus, Double leisure_minus, Double leisure_balance, Double charity_plus, Double charity_minus, Double charity_balance, Double cashbook_plus, Double cashbook_minus, Double cashbook_balance, int periodId_balance) {
        this.balance_id = balance_id;
        this.create_date = create_date;
        this.necessary_plus = necessary_plus;
        this.necessary_minus = necessary_minus;
        this.necessary_balance = necessary_balance;
        this.education_plus = education_plus;
        this.education_minus = education_minus;
        this.education_balance = education_balance;
        this.accumulation_plus = accumulation_plus;
        this.accumulation_minus = accumulation_minus;
        this.accumulation_balance = accumulation_balance;
        this.stocks_plus = stocks_plus;
        this.stocks_minus = stocks_minus;
        this.stocks_balance = stocks_balance;
        this.leisure_plus = leisure_plus;
        this.leisure_minus = leisure_minus;
        this.leisure_balance = leisure_balance;
        this.charity_plus = charity_plus;
        this.charity_minus = charity_minus;
        this.charity_balance = charity_balance;
        this.cashbook_plus = cashbook_plus;
        this.cashbook_minus = cashbook_minus;
        this.cashbook_balance = cashbook_balance;
        this.periodId_balance = periodId_balance;
    }

    public long getBalance_id() {
        return balance_id;
    }

    public void setBalance_id(Long balance_id) {
        this.balance_id = balance_id;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Double getNecessary_plus() {
        return necessary_plus;
    }

    public void setNecessary_plus(Double necessary_plus) {
        this.necessary_plus = necessary_plus;
    }

    public Double getNecessary_minus() {
        return necessary_minus;
    }

    public void setNecessary_minus(Double necessary_minus) {
        this.necessary_minus = necessary_minus;
    }

    public Double getNecessary_balance() {
        return necessary_balance;
    }

    public void setNecessary_balance(Double necessary_balance) {
        this.necessary_balance = necessary_balance;
    }

    public Double getEducation_plus() {
        return education_plus;
    }

    public void setEducation_plus(Double education_plus) {
        this.education_plus = education_plus;
    }

    public Double getEducation_minus() {
        return education_minus;
    }

    public void setEducation_minus(Double education_minus) {
        this.education_minus = education_minus;
    }

    public Double getEducation_balance() {
        return education_balance;
    }

    public void setEducation_balance(Double education_balance) {
        this.education_balance = education_balance;
    }

    public Double getAccumulation_plus() {
        return accumulation_plus;
    }

    public void setAccumulation_plus(Double accumulation_plus) {
        this.accumulation_plus = accumulation_plus;
    }

    public Double getAccumulation_minus() {
        return accumulation_minus;
    }

    public void setAccumulation_minus(Double accumulation_minus) {
        this.accumulation_minus = accumulation_minus;
    }

    public Double getAccumulation_balance() {
        return accumulation_balance;
    }

    public void setAccumulation_balance(Double accumulation_balance) {
        this.accumulation_balance = accumulation_balance;
    }

    public Double getStocks_plus() {
        return stocks_plus;
    }

    public void setStocks_plus(Double stocks_plus) {
        this.stocks_plus = stocks_plus;
    }

    public Double getStocks_minus() {
        return stocks_minus;
    }

    public void setStocks_minus(Double stocks_minus) {
        this.stocks_minus = stocks_minus;
    }

    public Double getStocks_balance() {
        return stocks_balance;
    }

    public void setStocks_balance(Double stocks_balance) {
        this.stocks_balance = stocks_balance;
    }

    public Double getLeisure_plus() {
        return leisure_plus;
    }

    public void setLeisure_plus(Double leisure_plus) {
        this.leisure_plus = leisure_plus;
    }

    public Double getLeisure_minus() {
        return leisure_minus;
    }

    public void setLeisure_minus(Double leisure_minus) {
        this.leisure_minus = leisure_minus;
    }

    public Double getLeisure_balance() {
        return leisure_balance;
    }

    public void setLeisure_balance(Double leisure_balance) {
        this.leisure_balance = leisure_balance;
    }

    public Double getCharity_plus() {
        return charity_plus;
    }

    public void setCharity_plus(Double charity_plus) {
        this.charity_plus = charity_plus;
    }

    public Double getCharity_minus() {
        return charity_minus;
    }

    public void setCharity_minus(Double charity_minus) {
        this.charity_minus = charity_minus;
    }

    public Double getCharity_balance() {
        return charity_balance;
    }

    public void setCharity_balance(Double charity_balance) {
        this.charity_balance = charity_balance;
    }

    public Double getCashbook_plus() {
        return cashbook_plus;
    }

    public void setCashbook_plus(Double cashbook_plus) {
        this.cashbook_plus = cashbook_plus;
    }

    public Double getCashbook_minus() {
        return cashbook_minus;
    }

    public void setCashbook_minus(Double cashbook_minus) {
        this.cashbook_minus = cashbook_minus;
    }

    public Double getCashbook_balance() {
        return cashbook_balance;
    }

    public void setCashbook_balance(Double cashbook_balance) {
        this.cashbook_balance = cashbook_balance;
    }

    public int getPeriodId_balance() {
        return periodId_balance;
    }

    public void setPeriodId_balance(int periodId_balance) {
        this.periodId_balance = periodId_balance;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "balance_id=" + balance_id +
                ", create_date=" + create_date +
                ", necessary_plus=" + necessary_plus +
                ", necessary_minus=" + necessary_minus +
                ", necessary_balance=" + necessary_balance +
                ", education_plus=" + education_plus +
                ", education_minus=" + education_minus +
                ", education_balance=" + education_balance +
                ", accumulation_plus=" + accumulation_plus +
                ", accumulation_minus=" + accumulation_minus +
                ", accumulation_balance=" + accumulation_balance +
                ", stocks_plus=" + stocks_plus +
                ", stocks_minus=" + stocks_minus +
                ", stocks_balance=" + stocks_balance +
                ", leisure_plus=" + leisure_plus +
                ", leisure_minus=" + leisure_minus +
                ", leisure_balance=" + leisure_balance +
                ", charity_plus=" + charity_plus +
                ", charity_minus=" + charity_minus +
                ", charity_balance=" + charity_balance +
                ", cashbook_plus=" + cashbook_plus +
                ", cashbook_minus=" + cashbook_minus +
                ", cashbook_balance=" + cashbook_balance +
                ", periodId_balance=" + periodId_balance +
                '}';
    }
}
