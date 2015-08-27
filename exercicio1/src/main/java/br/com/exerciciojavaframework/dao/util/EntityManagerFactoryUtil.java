package br.com.exerciciojavaframework.dao.util;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryUtil {

    private static final ThreadLocal<EntityManager> THREAD_LOCAL = new ThreadLocal<>();
    private static EntityManagerFactory entityManagerFactory;
    private static final Map<Object, Object> HASH_MAP = new HashMap<>();

    private static EntityManagerFactory getEntityManagerFactory() {

        if (entityManagerFactory == null || !entityManagerFactory.isOpen()) {

            try {

                entityManagerFactory = Persistence.createEntityManagerFactory("exerciciojavaframework_exercicio1", HASH_MAP);
                
            } catch (Throwable throwable) {
                
                System.err.println("A criação do gerenciador de Entidades Falhou!" + throwable);
                
                throw new ExceptionInInitializerError(throwable);
                
            }
        }

        return entityManagerFactory;
    }
    
    public static EntityManager getEntityManager(boolean isCreate) {

        EntityManager entityManager = (EntityManager) THREAD_LOCAL.get();

        if (entityManager == null || !entityManager.isOpen()) {

            if (isCreate) {

                entityManager = getEntityManagerFactory().createEntityManager();
                THREAD_LOCAL.set(entityManager);

            }

        }

        return entityManager;

    }

    public static EntityManager getEntityManager() {
        
        return getEntityManager(true);
        
    }

    public static void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        EntityManagerFactoryUtil.entityManagerFactory = entityManagerFactory;
    }    
    
}
