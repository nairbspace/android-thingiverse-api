package com.nairbspace.thingiverseapiexample.rest.interfaces;

import com.nairbspace.thingiverseapiexample.model.LoginValidation;

import retrofit.Callback;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * API uses http://www.thingiverse.com
 * NOT http://api.thingiverse.com!
 **/
public interface OAuth2Interface {

    /** https://www.thingiverse.com/login/oauth/tokeninfo?access_token=XXXXX */
    @POST("/login/oauth/tokeninfo")
    void getTokenValidation(
            @Query("access_token") String accessToken,
            Callback<LoginValidation> callback);
}
