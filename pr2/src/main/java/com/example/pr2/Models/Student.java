package com.example.pr2.Models;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 1, max = 100, message = "От 1 до 100 символов")
    private String surname;

    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 1, max = 100, message = "От 1 до 100 символов")
    private String name;


    private Boolean dormitories;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @NotNull(message = "Не может быть пустым")
    @Range(min=0, max=90, message = "Диапазон от 0 до 90")
    private Integer groups;

    public Student(String Surname, String Name, Integer Groups, Date Birthday,Boolean Dormitories) {
        this.surname = Surname;
        this.name = Name;
        this.dormitories = Dormitories;
        this.groups = Groups;
        this.birthday = Birthday;
    }

    public Student() {

    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGroup() {
        return groups;
    }

    public void setGroup(Integer group) {
        this.groups = group;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getDormitories() {
        return dormitories;
    }

    public void setDormitories(Boolean dormitories) {
        this.dormitories = dormitories;
    }
    public String getBirthdayString(){
        return new SimpleDateFormat("yyyy-MM-dd").format(this.getBirthday());
    }
}
