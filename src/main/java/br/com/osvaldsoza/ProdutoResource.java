package br.com.osvaldsoza;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {
	
	@GET
	public List<Produto> buscaProdutos(){
		return Produto.listAll();	
	}
	
	@POST
	@Transactional
	public void salvarProtudo(CadastrarProdutoDTO dto) {
		Produto produto = new Produto();
		
		produto.setNome(dto.getNome());
		produto.setValor(dto.getValor());
		
		produto.persist();
	}
	
	@PUT
	@Path("{id}")
	@Transactional
	public void atualizarProduto(@PathParam("id") Long id, CadastrarProdutoDTO dto) {
		Optional<Produto> produtoOp = Produto.findByIdOptional(id);
		
		if(produtoOp.isPresent()) {
			Produto produto = produtoOp.get();
			produto.setNome(dto.getNome());
			produto.setValor(dto.getValor());
			
			produto.persist();
		}else {
			throw new NotFoundException();
		}
	}
	
	@DELETE
	@Path("{id}")
	@Transactional
	public void deletararProduto(@PathParam("id") Long id) {
		Optional<Produto> produtoOp = Produto.findByIdOptional(id);
		
		if(produtoOp.isPresent()) {
			Produto produto = produtoOp.get();			
			produto.delete();
		}else {
			throw new NotFoundException();
		}
	}

}
