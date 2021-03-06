package com.dots.persistence.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long category_id;

    @NotBlank(message = "Specify the category name")
    @Column(name = "name_category", nullable = false, unique = true)
    private String name_category;

    @NotBlank(message = "Indicate the percentage")
    @Column(name = "parcentage_value", nullable = false)
    private int percentage;

    public Category() {
    }

    public Category(Long category_id, String name_category, int percentage) {
        this.category_id = category_id;
        this.name_category = name_category;
        this.percentage = percentage;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getName_category() {
        return name_category;
    }

    public void setName_category(String name_category) {
        this.name_category = name_category;
    }

    public int getParcentage() {
        return percentage;
    }

    public void setParcentage(int percentage) {
        this.percentage = percentage;
    }


    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + category_id +
                ", name_category='" + name_category + '\'' +
                ", parcentage_value=" + percentage +
                '}';
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "journal")
    private Set<Journal> journal;

    public Set<Journal> getJournal() {
        return journal;
    }

    public void setJournal(Set<Journal> journal) {
        this.journal = journal;
    }
}
