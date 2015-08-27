/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.exerciciojavaframework.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "mascararCnpj")
public class MascararCnpj implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {

		if (value != null) {

			value = mascarar(value);

		}

		return value;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {

		String valor = value != null ? mascarar(value.toString()) : null;

		return valor;
	}

	
	private String mascarar(String value){
	
		return value.substring(0, 2) + "." + value.substring(2, 5) + "." + value.substring(5, 8) + "/" + value.substring(8, 11) + "-" + value.substring(11, 13);
		
	}
					
}
