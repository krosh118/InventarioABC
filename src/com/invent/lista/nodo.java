package com.invent.lista;

public class nodo {

	public nodo sig;
	public nodo ant;
	public int codigo;
	public float demanda;
	public float valorarticulo;
	public float consumoValoracion;
	public float porcentajeParticipacion;
	public float porcentajeConsumo;
	public float consumoAcumulado;
	
	public nodo(int cod,float den,float valor,float conval,float porpari,float porcons,float cost){
		this.codigo = cod;
		this.demanda = den;
		this.valorarticulo = valor;
		this.consumoValoracion = conval;
		this.porcentajeParticipacion = porpari;
		this.porcentajeConsumo = porcons;
		this.consumoAcumulado = cost;
	}
	
	
	
}
