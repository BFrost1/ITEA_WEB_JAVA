package com.shop.user;

import java.util.Objects;

public class User {
    private int id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String country;
    private String comments;
    private String termsOfService;

    public User(String login, String password, String firstName, String lastName, String age, String gender, String country, String comments, String termsOfService) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = Integer.parseInt(age);
        this.gender = gender;
        this.country = country;
        this.comments = comments;
        this.termsOfService = termsOfService;
    }

    public User(int id, String login, String password, String firstName, String lastName, int age, String gender, String country, String comments, String termsOfService) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.country = country;
        this.comments = comments;
        this.termsOfService = termsOfService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                age == user.age &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(gender, user.gender) &&
                Objects.equals(country, user.country) &&
                Objects.equals(comments, user.comments) &&
                Objects.equals(termsOfService, user.termsOfService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, firstName, lastName, age, gender, country, comments, termsOfService);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", country=" + country +
                ", comments='" + comments + '\'' +
                ", termsOfService='" + termsOfService + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getTermsOfService() {
        return termsOfService;
    }

    public void setTermsOfService(String termsOfService) {
        this.termsOfService = termsOfService;
    }
}
