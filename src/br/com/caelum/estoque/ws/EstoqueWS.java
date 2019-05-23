package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ItemValidador;
import br.com.caelum.estoque.modelo.item.ListaItens;
import br.com.caelum.estoque.modelo.usuario.AutorizacaoException;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;

@WebService
public class EstoqueWS {

	private ItemDao dao = new ItemDao();

	private TokenDao tokenDao = new TokenDao();
	
//	@WebMethod(operationName = "todosOsItens")
//	@ResponseWrapper(localName = "itens") // elemento que embrulha a mensagem
//	@WebResult(name = "item") // nome de cada item da lista
//	public List<Item> getItens() {
//		System.out.println("Chamando get Itens");
//		List<Item> lista = dao.todosItens();
//		return lista;
//	}

	@WebMethod(operationName = "todosOsItens")
	@ResponseWrapper(localName = "itens")
	@WebResult(name = "item")
	@RequestWrapper(localName = "listaItens")
	public ListaItens getItens(@WebParam(name = "filtros") Filtros filtros) {
		
		List<Filtro> lista = filtros.getLista();
		List<Item> result = dao.todosItens(lista);

		return new ListaItens(result);

	}
	
	@WebMethod(operationName = "CadastrarItem")
	@WebResult(name = "item")
	public Item cadastrarItem(@WebParam(name = "tokenUsuario", header=true) TokenUsuario token ,@WebParam(name = "item") Item item) throws AutorizacaoException {
		
		boolean ehValido = tokenDao.ehValido(token);
		
		if (!ehValido) {
			System.out.println("Token é inválido");
			throw new AutorizacaoException("Autorização falhou");
		}
		
		new ItemValidador(item).validate();
		
		System.out.println("Cadastrando item " + item + ", Token: " + token);
		dao.cadastrar(item);
		
		return item;
	}
	
	
	
	
}
