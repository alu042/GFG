package org.gyldenpris.gfg_proto1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

public class NewsFragment extends Fragment {
	private WebView webView;
	private Bundle webViewBundle;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		View v = (LinearLayout) inflater.inflate(R.layout.news_layout,
				container, false);

		webView = (WebView) v.findViewById(R.id.newsView1);
		webView.setWebViewClient(new WebViewClient());
		webView.getSettings()
				.setUserAgentString(
						"Mozilla/5.0 (Linux; Android 4.0.4; Galaxy Nexus Build/IMM76B) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19");

		if (webViewBundle == null) {
			webView.loadUrl(
					"http://www.google.com/search?hl=no&tbm=nws&q=gyldenpris+OR+damsgard+OR+byfjell+OR+damsgardsfjellet+OR+lovstakken+OR+lyderhorn");
		} else {
			webView.restoreState(webViewBundle);
		}

		return v;

	}

	@Override
	public void onPause() {
		super.onPause();

		webViewBundle = new Bundle();
		webView.saveState(webViewBundle);
	}

}
