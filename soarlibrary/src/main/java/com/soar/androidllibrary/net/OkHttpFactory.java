package com.soar.androidllibrary.net;


import com.soar.androidllibrary.utils.Config;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;


/**
 * Created by gaofei on 16/2/23.
 */
public class OkHttpFactory {

    private static OkHttpClient singleton;

    public static OkHttpClient getInstance() {
        if (singleton == null) {
            synchronized (OkHttpFactory.class) {
                if (singleton == null) {
                    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    File cacheDir = new File(Config.CACHAE_DIR, Config.RESPONSE_CACHE);
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    builder.addNetworkInterceptor(interceptor)
                            .cache(new Cache(cacheDir, Config.RESPONSE_CACHE_SIZE))
                            .connectTimeout(Config.HTTP_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                            .readTimeout(Config.HTTP_READ_TIMEOUT, TimeUnit.MILLISECONDS);
                    singleton = builder.build();
                }
            }
        }
        return singleton;
    }
}
