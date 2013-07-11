package com.vivelabs.android.personalizacion;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ClipData.Item;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;

import com.vivelabs.android.personalizacion.accessdata.DataBaseHelper;
import com.vivelabs.android.personalizacion.customviews.ItemAdapter;
import com.vivelabs.android.personalizacion.customviews.ItemList;

public class MainActivity extends Activity {

	
	ListView list;
	SQLiteDatabase db;
	Cursor cursor;//almacenar el resultado de las sentencias...
	
	ItemAdapter adapter;
	List<ItemList> datos;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		list=(ListView) findViewById(R.id.list);
		

		
		DataBaseHelper dbHelper= new DataBaseHelper(this);
		db=dbHelper.getWritableDatabase();
		cursor= db.rawQuery("SELECT * FROM "+DataBaseHelper.TABLA_LIBROS, null);

		datos = new ArrayList<ItemList>();
		
		
		adapter = new ItemAdapter(this, R.layout.item_list, datos);

		llenardatos();
		list.setAdapter(adapter);
		
	}
	
	@Override
	protected void onDestroy() {
		//Cerramos la base de datos y el cursor cuando se finalice este Activity
		if(db.isOpen())
			db.close();
		if(!cursor.isClosed())
			cursor.close();
		super.onDestroy();
	}
	
	public void llenardatos(){
		for (int i = 0; i < cursor.getCount(); i++) {
			cursor.moveToPosition(i);
			ItemList item = new ItemList();
			item.setTitulo(cursor.getString(1));
			item.setAutor(cursor.getString(2));
			item.setPaginas(""+cursor.getInt(3));
			item.setImagen(getBitmap(cursor.getString(4)));
			
			datos.add(item);
			
		}
		adapter.notifyDataSetChanged();
	}
	
	public Bitmap getBitmap(String nombre){
		try {
			InputStream is = getAssets().open("portadas/"+nombre+".png");
			Bitmap imagen = BitmapFactory.decodeStream(is);
			return imagen;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
	}
	
}

