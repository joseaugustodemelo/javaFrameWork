package br.com.exerciciojavaframework.mensagem;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Mensagem {

    public static void addMensagemSucesso(String mensagem, String detalhe) {

        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, detalhe));

    }

    public static void addMensagemAlerta(String mensagem, String detalhe) {

        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, detalhe));

    }

    public static void addMensagemErro(String mensagem, String detalhe) {

        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, detalhe));

    }

    public static void addMensagemErroFatal(String mensagem, String detalhe) {

        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, mensagem, detalhe));

    }

    public static FacesMessage mensagemErro(String mensagem, String detalhe) {

        return new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, detalhe);

    }

    public static FacesMessage mensagemInfo(String mensagem, String detalhe) {

        return new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, detalhe);

    }

    public static FacesMessage mensagemFatal(String mensagem, String detalhe) {

        return new FacesMessage(FacesMessage.SEVERITY_FATAL, mensagem, detalhe);

    }

    public static FacesMessage mensagemAlerta(String mensagem, String detalhe) {

        return new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, detalhe);

    }
}
