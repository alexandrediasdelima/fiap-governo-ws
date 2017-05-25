package br.com.governo.model;

import java.util.ArrayList;

public class Imposto extends ArrayList<Imposto> {

	private static final long serialVersionUID = -4390526640171884647L;

	private String nome;
	private double aliquota;

	public Imposto() {

	}

	public Imposto(String nome2, double aliquota2) {
		setNome(nome2);
		setAliquota(aliquota2);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setAliquota(double aliquota) {
		this.aliquota = aliquota;
	}

	public double getAliquota() {
		return aliquota;
	}

	public void add(String nome, double aliquota) {
		super.add(new Imposto(nome, aliquota));
	}

}
