package br.com.exerciciojavaframework.dao;

import br.com.exerciciojavaframework.modelo.entidade.Entidade;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

public interface Dao <E extends Entidade>{
 
    EntityManager getEntityManager();
    
    EntityManager getEntityManager(boolean isCreate);
    
    void begin();
    
    void commit();
    
    void rollback();
    
    void persist(E entidade);
    
    void merge(E entidade);
    
    void refresh(E entidade);
    
    void remove(E entidade);
    
    void flush();
    
    E findById(Class<E> entidadeClass, Serializable Id);
    
    List<E> findAll();
    
    List<E> findByName(String namedQueryFindByName, Class<E> entidadeClass, String findName);
    
}
