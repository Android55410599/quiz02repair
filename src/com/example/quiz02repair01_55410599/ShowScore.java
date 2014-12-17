package com.example.quiz02repair01_55410599;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ShowScore  extends Activity {
	private ListView ListView;
	@Override
		protected void onCreate(Bundle savedInstanceState) {		
			super.onCreate(savedInstanceState);
			setContentView(R.layout.show);
			ListView = (ListView) findViewById(R.id.listView2_599);
			String getUserid = getIntent().getStringExtra("Userid").toString();
			control599DB control599db = new control599DB(this);
			ArrayList<HashMap<String, String>> MyArrayList = control599db.SelectAllScore(getUserid);
			SimpleAdapter adapter;
			adapter = new SimpleAdapter(ShowScore.this, MyArrayList, R.layout.itemscore, new String[]{"Scoreid","Userid","Score"},new int[]{R.id.ColScoreid_599,R.id.ColUserid_599,R.id.ColScore_599});
			ListView.setAdapter(adapter);
			
		}
	}

