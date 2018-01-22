package br.com.servicosdebebidas.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Para que essa classe funcionasse junto com o Growl, foi preciso configurar 
 * FornecedorBean.java, fornecedor.xhtml e modeloSistema.xhtml.
 * 
 * @author Rodrigo Barreto
 *
 */
public class JSFUtil {
	public static void adicionarMensagemSucesso(String mensagem) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
	    FacesContext contexto = FacesContext.getCurrentInstance();
	    contexto.addMessage(null, msg);
	}
	
	public static void adicionarMensagemErro(String mensagem) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
	    FacesContext contexto = FacesContext.getCurrentInstance();
	    contexto.addMessage(null, msg);
	}

}
