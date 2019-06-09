package com.studentapp.gradesapp;

import java.io.IOException;

public class Student {
    private String name;
    private String email;
    private int javaGrade;
    private int sqlGrade;
    private int jspGrade;
    private int springGrade;

    public static void main(String[] args) throws IOException {
        new Application();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getJavaGrade() {
        return this.javaGrade;
    }

    public void setJavaGrade(int javaGrade) {
        this.javaGrade = javaGrade;
    }

    public int getSqlGrade() {
        return this.sqlGrade;
    }

    public void setSqlGrade(int sqlGrade) {
        this.sqlGrade = sqlGrade;
    }

    public int getJspGrade() {
        return this.jspGrade;
    }

    public void setJspGrade(int jspGrade) {
        this.jspGrade = jspGrade;
    }

    public int getSpringGrade() {
        return this.springGrade;
    }

    public void setSpringGrade(int springGrade) {
        this.springGrade = springGrade;
    }

    Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    void setGrade(int jG, int sG, int jspG, int sprG) {
        this.setJavaGrade(jG);
        this.setSqlGrade(sG);
        this.setJspGrade(jspG);
        this.setSpringGrade(sprG);
    }

    void displayGrade() {
        System.out.println("Student: " + this.getName());
        System.out.println("Java: " + this.getJavaGrade());
        System.out.println("SQL: " + this.getSqlGrade());
        System.out.println("JSP: " + this.getJspGrade());
        System.out.println("Spring: " + this.getSpringGrade());
    }
}