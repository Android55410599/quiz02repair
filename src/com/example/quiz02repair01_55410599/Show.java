package com.example.quiz02repair01_55410599;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Show  extends Activity {
	private ListView ListView;
	@Override
		protected void onCreate(Bundle savedInstanceState) {		
			super.onCreate(savedInstanceState);
			setContentView(R.layout.show);
			ListView = (ListView) findViewById(R.id.listView2_599);
			control599DB control599db = new control599DB(this);
			ArrayList<HashMap<String, String>> MyArrayList = control599db.SelectAllData();
			SimpleAdapter adapter;
			adapter = new SimpleAdapter(Show.this, MyArrayList, R.layout.item, new String[]{"Userid","Username","Password","Position"},new int[]{R.id.ColUserid_599,R.id.ColUsername_599,R.id.ColPassword_599,R.id.ColPosition_599});
			ListView.setAdapter(adapter);
			
		}
	}