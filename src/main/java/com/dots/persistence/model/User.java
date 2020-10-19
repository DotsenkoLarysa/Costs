package com.dots.persistence.model;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long user_id;

    @Column(name="username", nullable = false, unique = true)
    private String username;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="password", nullable = false, unique = true)
    private String password;

    @Column(name="create_time", nullable = false)
    private Timestamp create_time;

    public User() {
    }

    public User(long user_id, String username, String email, String password, Timestamp create_time) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.create_time = create_time;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return user_id == user.user_id &&
                Objects.equals(username, user.username) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(create_time, user.create_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, username, email, password, create_time);
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", create_time=" + create_time +
                '}';
    }
}


