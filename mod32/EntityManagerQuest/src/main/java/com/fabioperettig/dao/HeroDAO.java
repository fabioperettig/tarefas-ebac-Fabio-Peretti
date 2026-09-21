package com.fabioperettig.dao;

import com.fabioperettig.config.ConnectionManager;
import com.fabioperettig.domain.Hero;
import jakarta.persistence.EntityManager;

public class HeroDAO {

    public Hero create(Hero hero) {

        EntityManager entityManager = ConnectionManager.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(hero);
        entityManager.getTransaction().commit();

        entityManager.close();

        return hero;
    }

    public Hero readById(Long id) {

        EntityManager entityManager = ConnectionManager.getEntityManager();

        entityManager.getTransaction().begin();
        Hero hero = entityManager.find(Hero.class, id);
        entityManager.getTransaction().commit();

        entityManager.close();

        return hero;
    }

    public Hero update(Hero hero) {

        EntityManager entityManager = ConnectionManager.getEntityManager();

        entityManager.getTransaction().begin();
        hero = entityManager.merge(hero);
        entityManager.getTransaction().commit();
        entityManager.close();

        return hero;
    }

    public void delete(Hero hero) {

        EntityManager entityManager = ConnectionManager.getEntityManager();

        entityManager.getTransaction().begin();
        hero = entityManager.merge(hero);
        entityManager.remove(hero);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

}
