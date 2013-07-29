package org.gyldenpris.gfg_proto1;


import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends Activity {

	private WebView webView;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String id = getIntent().getExtras().getString("url");
		String url = id;
		
		setContentView(R.layout.webview_layout);

		webView = (WebView) findViewById(R.id.webView1);
//		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl(url);

	}

}
