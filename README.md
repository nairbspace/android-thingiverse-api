# Thingiverse API Example for Android
Basic Android layout for OAuth2 verification and API Access using Thingiverse's API. Square's awesome libraries do most of the grunt work. This example can be used for just about any other REST APIs that also need OAuth2 verification. The code is very generic and does not use any SharedPrefences, Services, and/or Broadcast Receivers. That is up to you on how you want to implement it, but I did leave comments in the code where it would probably be recommended.

Only semi-tricky part is the OAuth2 verification. Lots of online examples put the Client Secret inside the app, but by doing so, your secret... is no longer a secret. My example shows how to do it without the client secret. Also, the redirect URL in your code must be the one in your Thingiverse App Settings and must be valid! I don't recommend using the `redirect_uri` query in your code. Just put a generic Redirect URL, such as `http://thingiverse.com`, in the Thingiverse App Settings and copy it in your code. If you do choose to use the `redirect_uri` query, read more about it [here](https://developer.github.com/v3/oauth/#redirect-urls) and it's limitations. Because of this decision, that means you can't create an intent filter with a unique scheme/host that only your app will default to when the redirect URL is triggered, but that's ok, you can catch the redirect URL with a WebView in your app and the `shouldOverrideUrlLoading` method.  

# Libraries Used
[Square's OkHttp](http://square.github.io/okhttp/) v2.2.0

[Square's Retrofit](http://square.github.io/retrofit/) v1.9.0
