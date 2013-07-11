package com.vivelabs.android.personalizacion.customviews;

import android.graphics.Bitmap;

public class ItemList {
	String titulo,autor,paginas;
	Bitmap imagen;
	
	public ItemList() {
		// TODO Auto-generated constructor stub
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public void setPaginas(String paginas) {
		this.paginas = paginas;
	}
	public void setImagen(Bitmap imagen) {
		this.imagen = imagen;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public Bitmap getImagen() {
		return imagen;
	}
	public String getAutor() {
		return autor;
	}
	public String getPaginas() {
		return paginas;
	}

}
