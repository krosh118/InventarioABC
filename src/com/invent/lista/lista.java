package com.invent.lista;

public class lista {

	
	public nodo raiz = null;
	
	
	public void agregar(nodo ingresar){
		nodo aux = raiz;
		
		if( raiz == null ){
			raiz = ingresar;
		}else{
			
			while(aux.sig!=null){
				aux = aux.sig;
			}
			
			aux.sig = ingresar;
			ingresar.ant = aux;
			
		}
		
		
	}
	
	public boolean equilibrar(){
		nodo aux = raiz;
		nodo aux2 = raiz;
		nodo aux3 = raiz;
		boolean encontrado = false;
		
		while(aux!=null){
			aux2 = aux.sig;
			while(aux2!=null&& encontrado == false){
				if(aux.porcentajeConsumo<aux2.porcentajeConsumo){
					if(aux==raiz){
						if(aux2.sig!=null){
							aux2.sig.ant = aux2.ant;
						}
						aux2.ant.sig = aux2.sig;
						aux2.sig = aux;
						aux2.ant = null;
						aux.ant = aux2;
						raiz = aux2;
						aux = raiz;
						encontrado = true;
					}else{
						if(aux2.sig!=null){
							aux2.sig.ant = aux2.ant;
						}
						aux2.ant.sig = aux2.sig;
						aux.ant.sig = aux2;
						aux2.ant = aux.ant;
						aux2.sig = aux;
						aux.ant = aux2;
						aux = raiz;
						encontrado = true;
					}
				}
				if(encontrado==true){
					aux2 = raiz;
					
				}else{
					aux2 = aux2.sig;
				}
			}
			if(encontrado == true){
				aux = raiz;
				encontrado = false;
			}else{
				aux = aux.sig;
			}
			
			
		}
		
		return true;
	}
	
	
	
	
	
}
