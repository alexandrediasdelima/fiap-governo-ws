package br.com.governo.util;

import java.util.List;

import br.com.governo.model.Usuario;

public class CriaUsuarios {

	private CriaUsuarios(){
		
	}

	public static List<Usuario> getListaUsuarios() {

		Usuario usuarios =  new Usuario();
		usuarios.add("22233344455","1234");
		usuarios.add("11111111111","1234");
		usuarios.add("22222222222","1234");
		usuarios.add("55555555555","1234");
		return usuarios;

	}
}
