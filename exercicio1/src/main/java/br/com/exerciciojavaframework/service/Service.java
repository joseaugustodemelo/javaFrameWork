
package br.com.exerciciojavaframework.service;

import br.com.exerciciojavaframework.excecoes.ExcecaoNegocio;
import br.com.exerciciojavaframework.modelo.entidade.Entidade;
import java.io.Serializable;
import java.util.List;

public interface Service<E extends Entidade> {        
    
    void persist(E entidade) throws ExcecaoNegocio;
    
    void merge(E entidade) throws ExcecaoNegocio;
    
    void refresh(E entidade) throws ExcecaoNegocio;
    
    void remove(E entidade) throws ExcecaoNegocio;
            
    E findById(Class<E> entidadeClass, Serializable Id) throws ExcecaoNegocio;
    
    List<E> findAll() throws ExcecaoNegocio;
    
    List<E> findByName(String namedQueryFindByName, Class<E> entidadeClass, String findName) throws ExcecaoNegocio;
    
}
