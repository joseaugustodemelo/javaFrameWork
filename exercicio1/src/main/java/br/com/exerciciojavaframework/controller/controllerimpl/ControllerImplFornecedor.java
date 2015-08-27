package br.com.exerciciojavaframework.controller.controllerimpl;

import br.com.exerciciojavaframework.dao.daoimpl.DaoImpl;
import br.com.exerciciojavaframework.modelo.Fornecedor;
import br.com.exerciciojavaframework.redirect.Redirect;
import br.com.exerciciojavaframework.service.serviceimpl.ServiceImpl;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ControllerImplFornecedor extends ControllerImpl<Fornecedor, ServiceImpl<Fornecedor, DaoImpl<Fornecedor>>>
        implements Serializable, Redirect<Fornecedor> {

    private static final long serialVersionUID = 1L;

    private List<Fornecedor> listFornecedor;

    public ControllerImplFornecedor() {
        
        super(new Fornecedor());
        
    }
    
    public Fornecedor getFornecedor(){
        
        return getEntidade();
        
    }
    
    public void setFornecedor(Fornecedor fornecedor){
        
        setEntidade(fornecedor);
        
    }

    public List<Fornecedor> getListFornecedor() {
        return listFornecedor;
    }

    public void setListFornecedor(List<Fornecedor> listFornecedor) {
        this.listFornecedor = listFornecedor;
    }

    @Override
    public List<Fornecedor> findByName() {
        return super.findByName(Fornecedor.BUSCAR_POR_NOME, getEntidade().getNomeFornecedor());
    }
    
    

    @Override
    public void viewInsert() {
		
		enableInsert();
		
        
    }

    @Override
    public String viewFind() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String viewEdit(Fornecedor entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String viewEye(Fornecedor entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
