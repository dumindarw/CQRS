package com.drw.cqrs.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Salary {

    @Id
    private int employeeID;
    private double amount;
    private int docID;

    public Salary() {
    }

    public Salary(int employeeID, double amount, int docID) {
        this.employeeID = employeeID;
        this.amount = amount;
        this.docID = docID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getDocID() {
        return docID;
    }

    public void setDocID(int docID) {
        this.docID = docID;
    }
}
