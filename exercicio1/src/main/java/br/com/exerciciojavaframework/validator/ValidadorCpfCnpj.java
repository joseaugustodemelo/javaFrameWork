package br.com.exerciciojavaframework.validator;

import static br.com.exerciciojavaframework.mensagem.Mensagem.mensagemErro;
import br.com.exerciciojavaframework.util.CpfCnpjUtil;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator(value = "cnpjValidator")
public class ValidadorCpfCnpj implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent componente, Object valor)
            throws ValidatorException {

        if (valor != null && CpfCnpjUtil.isNotValid(valor)) {

            throw new ValidatorException(mensagemErro("CNPJ inválido", ""));
            
        }

    }

}
