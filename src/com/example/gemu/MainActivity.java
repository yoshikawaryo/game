package com.example.gemu;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private int[] jyoutai = new int[40];
	private int[] ichi = new int[40];
	private Button[] button = new Button[40];
	private Button[] tatemono = new Button[5];
	private int[] tatemononumber = new int[5];
	private int now = 0;
	private int money = 20000;
	private TextView okanewohyouzisurutoko;
	private String[] color = new String[5];
	private Timer mainTimer;
	private MainTimerTask mainTimerTask;
	private Handler mHandler = new Handler();

	public class MainTimerTask extends TimerTask {
		@Override
		public void run() {
			// ここに定周期で実行したい処理を記述します
			mHandler.post(new Runnable() {
				public void run() {
					Log.d("timer", "called");

					for (int i = 0; i < 28; i++) {
						if (jyoutai[i] == 1) {
							money += 6;
						}

						if (jyoutai[i] == 2) {
							money += 10;
						}

						if (jyoutai[i] == 3) {
							money += 6;
						}

						if (jyoutai[i] == 4) {
							money += 6;
						}

					}
					okanewohyouzisurutoko.setText("" + money + "万円");

				}
			});
		}
	}

	public void tubusu(View v) {
		now = 0;
	}

	public void ofisu(View v) {
		now = 1;
	}

	public void resutoran(View v) {
		now = 2;
	}

	public void ie(View v) {
		now = 3;
	}

	public void hotel(View v) {
		now = 4;
	}

	public void keisan(int bangou) {
		if (now == 4) {
			button[bangou].setBackgroundResource(R.drawable.hotel);
			money -= 1000;
			okanewohyouzisurutoko.setText(money + "万");
		}

		if (now == 3) {
			button[bangou].setBackgroundResource(R.drawable.house2);
			money -= 800;
			okanewohyouzisurutoko.setText(money + "万");
		}
		if (now == 2) {
			button[bangou].setBackgroundResource(R.drawable.restaurant);
			money -= 2000;
			okanewohyouzisurutoko.setText(money + "万");
		}
		if (now == 1) {
			button[bangou].setBackgroundResource(R.drawable.building);
			money -= 400;
			okanewohyouzisurutoko.setText(money + "万");
		}
		if (now == 0) {

			Log.v("now", "0");
			button[bangou].setBackgroundResource(R.drawable.tya);
			if (jyoutai[bangou] == 4) {
				money -= 500;
				okanewohyouzisurutoko.setText(money + "万");
				Log.v("joutai", "4");

				Log.v("now", "0");
				button[bangou].setBackgroundResource(R.drawable.tya);

			}

			if (jyoutai[bangou] == 3) {
				money -= 400;
				okanewohyouzisurutoko.setText(money + "万");
				Log.v("joutai", "3");

				Log.v("now", "0");
				button[bangou].setBackgroundResource(R.drawable.tya);

			}
			if (jyoutai[bangou] == 2) {
				money -= 1000;
				okanewohyouzisurutoko.setText(money + "万");
				Log.v("joutai", "2");

				Log.v("now", "0");
				button[bangou].setBackgroundResource(R.drawable.tya);
			}
			if (jyoutai[bangou] == 1) {
				money -= 200;
				okanewohyouzisurutoko.setText(money + "万");
				Log.v("joutai", "1");
			}
		}
		if (jyoutai[bangou] == 0 || now == 0) {
			jyoutai[bangou] = now;
		} else {
			return;
		}
	}

	public void find(View view) {
		int click_number = Integer.parseInt(view.getTag().toString());
		keisan(click_number);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.mainTimer = new Timer();
		// タスククラスインスタンス生成
		this.mainTimerTask = new MainTimerTask();
		// タイマースケジュール設定＆開始
		this.mainTimer.schedule(mainTimerTask,9000 , 9000);

		tatemononumber[0] = 0;
		tatemononumber[1] = 1;
		tatemononumber[2] = 2;
		tatemononumber[3] = 3;
		tatemononumber[4] = 4;
		ichi[0] = R.id.button5;
		ichi[1] = R.id.button6;
		ichi[2] = R.id.button7;
		ichi[3] = R.id.button8;
		ichi[4] = R.id.button9;
		ichi[5] = R.id.button10;
		ichi[6] = R.id.button11;
		ichi[7] = R.id.button12;
		ichi[8] = R.id.button13;
		ichi[9] = R.id.button14;
		ichi[10] = R.id.button15;
		ichi[11] = R.id.button16;
		ichi[12] = R.id.button17;
		ichi[13] = R.id.button18;
		ichi[14] = R.id.button19;
		ichi[15] = R.id.button20;
		ichi[16] = R.id.button21;
		ichi[17] = R.id.button22;
		ichi[18] = R.id.button23;
		ichi[19] = R.id.button24;
		ichi[20] = R.id.button25;
		ichi[21] = R.id.button26;
		ichi[22] = R.id.button27;
		ichi[23] = R.id.button28;
		ichi[24] = R.id.button29;
		ichi[25] = R.id.button30;
		ichi[26] = R.id.button31;
		ichi[27] = R.id.button32;
		ichi[28] = R.id.button34;
		ichi[29] = R.id.button35;
		ichi[30] = R.id.button36;
		ichi[31] = R.id.button37;
		ichi[32] = R.id.button38;
		ichi[33] = R.id.button39;
		ichi[34] = R.id.button40;
		ichi[35] = R.id.button41;
		ichi[36] = R.id.button42;
		ichi[37] = R.id.button43;
		ichi[38] = R.id.button44;
		ichi[39] = R.id.button45;

		for (int i = 0; i < 40; i++) {
			jyoutai[i] = 0;
			button[i] = (Button) findViewById(ichi[i]);
			button[i].setBackgroundResource(R.drawable.tya);
			button[i].setTag(i);
			// button[i].setVisibility(View.VISIBLE);
			button[i].setText("");
		}
		okanewohyouzisurutoko = (TextView) findViewById(R.id.textView1);
		okanewohyouzisurutoko.setText(money + "万");
		color[0] = "#696969";
		color[1] = "#dcdcdc";

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}