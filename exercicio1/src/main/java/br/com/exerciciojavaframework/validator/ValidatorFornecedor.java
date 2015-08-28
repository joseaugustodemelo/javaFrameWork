package br.com.exerciciojavaframework.validator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "validatorFornecedor")
public class ValidatorFornecedor implements Validator{

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {       
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    
}
