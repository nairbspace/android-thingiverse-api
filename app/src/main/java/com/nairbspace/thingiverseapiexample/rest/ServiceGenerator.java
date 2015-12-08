package com.nairbspace.thingiverseapiexample.rest;

import com.nairbspace.thingiverseapiexample.rest.interfaces.OAuth2Interface;
import com.nairbspace.thingiverseapiexample.rest.interfaces.ThingiverseInterface;
import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

public class ServiceGenerator {

    public static final String AUTHORIZE_URL = "https://www.thingiverse.com";
    public static final String API_URL = "https://api.thingiverse.com";

    /** Singleton RestAdapter for used for authorizing token */
    private static final RestAdapter AUTHORIZE_REST_ADAPTER = new RestAdapter.Builder()
            .setEndpoint(AUTHORIZE_URL)
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .setClient(new OkClient(new OkHttpClient()))
            .build();

    private static final OAuth2Interface LOGIN_SERVICE =
            AUTHORIZE_REST_ADAPTER.create(OAuth2Interface.class);

    public static OAuth2Interface getLoginService() {
        return LOGIN_SERVICE;
    }

    /** Singleton RestAdapter for Thingiverse API */
    private static final RestAdapter API_REST_ADAPTER = new RestAdapter.Builder()
            .setEndpoint(API_URL)
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .setClient(new OkClient(new OkHttpClient()))
            .build();

    private static final ThingiverseInterface THINGIVERSE_SERVICE =
            API_REST_ADAPTER.create(ThingiverseInterface.class);

    public static ThingiverseInterface getThingiverseService() {
        return THINGIVERSE_SERVICE;
    }
}
