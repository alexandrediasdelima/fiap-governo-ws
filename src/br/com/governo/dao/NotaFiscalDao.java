package br.com.governo.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.governo.model.NotaFiscal;

public class NotaFiscalDao {

	private static List<NotaFiscal> notas;

	public static List<NotaFiscal> exibirNotasClientes(String doc) {

		List<NotaFiscal> notasSelecionadas = new ArrayList<NotaFiscal>();

		if (notas == null) {
			notas = new ArrayList<NotaFiscal>();
		}

		for (NotaFiscal nota : notas) {
			if (nota.getDocumentoEmissor().equals(doc)) {
				notasSelecionadas.add(nota);
			}
		}
		return notasSelecionadas;

	}

	public static void adicionaNotaLista(NotaFiscal nota) {

		if (notas == null) {
			notas = new ArrayList<NotaFiscal>();
		}
		notas.add(nota);
	}
}
