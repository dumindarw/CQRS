package com.drw.cqrs.commands;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class DocumentDAOImpl<T, ID extends Serializable>
        extends SimpleJpaRepository<T, ID> implements IDocumentDAO<T, ID>{

    private EntityManager em;

    public DocumentDAOImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.em = entityManager;
    }

    @Override
    @Transactional
    public void saveDocumentContent(List<T> list) {

        for (Iterator<T> it = list.iterator(); it.hasNext();) {
            T line = it.next();

            em.persist(line);
            em.flush();
            em.clear();
        }

    }

    public int getCurrentDocumentID(){

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<T> cQuery = builder.createQuery(getDomainClass());
        Root<T> root = cQuery.from(getDomainClass());

        cQuery.select((Selection<? extends T>) builder.max(root.get("docID")));


        T id = em.createQuery(cQuery).getResultList().get(0);

        if (id == null) return 0;

        return (int) id;

    }
}
