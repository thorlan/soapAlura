package br.com.caelum.estoque.modelo.item;

import java.util.List;
 // ESSA CLASSE SO EMBRULHA PARA FORMAR O XML ITENS   ITEM ITEM ITEM /ITENS

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) //FAZ ACESSAR OS ATRIBUTOS
@XmlType(name="ListaDeItens")
public class ListaItens {

	@XmlElement(name="item")
	private List<Item> itens;

	public ListaItens(List<Item> itens) {
		this.itens = itens;
	}

	ListaItens() {
	}
	
	public List<Item> getItens() {
		return itens;
	}
	
}
