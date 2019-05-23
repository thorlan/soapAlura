package br.com.caelum.estoque.modelo.usuario;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.caelum.estoque.util.DateAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class InfoFault {

	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date dataErro;
	private String mensagem;

	public InfoFault(String mensagem, Date dataErro) {
		this.dataErro = dataErro;
		this.mensagem = mensagem;
	}
	
	//JAX-B precisa desse construtor!
	InfoFault(){
		
	}
	

}
