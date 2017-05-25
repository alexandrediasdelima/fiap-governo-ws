package br.com.governo.model;

import br.com.governo.util.CriaImpostos;

public class NotaFiscal {

	private String documentoEmissor;
	private String documentoReceptor;
	private double valorTotal;
	private double valorTotalImpostos;

	public NotaFiscal(String documentoEmissor, String documentoReceptor, double valorTotal) {
		this.documentoEmissor = documentoEmissor;
		this.documentoReceptor = documentoReceptor;
		this.valorTotal = valorTotal;
		getCalculaImpostos();
	}

	public String getDocumentoEmissor() {
		return documentoEmissor;
	}

	public void setDocumentoEmissor(String documentoEmissor) {
		this.documentoEmissor = documentoEmissor;
	}

	public String getDocumentoReceptor() {
		return documentoReceptor;
	}

	public void setDocumentoReceptor(String documentoReceptor) {
		this.documentoReceptor = documentoReceptor;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public double getValorTotalImpostos() {
		return valorTotalImpostos;
	}

	public void setValorTotalImpostos(double valorTotalImpostos) {
		this.valorTotalImpostos = valorTotalImpostos;
	}

	private void getCalculaImpostos() {

		Imposto listaImpostos = CriaImpostos.getListaImposto();

		for (int i = 0; i < 8; i++) {
			this.valorTotalImpostos += this.valorTotal * listaImpostos.get(i).getAliquota() / 100;
		}
	}
}
