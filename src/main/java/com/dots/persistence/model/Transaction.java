package com.dots.persistence.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @Column(name="transaction_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long transaction_id;

    @Column(name="name_transaction", nullable = false, unique = true)
    private String name_transaction;

    public Transaction() {
    }

    public Transaction(int transaction_id, String name_transaction) {
        this.transaction_id = transaction_id;
        this.name_transaction = name_transaction;
    }

    public long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(long transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getName_transaction() {
        return name_transaction;
    }

    public void setName_transaction(String name_transaction) {
        this.name_transaction = name_transaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return transaction_id == that.transaction_id &&
                Objects.equals(name_transaction, that.name_transaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transaction_id, name_transaction);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transaction_id=" + transaction_id +
                ", name_transaction='" + name_transaction + '\'' +
                '}';
    }
}
