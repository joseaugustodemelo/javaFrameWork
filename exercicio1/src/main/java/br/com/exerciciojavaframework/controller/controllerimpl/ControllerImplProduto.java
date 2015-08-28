package br.com.exerciciojavaframework.controller.controllerimpl;

import br.com.exerciciojavaframework.dao.daoimpl.DaoImpl;
import br.com.exerciciojavaframework.modelo.Produto;
import br.com.exerciciojavaframework.redirect.Redirect;
import br.com.exerciciojavaframework.service.serviceimpl.ServiceImpl;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ControllerImplProduto extends ControllerImpl<Produto, ServiceImpl<Produto, DaoImpl<Produto>>>
implements Serializable, Redirect<Produto>{

    public ControllerImplProduto() {
        
        super(new Produto());
        
    }
    
    public Produto getProduto(){
        
        return getEntidade();
        
    }
    
    public void setProduto(Produto produto){
        
        setEntidade(produto);
        
    }

    @Override
    public List<Produto> findByName() {
        return super.findByName(Produto.BUSCAR_POR_NOME, getProduto().getNomeProduto()); 
    }

    
    
    @Override
    public void viewInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String viewFind() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String viewEdit(Produto entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String viewEye(Produto entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
