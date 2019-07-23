package com.drw.cqrs.commands;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface IDocumentDAO<T, ID extends Serializable>
        extends JpaRepository<T, ID>{

    void saveDocumentContent(List<T> salaryList);
    int getCurrentDocumentID();

}