package br.com.exerciciojavaframework.redirect.redirectimpl;

import br.com.exerciciojavaframework.modelo.entidade.Entidade;
import br.com.exerciciojavaframework.redirect.Redirect;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "redirectImpl")
@SessionScoped
public class RedirectImpl implements Redirect, Serializable {

    public RedirectImpl() {
    }

    public String home() {
        return "index";
    }

    public String fornecedor() {
        return "form-handle-fornecedor";
    }

    public String produto() {
        return "form-handle-produto";
    }

    @Override
    public void viewInsert() {
        
    }

    @Override
    public String viewFind() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String viewEdit(Entidade entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String viewEye(Entidade entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
