package com.nairbspace.thingiverseapiexample.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.nairbspace.thingiverseapiexample.model.LoginValidation;
import com.nairbspace.thingiverseapiexample.rest.ServiceGenerator;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class WebviewActivity extends Activity {

    /** ENTER Client ID from Thingiverse here */
    public static final String CLIENT_ID = "XXXXXXXXXXXXXXXXXXXXXXXX";

    private int mRetryCount;
    private String mAccessToken;

    public static Intent newIntent(Context context) {
        return new Intent(context, WebviewActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView webView = new WebView(this);
        setContentView(webView);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                if (url.contains("https://thingiverse.com/#access_token")) {
                    String[] split = url.split("=");
                    mAccessToken = split[1]; /** Should make access token persistent (ie. SharedPreferences) */
                    getTokenValidation();
                } else if (url.contains("#error")) {
                    finish();
                }
                return false;
            }
        });

        String loginURL = "https://www.thingiverse.com/login/oauth/authorize"
            + "?client_id=" + CLIENT_ID
            + "&response_type=token";
        webView.loadUrl(loginURL);
    }

    /** Should make this method a separate Service */
    private void getTokenValidation() {
        ServiceGenerator.getLoginService().getTokenValidation(mAccessToken, new Callback<LoginValidation>() {
            @Override
            public void success(LoginValidation loginValidation, Response response) {
                mRetryCount = 0;
                String audience = loginValidation.getAudience();
                if (audience != null && audience.equals(CLIENT_ID)) {
                    // Success
                    Intent intent = UserInfoListActivity.newIntent(getApplicationContext(), mAccessToken);
                    startActivity(intent);

                } else {
                    // Audience doesn't match Client ID in app
                    finish();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                if (mRetryCount < 5) {
                    getTokenValidation();
                    mRetryCount++;
                } else {
                    // Error validating token
                    finish();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        /** Need to remove cookies in case user needs to re-login*/
        if (Build.VERSION.SDK_INT < 21) {
            CookieManager.getInstance().removeAllCookie();
        } else {
            CookieManager.getInstance().removeAllCookies(null);
        }
    }
}
