package br.com.exerciciojavaframework.service.serviceimpl;

import br.com.exerciciojavaframework.dao.daoimpl.DaoImpl;
import br.com.exerciciojavaframework.excecoes.ExcecaoNegocio;
import br.com.exerciciojavaframework.modelo.entidade.Entidade;
import br.com.exerciciojavaframework.service.Service;
import java.io.Serializable;
import java.util.List;

public class ServiceImpl<E extends Entidade, D extends DaoImpl<E>>
        implements Service<E>, Serializable {

    private static final long serialVersionUID = 1L;
    
    private D dao;

    public ServiceImpl() {
    }

    private D getDao() {

        if (dao == null) {

            try {

                dao = (D) new DaoImpl<E>();
                
            } catch (Exception e) {

                System.out.println("Erro ao instanciar a service --> " + e.getMessage());

            }
                        
        }

        return dao;
        
    }

    public void validatePersist(E entidade) throws ExcecaoNegocio {

    }

    @Override
    public void persist(E entidade) throws ExcecaoNegocio {
        validatePersist(entidade);

        getDao().persist(entidade);
    }

    public void validateMerge(E entidade) throws ExcecaoNegocio {

    }

    @Override
    public void merge(E entidade) throws ExcecaoNegocio {
        validateMerge(entidade);

        getDao().merge(entidade);
    }

    public void validateRefresh(E entidade) throws ExcecaoNegocio {

    }

    @Override
    public void refresh(E entidade) throws ExcecaoNegocio {
        validateRefresh(entidade);

        getDao().refresh(entidade);
    }

    public void validateRemove(E entidade) throws ExcecaoNegocio {

    }

    @Override
    public void remove(E entidade) throws ExcecaoNegocio {
        validateRemove(entidade);

        getDao().remove(entidade);
    }

    public void validateFindById(Class<E> entidade) throws ExcecaoNegocio {

    }

    @Override
    public E findById(Class<E> entidadeClass, Serializable Id) throws ExcecaoNegocio {
        
        validateFindById(entidadeClass);

        return getDao().findById(entidadeClass, Id);

    }

    public void validateFindByAll() throws ExcecaoNegocio {

    }

    @Override
    public List<E> findAll() throws ExcecaoNegocio {

        validateFindByAll();

        return getDao().findAll();

    }

    public void validateFindByName() throws ExcecaoNegocio {

    }

    @Override
    public List<E> findByName(String namedQueryFindByName, Class<E> entidadeClass, String findName) throws ExcecaoNegocio {

        validateFindByName();

        return getDao().findByName(namedQueryFindByName, entidadeClass, findName);

    }

}
