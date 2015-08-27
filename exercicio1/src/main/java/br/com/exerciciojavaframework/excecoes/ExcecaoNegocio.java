package br.com.exerciciojavaframework.excecoes;

public class ExcecaoNegocio extends Exception{

	private static final long serialVersionUID = 1L;

	
	public ExcecaoNegocio(String mensagem) {
            
		super(mensagem);
                
	}
	
}
