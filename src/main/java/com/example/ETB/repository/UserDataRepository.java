package com.example.ETB.repository;

import com.example.ETB.model.UserData;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDataRepository {

    @PersistenceUnit(unitName = "dataCollection")
    private EntityManagerFactory entityManagerFactory;

    public UserData getUserData(Integer userId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(UserData.class, userId);
    }

    public void addUser(UserData user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
        }
        catch(Exception e) {
            System.out.println(e);
            transaction.rollback();
        }
    }

    public List<UserData> addAllData() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<UserData> query = entityManager.createQuery("SELECT i from UserData i", UserData.class);
        List<UserData> resultList = query.getResultList();
        return resultList;
    }

    public void deleteuser(Integer userId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            UserData data = entityManager.find(UserData.class, userId);
            entityManager.remove(data);
            transaction.commit();
        }
        catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
        }
    }

    public void updateusrData(UserData newData) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(newData);
            transaction.commit();
        }
        catch(Exception e) {
            System.out.println(e);
            transaction.rollback();
        }
    }
}
