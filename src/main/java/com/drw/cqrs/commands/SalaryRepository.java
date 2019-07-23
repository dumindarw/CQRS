package com.drw.cqrs.commands;

import com.drw.cqrs.models.Salary;

import java.util.List;

public interface SalaryRepository extends  IDocumentDAO<Salary,Long> {

    void saveDocumentContent(List<Salary> list);
    int getCurrentDocumentID();
}