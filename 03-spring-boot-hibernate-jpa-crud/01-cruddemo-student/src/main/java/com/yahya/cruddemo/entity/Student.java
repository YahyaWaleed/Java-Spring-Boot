package com.yahya.cruddemo.entity;


import jakarta.persistence.*;

@Entity // maps this class to the table name
@Table(name = "student")
public class Student {

    //  1. Define Fields //

    @Id // shows that this field is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tells app that this field's value will be generated  by the automatically by the database
    @Column(name = "id") // maps this field to the column name
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;


    // 2. Define Constructors //

    // empty, no-argument constructor (for framework)
    public Student() {};

    // normal constructor (for developer)
    // create it using the IDE (dont write it urself)
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // 3. Define Getters and Setters //
    // create it using the IDE (dont write it urself)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    // 4. Create toString() Method // (it convert object to readable string)
    // create using IDE
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
