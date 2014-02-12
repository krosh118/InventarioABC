package com.invent.inventarioabc;


import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	String lista = "";
	int contador = 1;
	EditText demanda;
	EditText valor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		demanda = (EditText)findViewById(R.id.editText1);
		valor = (EditText)findViewById(R.id.editText2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	
	public void onAgregar(View boton){
		
		try{
			float den = Float.parseFloat(demanda.getText().toString());
			float val = Float.parseFloat(valor.getText().toString());
			Toast.makeText(getApplicationContext(), "Ingreso: demanda= "+den +"\nvalor= "+val, Toast.LENGTH_SHORT).show();
			demanda.setText("");
			valor.setText("");
			lista += den +"," + val + "_";
		}catch(Exception e){
			
		}
	}
	
	
	public void onOperar(View boton){
		Intent intent = new Intent(MainActivity.this, verlista.class);
		intent.putExtra("Listas", lista);
		startActivity(intent);
	}
	
	public void onBorrar(View boton){
		lista = "";
		Toast.makeText(getApplicationContext(), "Se borro toda la lista", Toast.LENGTH_SHORT).show();
	}
	
	public void onAbrir(View boton){
		String link = "https://play.google.com/store/apps/developer?id=IMAGINE+GT";
		Intent intent = null;
		intent = new Intent(intent.ACTION_VIEW,Uri.parse(link));
		startActivity(intent);
	}
	
	

}
