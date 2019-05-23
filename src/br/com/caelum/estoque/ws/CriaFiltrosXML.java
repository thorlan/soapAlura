package br.com.caelum.estoque.ws;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.TipoItem;



public class CriaFiltrosXML {

	public static void main(String[] args) {
		
		List<Filtro> filtrosLista = new ArrayList<>();
		Filtro filtro = new Filtro();
		filtro.setNome("Livro");
		filtro.setTipo(TipoItem.LIVRO);
		filtrosLista.add(filtro);
		
		Filtro filtro2 = new Filtro();
		filtro2.setNome("Livro");
		filtro2.setTipo(TipoItem.LIVRO);
		filtrosLista.add(filtro2);
		
		Filtros filtros = new Filtros(filtrosLista);
				
		XStream xstream = new XStream();
		xstream.alias("filtro", Filtro.class);
		xstream.alias("filtros", Filtros.class);
		String xmlGerado = xstream.toXML(filtros);
		
		System.out.println(xmlGerado);
	}
}
