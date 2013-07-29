package org.gyldenpris.gfg_proto1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class GameActivity extends Activity{

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);
    }
    
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.actions, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Intent intent = new Intent(this, GfgActivity.class);
			startActivity(intent);
			return true;
		case R.id.about:
			Intent AboutIntent = new Intent(this, WebViewActivity.class);
			AboutIntent
					.putExtra("url", "file:///android_asset/misc/about.html");
			startActivity(AboutIntent);
			return true;
		case R.id.help:
			Intent HelpIntent = new Intent(this, WebViewActivity.class);
			HelpIntent.putExtra("url", "file:///android_asset/misc/help.html");
			startActivity(HelpIntent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
