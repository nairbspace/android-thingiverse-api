package com.nairbspace.thingiverseapiexample.model;

/**

 POST https://www.thingiverse.com/login/oauth/tokeninfo?access_token=XXXXXXXXXXXXXXXXXXXXXXXX

    {
       "audience":YOUR_CLIENT_ID,
       "user_id":"244"
    }

 */
public class LoginValidation {
    private String audience; // audience == Client ID
    private String user_id;

    public String getAudience() {
        return audience;
    }
}
