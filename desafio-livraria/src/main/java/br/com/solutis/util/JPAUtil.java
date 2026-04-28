package br.com.solutis.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory FACTORY = Persistence
            .createEntityManagerFactory("livraria");

    public static EntityManager getEntityManager(){
        return FACTORY.createEntityManager();
    }

}
