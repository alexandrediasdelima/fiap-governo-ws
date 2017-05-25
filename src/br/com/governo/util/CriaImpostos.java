package br.com.governo.util;

import br.com.governo.model.Imposto;

public class CriaImpostos {

	private CriaImpostos(){
		
	}

	public static Imposto getListaImposto() {

		Imposto imposto = new Imposto();
		imposto.add("IOF", 0.38);
		imposto.add("IPI", 0.48);
		imposto.add("ICMS", 1.86);
		imposto.add("PIS/PASEP", 0.23);
		imposto.add("CONFINS", 0.86);
		imposto.add("CIDE", 0.10);
		imposto.add("IRPJ", 0.35);
		imposto.add("CPP", 2.75);
		imposto.add("ISS",0.54);
		return imposto;

	}
}
