package com.invent.inventarioabc;

import java.util.ArrayList;

import com.invent.lista.lista;
import com.invent.lista.nodo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class verlista extends Activity{

	lista lis = new lista();
	ArrayList<String> list;
	ArrayList<String> list2;
    ArrayAdapter<String> aa;
    int estado = 0;
    int totaldatos = 0;
    float consumoValoracionTotal=0;
    
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.consumovaloracion);
		Bundle bl = getIntent().getExtras();
		String lista[] = bl.getString("Listas").split("[_]");
		String lista2[];
		
		
		
		for(int i = 0; i< lista.length; i++){
			lista2 = lista[i].split("[,]");
			float j = Float.parseFloat(lista2[0]);
			float k = Float.parseFloat(lista2[1]);
			lis.agregar(new nodo(i+1,j,k,0f,0f,0f,0f ));
		}
		
		ListView m = (ListView)findViewById(R.id.lista);
		consumoValoracionTotal = 0;
		totaldatos = 0;
		nodo aux = lis.raiz;
		this.list = new ArrayList<String>();  
		this.list2 = new ArrayList<String>(); 
        this.aa = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        m.setAdapter(aa);
        list.add("Consumo de Valoracion");
 	    list2.add("");
        
        while(aux!=null){
        	aux.consumoValoracion = aux.demanda * aux.valorarticulo;
        	consumoValoracionTotal += aux.consumoValoracion;
        	list.add(""+aux.consumoValoracion);
     	    list2.add(""+aux.codigo);
     	    totaldatos ++;
        	aux = aux.sig;
        }
        list.add("Total = "+consumoValoracionTotal);
 	    list2.add("");
        list.add("Siguiente");
 	    list2.add("");
 	    list.add("Inicio");
	    list2.add("");

        aa.notifyDataSetChanged(); 
        m.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        	@Override
            public void onItemClick(AdapterView adapter, View view, int position, long arg) {
        		//llamada(list2.get(position));
        		   Toast.makeText(getApplicationContext(), "Selección: " + list.get(position), Toast.LENGTH_SHORT).show();
        		   if(list.get(position).equals("Siguiente")){
        			   if(estado<=4){
        				   estado ++;
        			   }
        			   
        			   list.clear();
        			   list2.clear();
        			   operacion(estado);
        			   aa.notifyDataSetChanged(); 
        		   }else if(list.get(position).equals("Inicio")){
        			   Intent intent = new Intent(verlista.this, MainActivity.class);
        			   startActivity(intent);
        		   }
            }
		});
		
	}
	
	
	public void operacion(int estado){
		nodo aux = lis.raiz;
		int total = 0;
		
		if(estado == 1){
			list.add("Porcentaje de Participacion");
	 	    list2.add("");
	        
	        while(aux!=null){
	        	aux.porcentajeParticipacion = 100 / totaldatos ;
	        	list.add(aux.codigo+") "+aux.porcentajeParticipacion);
	     	    list2.add(""+aux.codigo);
	        	aux = aux.sig;
	        }
	        list.add("Total de datos = "+totaldatos);
	 	    list2.add("");
	        list.add("Siguiente");
	 	    list2.add("");
	 	    list.add("Inicio");
		    list2.add("");
		}else if(estado == 2){
			list.add("Porcentaje de Consumo");
	 	    list2.add("");
	        while(aux!=null){
	        	aux.porcentajeConsumo = (aux.consumoValoracion / consumoValoracionTotal)*100 ;
	        	list.add(aux.codigo+") "+aux.porcentajeConsumo);
	     	    list2.add(""+aux.codigo);
	        	aux = aux.sig;
	        }
	        list.add("Siguiente");
	 	    list2.add("");
	 	    list.add("Inicio");
		    list2.add("");
		    
		    
		}else if(estado == 4){
			list.add("Consumo Acumulado");
	 	    list2.add("");
	 	    aux.consumoAcumulado = aux.porcentajeConsumo;
	 	    list.add(aux.codigo+") "+aux.consumoAcumulado);
    	    list2.add(""+aux.codigo);
	 	    aux = aux.sig;
	        while(aux!=null){
	        	
	        	aux.consumoAcumulado = aux.ant.consumoAcumulado + aux.porcentajeConsumo ;
	        	list.add(aux.codigo+") "+aux.consumoAcumulado);
	     	    list2.add(""+aux.codigo);
	        	aux = aux.sig;
	        }
	 	    list.add("Inicio");
		    list2.add("");
		}else if(estado == 3){
			list.add("Porcentaje de Consumo Ordenado");
	 	    list2.add("");
			lis.equilibrar();
			aux = lis.raiz;
			while(aux!=null){
				list.add(aux.codigo+") "+aux.porcentajeConsumo);
	     	    list2.add(""+aux.codigo);
	        	aux = aux.sig;
			}
			list.add("Siguiente");
	 	    list2.add("");
	 	    list.add("Inicio");
		    list2.add("");
		}else if(estado == 0){
			 list.add("Consumo de Valoracion");
		 	 list2.add("");
		        
		     while(aux!=null){
		    	aux.consumoValoracion = aux.demanda * aux.valorarticulo;
		        consumoValoracionTotal += aux.consumoValoracion;
		        list.add(""+aux.consumoValoracion);
		     	list2.add(""+aux.codigo);
		     	totaldatos ++;
		     	aux = aux.sig;
		     }
		     list.add("Total = "+consumoValoracionTotal);
		 	 list2.add("");
		     list.add("Siguiente");
		 	 list2.add("");
		 	 list.add("Inicio");
			 list2.add("");
		}
		
		
	}
	
	
	
	
	
	
	
}
