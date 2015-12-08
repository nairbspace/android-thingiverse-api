package com.nairbspace.thingiverseapiexample.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.nairbspace.thingiverseapiexample.R;
import com.nairbspace.thingiverseapiexample.model.UserInfo;
import com.nairbspace.thingiverseapiexample.rest.ServiceGenerator;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class UserInfoListActivity extends AppCompatActivity {

    private static final String TOKEN_KEY = "tokenKey";
    private String mAccessToken;
    private int mRetryCount;

    private TextView responseTextView;

    public static Intent newIntent(Context context, String accessToken) {
        Intent intent = new Intent(context, UserInfoListActivity.class);
        intent.putExtra(TOKEN_KEY, accessToken);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUserInfo();
            }
        });

        responseTextView = (TextView) findViewById(R.id.reponse_textview);

        mAccessToken = getIntent().getStringExtra(TOKEN_KEY);

        getUserInfo();
    }

    /** Should make this method a separate Service and have activity receive broadcast and update view */
    private void getUserInfo() {
        ServiceGenerator.getThingiverseService().getUserInfo(mAccessToken, new Callback<UserInfo>() {
            @Override
            public void success(UserInfo userInfo, Response response) {
                mRetryCount = 0;

                String responseText = "id: " + userInfo.getId() + "\n"
                        + "name: " + userInfo.getName() + "\n"
                        + "first_name: " + userInfo.getFirstName() + "\n"
                        + "last_name: " + userInfo.getLastName() + "\n"
                        + "full_name: " + userInfo.getFullName() + "\n"
                        + "url: " + userInfo.getUrl() + "\n"
                        + "public_url: " + userInfo.getPublicUrl() + "\n"
                        + "thumbnail: " + userInfo.getThumbnail() + "\n"
                        + "bio: " + userInfo.getBio() + "\n"
                        + "bio_html: " + userInfo.getBioHtml() + "\n"
                        + "location: " + userInfo.getLocation() + "\n"
                        + "registered: " + userInfo.getRegistered() + "\n"
                        + "last_active: " + userInfo.getLastActive() + "\n"
                        + "cover_image: " + userInfo.getCoverImage() + "\n"
                        + "things_url: " + userInfo.getThingsUrl() + "\n"
                        + "copies_url: " + userInfo.getCopiesUrl() + "\n"
                        + "likes_url: " + userInfo.getLikesUrl() + "\n"
                        + "default_license: " + userInfo.getDefaultLicense() + "\n"
                        + "email: " + userInfo.getEmail() + "\n";

                responseTextView.setText(responseText);
            }

            @Override
            public void failure(RetrofitError error) {
                if (mRetryCount < 5) {
                    getUserInfo();
                    mRetryCount++;
                } else {
                    // Error getting user info
                    finish(); // Kill activity
                }
            }
        });
    }
}
