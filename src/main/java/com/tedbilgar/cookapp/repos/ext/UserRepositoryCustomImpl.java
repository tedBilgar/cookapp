package com.tedbilgar.cookapp.repos.ext;

import com.tedbilgar.cookapp.entities.UserEntity;
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
public class UserRepositoryCustomImpl implements UserRepositoryCustom{

    /**
     * В PersistenceConfig все было сконфигурировано для EntityManager
     * */
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<UserEntity> findUsersByFirstNameAndSecondName(String firstName, String secondName) {

        /**
         * Необходимый стандартный код для создания CriteriaBuilder
         * */
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteriaQuery = criteriaBuilder.createQuery(UserEntity.class);
        Root<UserEntity> userEntity = criteriaQuery.from(UserEntity.class);

        /**
         * Предикаты - это как будто условия выборки сущностей
         * Предикат составляется на criteriaBuilder и методах equal, like ...
         * */
        Predicate firstNamePredicate = criteriaBuilder.equal(userEntity.get("firstName"), firstName);
        Predicate secondNamePredicate = criteriaBuilder.like(userEntity.get("secondName"), "%" + secondName + "%");
        criteriaQuery.where(firstNamePredicate, secondNamePredicate);

        /**
         * Создаем сам запрос через entityManager
         * */
        TypedQuery<UserEntity> query = em.createQuery(criteriaQuery);

        return query.getResultList();
    }
}
