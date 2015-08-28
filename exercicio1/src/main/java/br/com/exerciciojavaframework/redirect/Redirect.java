package br.com.exerciciojavaframework.redirect;

import br.com.exerciciojavaframework.modelo.entidade.Entidade;

public interface Redirect <E extends Entidade> {
	
	void viewNew();
	
	String viewFind();
	
	String viewEdit(E entidade);
        
        String viewEye(E entidade);                       
        
}
