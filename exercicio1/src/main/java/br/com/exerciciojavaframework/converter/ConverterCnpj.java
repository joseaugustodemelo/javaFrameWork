package br.com.exerciciojavaframework.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "converterCnpj")
public class ConverterCnpj implements Converter {

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {

        if (value != null) {

            value = value.replace("-", "").replace(".", "").replace("/", "");

        }

        return value;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {

        String valor = value != null ? value.toString() : null;

        return valor;
    }

}
