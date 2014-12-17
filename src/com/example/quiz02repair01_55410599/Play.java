package com.example.quiz02repair01_55410599;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Play<getUserid> extends Activity implements OnClickListener {
	private Button btnp1, btnp2, btnp3, btnsh, btnc;
	private int result, rn, random, result2;
	private String getUserid, put;
	int sum1 = 0; int sum2 = 0; int sum3 = 0;
	int ran1, ran2, ran3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.play);
		btnp1 = (Button) findViewById(R.id.btnp1_599);
		btnp2 = (Button) findViewById(R.id.btnp2_599);
		btnp3 = (Button) findViewById(R.id.btnp3_599);
		btnsh = (Button) findViewById(R.id.btnsh_599);
		btnc = (Button) findViewById(R.id.btnc);
		btnp1.setOnClickListener(this);
		btnp2.setOnClickListener(this);
		btnp3.setOnClickListener(this);
		btnsh.setOnClickListener(this);
		btnc.setOnClickListener(this);
		
		getUserid = getIntent().getStringExtra("Userid");
		getUserid.toString();

	
	}

	private int random() {
		int rnds = 0;
		Random r = new Random();		
			rnds = r.nextInt(3 - 1 + 1) + 1;		
		return rnds;
	}

	private int calpos(int sum1){
		result = random();
		sum1 = result + sum1;		
		return sum1;
	}
	
	private int calscore(int num2){
		result2 = random();
		num2 = result2 + num2;		
		return num2;
	}

	@Override
	public void onClick(View v) {
		control599DB db = new control599DB(this);
		int con1 = 1,con0 = 0;	
		int total1 = 0, total2 = 0, total3 = 0, random1, random2, random3;
		int score1 = 0, score2 = 0, score3 = 0;
		int Random1, Random2, Random3;

		//int result2, result3;
		//result2 = 0;
		//result3 = 0;
		//int result = random();
		//int sum1 = 0;
		
		//sum1 = result + sum1;
		int Score1, Score2, Score3;
		int strPlay1 = 1, strPlay2 = 2, strPlay3 = 3;		
		String strPlayer1 = "Player1", strPlayer2 = "Player2", strPlayer3 = "Player3";			

		switch (v.getId()) {
		case R.id.btnp1_599:		
			total1 = calpos(sum1);
			random1 = random();
			sum1 = total1;
			ran1 = random1;
			Score1 = db.RouteScore(total1); Score2 = db.RouteScore(con0); Score3 = db.RouteScore(con0);	
			Random1 = db.Random(random1); Random2 = db.Random(con0); Random3 = db.Random(con0);
			db.InsertPlayStatus(strPlay1, strPlayer1, result, total1, con1, Score1);
			db.InsertPlayStatus(strPlay2, strPlayer2, con0, total2, con0, Score2);
			db.InsertPlayStatus(strPlay3, strPlayer3, con0, total3, con0, Score3);
			
			Intent i = new Intent(getApplicationContext(), ShowPlayStatus.class);
			startActivity(i);
			break;
			
		case R.id.btnp2_599:
			total2 = calpos(sum2);
			random2 = random();
			sum2 = total2;		
			ran2 = random2;
			Score1 = db.RouteScore(con0);Score2 = db.RouteScore(total2); Score3 = db.RouteScore(con0);
			Random1 = db.Random(con0); Random2 = db.Random(random2); Random3 = db.Random(con0);
			db.InsertPlayStatus(strPlay1, strPlayer1, con0, total1, con1, Score1);
			db.InsertPlayStatus(strPlay2, strPlayer2, result, total2, con0, Score2);
			db.InsertPlayStatus(strPlay3, strPlayer3, con0, total3, con0, Score3);
			
			Intent j = new Intent(getApplicationContext(), ShowPlayStatus.class);
			startActivity(j);
			break;
			
		case R.id.btnp3_599:	
			total3 = calpos(sum3);	
			random3 = random();
			sum3 = total3;		
			ran3 = random3;
			Score1 = db.RouteScore(con0);Score2 = db.RouteScore(con0); Score3 = db.RouteScore(total3);	
			Random1 = db.Random(con0); Random2 = db.Random(con0); Random3 = db.Random(random3);
			db.InsertPlayStatus(strPlay1, strPlayer1, con0, total1, con1, Score1);
			db.InsertPlayStatus(strPlay2, strPlayer2, con0, total2, con0, Score2);
			db.InsertPlayStatus(strPlay3, strPlayer3, result, total3, con0, Score3);
			
			Intent k = new Intent(getApplicationContext(), ShowPlayStatus.class);
			startActivity(k);
			break;
			
		case R.id.btnc:
			finish();
			break;
		default:
			break;
		}

	}

}

