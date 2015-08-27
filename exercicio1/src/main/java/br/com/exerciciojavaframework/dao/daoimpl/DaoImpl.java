package br.com.exerciciojavaframework.dao.daoimpl;

import br.com.exerciciojavaframework.dao.Dao;
import br.com.exerciciojavaframework.dao.util.EntityManagerFactoryUtil;
import br.com.exerciciojavaframework.modelo.entidade.Entidade;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Table;

public class DaoImpl<E extends Entidade> implements Dao<E>, Serializable {

    private static final long serialVersionUID = 1L;
    
    public DaoImpl() {
    }    
    
    @Override
    public void begin() {
        getEntityManager().getTransaction().begin();                
    }

    @Override
    public void commit() {
        getEntityManager().getTransaction().commit();
    }

    @Override
    public void rollback() {
        try {
            getEntityManager().getTransaction().rollback();
        } catch (Exception e) {
            System.out.println("Rollback --> " + e.getMessage());
        }

        try {
            getEntityManager().close();
        } catch (Exception e) {
            System.out.println("Falhou ao fechar o gerenciador de entidades!");
        }

        EntityManagerFactoryUtil.setEntityManagerFactory(null);
    }

    @Override
    public void persist(Entidade entidade) {
        try {
            begin();

            getEntityManager().persist(entidade);

            commit();
        } catch (Exception e) {
            
            rollback();
            
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void merge(Entidade entidade) {
        try {
            begin();

            getEntityManager().merge(entidade);

            commit();
        } catch (Exception e) {
            
            rollback();
            
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void refresh(Entidade entidade) {
        getEntityManager().refresh(entidade);
    }

    @Override
    public void remove(Entidade entidade) {
        try {
            begin();

            getEntityManager().remove(entidade);

            commit();
        } catch (Exception e) {
            
            rollback();
            
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void flush() {
        getEntityManager().flush();
    }

    @Override
    public E findById(Class<E> entidadeClass, Serializable Id) {
        return (E) getEntityManager().find(entidadeClass, Id);
    }
    
    @Override
    public List<E> findAll() {        
        
        String jpql = "select e from " + Entidade.class.getAnnotation(Table.class).name() + " e";
        
        Query query = getEntityManager().createQuery(jpql);
        
        return (List<E>) query.getResultList();
        
    }

    @Override
    public EntityManager getEntityManager() {
        return EntityManagerFactoryUtil.getEntityManager();
    }

    @Override
    public EntityManager getEntityManager(boolean isCreate) {
        return EntityManagerFactoryUtil.getEntityManager(isCreate);
    }

    @Override
    public List<E> findByName(String namedQueryFindByName, Class<E> entidadeClass, String findName) {
        
        Query query = getEntityManager().createNamedQuery(namedQueryFindByName, entidadeClass);        
        query.setParameter("findName", "%" + findName.toLowerCase() + "%");
        
        return (List<E>) query.getResultList();
        
    }       

}
