package br.com.governo.model;

import java.util.ArrayList;

public class Usuario extends ArrayList<Usuario>{

	private static final long serialVersionUID = 1L;
	
	private String documento;
	private String senha;

	public Usuario() {

	}

	public Usuario(String documento, String senha) {
		setDocumento(documento);
		setSenha(senha);
	}
	
	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void add(String documento, String senha) {
		super.add(new Usuario(documento, senha));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((documento == null) ? 0 : documento.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}
			
			
			
			

}
