package com.example.Project1.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;
    @Column(nullable = false)
    private String name;
    @Pattern(regexp="^\\d{10}$",message="Phone number must contain exactly 10 digits")
    @Column(nullable = false)
    private  Long phonenumber;
    @Pattern(regexp="^[\\w-.]+@[\\w-]+(\\.[\\w-]+)+$",message = "Invalid email format")
    @Column(nullable=false,name = "email_id")
    private String email_id;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Accounts> accounts;
    @Column(nullable = false)
    private String password;


    public List<Accounts> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Accounts> accounts) {
        this.accounts = accounts;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getphonenumber() {
        return phonenumber;
    }

    public void setphonenumber(Long phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
}
