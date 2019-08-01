package com.tedbilgar.cookapp.repos.ext;

import com.tedbilgar.cookapp.entities.NoticeEntity;
import com.tedbilgar.cookapp.entities.NoticeEntity_;
import com.tedbilgar.cookapp.entities.UserEntity;
import com.tedbilgar.cookapp.entities.UserEntity_;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
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

    @Override
    public List<UserEntity> findUsersByNoticeHeader(String noticeHeader) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteriaQuery = criteriaBuilder.createQuery(UserEntity.class);
        Root<UserEntity> user = criteriaQuery.from(UserEntity.class);

        /**
         * Находим всех юзеров, которые имеют Notice, которые хотя бы частью LIKE схожи с входным параметром
         * */
        SetJoin<UserEntity, NoticeEntity> join = user.join(UserEntity_.noticeEntitySet);
        criteriaQuery.select(user)
                    .distinct(true)
                    .where(
                            criteriaBuilder.like(join.get(NoticeEntity_.header), "%" + noticeHeader + "%")
                    );

        TypedQuery<UserEntity> typedQuery = em.createQuery(criteriaQuery);

        return typedQuery.getResultList();
    }


}
