package org.gyldenpris.gfg_proto1;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CounterFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = (RelativeLayout) inflater.inflate(R.layout.counter_layout,
				container, false);

		final TextView counterview1 = (TextView) v
				.findViewById(R.id.counterView1);
		final TextView counterview2 = (TextView) v
				.findViewById(R.id.counterView2);
		final TextView counterview3 = (TextView) v
				.findViewById(R.id.counterView3);

		Time TimerSet = new Time();
		TimerSet.set(30, 4, 2014);
		TimerSet.normalize(true);
		long millisecs = TimerSet.toMillis(true);

		Time TimeNow = new Time();
		TimeNow.setToNow();
		TimeNow.normalize(true);
		long millisecsNow = TimeNow.toMillis(true);

		long millisecsRem = millisecs - millisecsNow;

		new CountDownTimer(millisecsRem, 1000) {
			public void onTick(long millisUntilFinished) {

				long totsec = millisUntilFinished / 1000;

				int weeks = (int) ((millisUntilFinished / 1000) / 604800);
				int days = (int) ((millisUntilFinished / 1000) / 86400);
				int hours = (int) (((millisUntilFinished / 1000) - (days * 86400)) / 3600);
				int minutes = (int) (((millisUntilFinished / 1000) - ((days * 86400) + (hours * 3600))) / 60);
				int seconds = (int) ((millisUntilFinished / 1000) % 60);

				counterview1.setText("" + totsec + " sek");

				counterview2.setText("" + days + " dager " + hours + " timer "
						+ minutes + " min " + seconds + " sek ");

				counterview3.setText("" + weeks + "uker ");

			}

			public void onFinish() {
				counterview2.setText("done!");
//				CountDone();
			}
		}.start();

		return v;
	}

}
