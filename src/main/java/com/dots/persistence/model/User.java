package com.dots.persistence.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.security.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @NotBlank(message="Username is mandatory")
    @Column(name="username", nullable = false, unique = true)
    private String username;

    @NotBlank(message="Email is mandatory")
    @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$")
    @Column(name="email", nullable = false)
    private String email;

    @NotBlank(message="Password is mandatory")
    @Length(max = 6, min = 3)
    @Column(name="password", nullable = false, unique = true)
    private String password;

    @Column(name="create_time", nullable = false)
    private Timestamp create_time;

    public User() {
    }

    public User(Long user_id, String username, String email, String password, Timestamp create_time) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.create_time = create_time;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
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
    public String toString() {
        return "User{" +
                "user_id=" + user_id + ", username='" + username + ", email='" + email + ", password='" + password +
                ", create_time=" + create_time + '}';
    }
}


