package com.vivelabs.android.personalizacion.customviews;

import java.util.List;

import com.vivelabs.android.personalizacion.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemAdapter extends ArrayAdapter<ItemList>{

	Context context;
	public ItemAdapter(Context context, int textViewResourceId,
			List<ItemList> objects) {
		super(context, textViewResourceId, objects);
		this.context=context;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		TextView tV;
		ImageView iV;
		if(v==null){
			v=View.inflate(context, R.layout.item_list, null);
			
			ItemList item = getItem(position);
			
			tV=(TextView)v.findViewById(R.id.txt_titulo);
			tV.setText(item.getTitulo());
			
			tV=(TextView)v.findViewById(R.id.txt_autor);
			tV.setText(item.getAutor());
			
			tV=(TextView)v.findViewById(R.id.txt_hojas);
			tV.setText(item.getPaginas());
			
			iV=(ImageView)v.findViewById(R.id.img);
			iV.setImageBitmap(item.getImagen());
			
		}		
		return v;
	}
	
}
