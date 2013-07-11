package com.vivelabs.android.personalizacion.accessdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

	static final int VERSION = 1;
	static final String NOMBRE_BD = "biblioteca";
	public static final String TABLA_LIBROS = "libros";
	public static final String LIBRO = "libro";
	public static final String AUTOR = "autor";
	public static final String HOJAS = "hojas";
	public static final String IMAGEN = "imagen";
	

	public DataBaseHelper(Context context) {
		super(context, NOMBRE_BD, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL("CREATE TABLE "+TABLA_LIBROS+" (_id INTEGER PRIMARY KEY AUTOINCREMENT, "+LIBRO+" VARCHAR, "+AUTOR+"  VARCHAR, "+HOJAS+" INTEGER, "+IMAGEN+" VARCHAR)");
		
		ContentValues cV = new ContentValues();

		cV.put(LIBRO, "Juego de Tronos");
		cV.put(HOJAS, 800);
		cV.put(AUTOR, "George R. R. Martin");
		cV.put(IMAGEN, "juegodetronos");

		db.insert(TABLA_LIBROS, null, cV);

		cV.put(LIBRO, "Infierno");
		cV.put(HOJAS, 640);
		cV.put(AUTOR, "Dan Brown");
		cV.put(IMAGEN, "infierno");

		db.insert(TABLA_LIBROS, null, cV);

		cV.put(LIBRO, "El Resplandor");
		cV.put(HOJAS, 447);
		cV.put(AUTOR, "Stephen King");
		cV.put(IMAGEN, "resplandor");

		db.insert(TABLA_LIBROS, null, cV);

		cV.put(LIBRO, "El hobbit");
		cV.put(HOJAS, 424);
		cV.put(AUTOR, "J. R. R. Tolkien");
		cV.put(IMAGEN, "hobbit");

		db.insert(TABLA_LIBROS, null, cV);

		cV.put(LIBRO, "Tormenta de Espadas");
		cV.put(HOJAS, 973);
		cV.put(AUTOR, "George R. R. Martin");
		cV.put(IMAGEN, "tormentadeespadas");

		db.insert(TABLA_LIBROS, null, cV);

		cV.put(LIBRO, "Angeles y Demonios");
		cV.put(HOJAS, 592);
		cV.put(AUTOR, "Dan Brown");
		cV.put(IMAGEN, "angelesdemonios");

		db.insert(TABLA_LIBROS, null, cV);

		cV.put(LIBRO, "LA Torre Oscura");
		cV.put(HOJAS, 985);
		cV.put(AUTOR, "Stephen King");
		cV.put(IMAGEN, "torreoscura");

		db.insert(TABLA_LIBROS, null, cV);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS "+TABLA_LIBROS);
		onCreate(db);
	}

}
