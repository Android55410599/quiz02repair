package com.example.quiz02repair01_55410599;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ShowPlayStatus extends Activity{

	private ListView ListView;
	@Override
		protected void onCreate(Bundle savedInstanceState) {		
			super.onCreate(savedInstanceState);
			setContentView(R.layout.show);
			ListView = (ListView) findViewById(R.id.listView2_599);
			control599DB control599db = new control599DB(this);
			ArrayList<HashMap<String, String>> MyArrayList = control599db.SelectPlayStatus();
			SimpleAdapter adapter;
			adapter = new SimpleAdapter(ShowPlayStatus.this, MyArrayList, R.layout.itemplaystatus, new String[]{"Play","Player","Random", "Position","Status","Score"},new int[]{R.id.ColPlay_599,R.id.ColUseridp_599,R.id.ColRandom_599, R.id.ColPositionp_599,R.id.ColStatus_599,R.id.ColScorep_599});
			ListView.setAdapter(adapter);
			
		}
}

