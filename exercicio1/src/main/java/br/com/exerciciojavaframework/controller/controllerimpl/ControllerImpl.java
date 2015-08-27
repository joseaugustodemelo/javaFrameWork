package br.com.exerciciojavaframework.controller.controllerimpl;

import br.com.exerciciojavaframework.action.Action;
import br.com.exerciciojavaframework.controller.Controller;
import br.com.exerciciojavaframework.dao.daoimpl.DaoImpl;
import br.com.exerciciojavaframework.excecoes.ExcecaoNegocio;
import br.com.exerciciojavaframework.modelo.entidade.Entidade;
import br.com.exerciciojavaframework.service.serviceimpl.ServiceImpl;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;


public class ControllerImpl<E extends Entidade, S extends ServiceImpl<E, DaoImpl<E>>> extends HttpServlet
implements Controller<E>, Serializable, Action{

    private S service;
    public E entidade; 
    private boolean showNew;    
    private boolean showSave;
    private boolean showEdit;
    private boolean showDelete;
    private boolean showFind; 
	private boolean showReturn;
    
    public ControllerImpl(E entidade) {
        
        this.entidade = entidade;
        
        controllerButton(true, false, false, false, true, false);
        
    }

    protected E getEntidade() {
        
        return entidade;
        
    }   

    protected void setEntidade(E entidade) {
        
        this.entidade = entidade;
        
    }
    private S getService() {

        if (service == null) {

            try {
                
                service = (S) new ServiceImpl<E, DaoImpl<E>>();
                
            } catch (Exception e) {

                System.out.println("Erro ao instanciar a service --> " + e.getMessage());

            }
        }

        return service;
        
    }

    protected void setService(S service) {

        this.service = service;

    }

    @Override
    public void persist() {
        try {
            
            getService().persist(entidade);
            
        } catch (ExcecaoNegocio ex) {
            
            Logger.getLogger(ControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    @Override
    public void merge() {
        try {
            
            getService().merge(entidade);
            
        } catch (ExcecaoNegocio ex) {
            
            Logger.getLogger(ControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    @Override
    public void refresh() {
        try {
            
            getService().refresh(entidade);
            
        } catch (ExcecaoNegocio ex) {
            
            Logger.getLogger(ControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    @Override
    public void remove() {
        try {
            
            getService().remove(entidade);
            
        } catch (ExcecaoNegocio ex) {
            
            Logger.getLogger(ControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    @Override
    public E findById(Serializable Id) {            
        
        try {
            
            return getService().findById((Class<E>) this.entidade.getClass(), Id);
            
        } catch (ExcecaoNegocio ex) {
                     
            Logger.getLogger(ControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            
            return null;
            
        }
    }

    @Override
    public List<E> findAll() {
        
        try {
            
            return getService().findAll();
            
        } catch (ExcecaoNegocio ex) {
            
            Logger.getLogger(ControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            
            return null;
        }
        
    }

    @Override
    public List<E> findByName(String namedQueryFindByName, String findName) {
        
        try {
            
            return getService()
                    .findByName(namedQueryFindByName, (Class<E>) this.entidade.getClass(), findName);
            
        } catch (ExcecaoNegocio ex) {
            
            Logger.getLogger(ControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            
            return null;
        }
                
    }

    @Override
    public List<E> findByName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public boolean showButtonSave() {
        
        return showSave;
        
    }

    @Override
    public boolean showButtonNew() {
        
        return showNew;
        
    }

    @Override
    public boolean showButtonEdit() {
        
        return showEdit;
        
    }

    @Override
    public boolean showButtonDelete() {
        
        return showDelete;
        
    }

    @Override
    public final void controllerButton(boolean showNew, boolean showSave, boolean showEdit, boolean showDelete, boolean showFind, boolean showReturn) {
        
        this.showNew = showNew;
        
        this.showSave = showSave;
        
        this.showEdit = showEdit;
        
        this.showDelete = showDelete;
        
        this.showFind = showFind;
        
    }

    @Override
    public boolean showButtonFind() {
        
        return showFind;
        
    }

	@Override
	public void enableInsert() {
		controllerButton(false, true, false, false, false, true);
	}

	@Override
	public boolean showButtonReturn() {
		return showReturn;
	}
    
    

}
