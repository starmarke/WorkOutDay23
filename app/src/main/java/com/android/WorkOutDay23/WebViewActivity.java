package com.android.WorkOutDay23;

import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.android.WorkOutDay23.databinding.ActivityWebViewBinding;
import com.gyf.immersionbar.ImmersionBar;

public class WebViewActivity extends AppCompatActivity {
    private ActivityWebViewBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mBinding = ActivityWebViewBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(mBinding.getRoot());


        ImmersionBar.with(this)
                .fitsSystemWindows(true)
                .statusBarColor(R.color.white)
                .statusBarDarkFont(true)
                .init();

        mBinding.webView.setWebViewClient(new MyWebViewClient());

        WebSettings webSettings = mBinding.webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mBinding.webView.loadUrl(getIntent().getStringExtra("url"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mBinding.webView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
        mBinding.webView.clearHistory();

        ((ViewGroup) mBinding.webView.getParent()).removeView(mBinding.webView);
        mBinding.webView.destroy();
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            view.loadUrl(url);
            return true;
        }
    }
}