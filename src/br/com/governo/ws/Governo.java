package br.com.governo.ws;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import br.com.governo.dao.NotaFiscalDao;
import br.com.governo.model.Imposto;
import br.com.governo.model.NotaFiscal;
import br.com.governo.model.Usuario;
import br.com.governo.util.CriaImpostos;
import br.com.governo.util.CriaUsuarios;

@WebService
public class Governo {
	
	
	@Resource
	WebServiceContext webServiceContext;

	@WebMethod
	public List<NotaFiscal> listarNotaFiscal()throws Exception {
	
		String documentoLogado = autenticado();
		
		if(documentoLogado.isEmpty()){
			throw new Exception("Não autorizado!");
		}
		return NotaFiscalDao.exibirNotasClientes(documentoLogado);
	}

	@WebMethod
	public Imposto listarImpostos() throws Exception {
		
		if (autenticado().isEmpty()) {
			throw new Exception("Não autorizado!");
		}
		return CriaImpostos.getListaImposto();
	}

	@WebMethod
	public NotaFiscal emitirNotaFiscal(@WebParam(name = "documentoReceptor",header =false)String documento ,
									   @WebParam(name = "valorNota",header =false)Double valorNota) throws Exception {
	
		
		String documentoLogado = autenticado();
		
		if (documentoLogado.isEmpty()) {
			throw new Exception("Não autorizado a emitir nosta fiscal!");
		}	
		
		if( valorNota.doubleValue() < 0 || valorNota.doubleValue() == 0){
			throw new Exception("Informe um valor valido para emissão da nota fiscal");
		}
		
		NotaFiscal notaFiscal = new NotaFiscal(documentoLogado,documento,valorNota);
		
		///chama o grupo financeiro 
		
		
			///implementar aqui
		///
		//se ok o grupo financeiro salva a nova nota no DAO estatico
		NotaFiscalDao.adicionaNotaLista(notaFiscal);
		return notaFiscal;		
	}

	@WebMethod(exclude=true)
	public String autenticado() {

		String retorno = null;

		MessageContext mctx = webServiceContext.getMessageContext();
		Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
		List documento = (List) http_headers.get("documento");
		List senhas = (List) http_headers.get("senha");

		String documentos = "";
		String senha = "";

		if (documento != null) {
			documentos = documento.get(0).toString();
		}
		if (senhas != null) {
			senha = senhas.get(0).toString();
		}
		
		Usuario usuarioLogado = new Usuario();
		usuarioLogado.setSenha(senha);
		usuarioLogado.setDocumento(documentos);

		if (CriaUsuarios.getListaUsuarios().contains(usuarioLogado)) {
			retorno = documentos;
		} else {
			retorno = "";
		}

		return retorno;
	}

}
