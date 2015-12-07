package com.nairbspace.thingiverseapiexample.model;

/**
  GET https://api.thingiverse.com/users/me?access_token=e72e16c7e42f292c6912e7710c838347ae178b4a
  {
    "id":244,
    "name":"potatono",
     "url":"https://api.thingiverse.com/users/potatono",
     "thumbnail":"http://thingiverse-production.s3.amazonaws.com/renders/ff/46/e6/04/1f/ApocolypseBurningMan2010_thumb_medium.jpg",
     "bio":"",
     "location":"New York, NY",
     "registered":"2008-11-29T10:26:26-05:00",
     "last_active":"2012-12-31T17:29:19-05:00",
     "things":"https://api.thingiverse.com/users/potatono/things",
     "copies":"https://api.thingiverse.com/users/potatono/copies",
     "likes":"https://api.thingiverse.com/users/potatono/likes",
     "default_license":"cc",
     "email":"justin.day@makerbot.com"
 }
 */

public class UserInfo {
    private int id;
    private String name;
    private String first_name;
    private String last_name;
    private String full_name;
    private String url;
    private String public_url;
    private String thumbnail;
    private String bio;
    private String bio_html;
    private String location;
    private String registered;
    private String last_active;
    private String cover_image;
    private String things_url;
    private String copies_url;
    private String likes_url;
    private String default_license;
    private String email;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public String getFullName() {
        return full_name;
    }

    public String getUrl() {
        return url;
    }

    public String getPublicUrl() {
        return public_url;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getBio() {
        return bio;
    }

    public String getBioHtml() {
        return bio_html;
    }

    public String getLocation() {
        return location;
    }

    public String getRegistered() {
        return registered;
    }

    public String getLastActive() {
        return last_active;
    }

    public String getCoverImage() {
        return cover_image;
    }

    public String getThingsUrl() {
        return things_url;
    }

    public String getCopiesUrl() {
        return copies_url;
    }

    public String getLikesUrl() {
        return likes_url;
    }

    public String getDefaultLicense() {
        return default_license;
    }

    public String getEmail() {
        return email;
    }
}
