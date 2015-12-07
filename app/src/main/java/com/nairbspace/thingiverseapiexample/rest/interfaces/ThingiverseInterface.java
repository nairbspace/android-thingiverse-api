package com.nairbspace.thingiverseapiexample.rest.interfaces;

import com.nairbspace.thingiverseapiexample.model.UserInfo;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface ThingiverseInterface {

    /** GET https://api.thingiverse.com/users/me?access_token=XXXXXXXXXXXXXXXXXX */
    @GET("/users/me")
    void getUserInfo(
            @Query("access_token") String accessToken,
            Callback<UserInfo> callback);
}
