package com.tedbilgar.cookapp.repos.ext;

import com.tedbilgar.cookapp.entities.NoticeEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class NoticeRepositoryCustomImpl implements NoticeRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<NoticeEntity> findNoticeByHeaderAndBody(String header, String body) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<NoticeEntity> criteriaQuery = criteriaBuilder.createQuery(NoticeEntity.class);
        Root<NoticeEntity> noticeEntityRoot = criteriaQuery.from(NoticeEntity.class);

        if (header == null || header.isEmpty()){
            header = "";
        }

        if (body == null || body.isEmpty()){
            body = "";
        }

        Predicate headerPredicate = criteriaBuilder.like(noticeEntityRoot.get("header"), "%" + header + "%");
        Predicate bodyPredicate = criteriaBuilder.like(noticeEntityRoot.get("body"), "%" + body + "%");
        criteriaQuery.where(headerPredicate, bodyPredicate);

        TypedQuery<NoticeEntity> query = em.createQuery(criteriaQuery);

        return query.getResultList();
    }

}
