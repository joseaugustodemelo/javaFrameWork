package br.com.exerciciojavaframework.controller;

import br.com.exerciciojavaframework.modelo.entidade.Entidade;
import java.io.Serializable;
import java.util.List;

public interface Controller<E extends Entidade> {
    
    void persist();
    
    void merge();
    
    void refresh();
    
    void remove();
            
    E findById(Serializable Id);
    
    List<E> findAll();
    
    List<E> findByName(String namedQueryFindByName, String findName);
    
    List<E> findByName();
}
