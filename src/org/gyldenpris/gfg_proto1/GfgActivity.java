package org.gyldenpris.gfg_proto1;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class GfgActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);

		Tab homeTab = actionBar.newTab();
		String home_label = getResources().getString(R.string.home);
		TabListener<HomeFragment> home = new TabListener<HomeFragment>(this,
				home_label, HomeFragment.class);
		homeTab.setTabListener(home);
		homeTab.setIcon(R.drawable.tab_home);
		actionBar.addTab(homeTab, 0);

		
		Tab imageTab = actionBar.newTab();
		String image_label = getResources().getString(R.string.images);
		TabListener<ImageFragment> image = new TabListener<ImageFragment>(this,
				image_label, ImageFragment.class);
		imageTab.setTabListener(image);
		imageTab.setIcon(R.drawable.tab_images);
		actionBar.addTab(imageTab, 1);
		
		
		Tab newsTab = actionBar.newTab();
		String news_label = getResources().getString(R.string.rss);
		TabListener<NewsFragment> news = new TabListener<NewsFragment>(this,
				news_label, NewsFragment.class);
		newsTab.setTabListener(news);
		newsTab.setIcon(R.drawable.tab_rss);
		actionBar.addTab(newsTab, 2);



		Tab counterTab = actionBar.newTab();
		String counter_label = getResources().getString(R.string.countdown);
		TabListener<CounterFragment> count = new TabListener<CounterFragment>(
				this, counter_label, CounterFragment.class);
		counterTab.setTabListener(count);
		counterTab.setIcon(R.drawable.tab_countdown);
		actionBar.addTab(counterTab, 3);

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

	public void LaunchChat(View v) {
		Intent myIntent = new Intent(GfgActivity.this, ChatActivity.class);
		GfgActivity.this.startActivity(myIntent);
	}
	
	public void LaunchGame(View v) {
		Intent myIntent = new Intent(GfgActivity.this, GameActivity.class);
		GfgActivity.this.startActivity(myIntent);
	}
	
	
//    public void ShowImage(View v) {
//		Intent myIntent = new Intent(GfgActivity.this, ImageActivity.class);
//		startActivity(myIntent);
//    }
    

}