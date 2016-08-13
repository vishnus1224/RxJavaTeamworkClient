package com.vishnus1224.rxjavateamworkclient.client;

import com.github.aurae.retrofit2.LoganSquareConverterFactory;
import com.vishnus1224.rxjavateamworkclient.config.TeamworkApiConfig;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by Vishnu on 8/13/2016.
 */
class TeamworkApiClient {

    private static String apiToken;

    private static String baseUrl;

    private static Retrofit retrofit;

    protected TeamworkApiClient(TeamworkApiConfig teamworkApiConfig){

        //check if the config that is passed in has the same api token and base url.
        //if they are different then create a new retrofit instance.
        if(!teamworkApiConfig.getApiToken().equals(apiToken) || !teamworkApiConfig.getBaseUrl().equals(baseUrl)){

            this.apiToken = teamworkApiConfig.getApiToken();
            this.baseUrl = teamworkApiConfig.getBaseUrl();

            retrofit = createRetrofit(baseUrl);

        }

    }

    protected Retrofit getRetrofit(){

        return retrofit;

    }

    private OkHttpClient createOkHttpClient() {

        return new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                //add authentication info for each request.
                Request request = chain.request();

                //set the username and the password.
                String credentials = Credentials.basic(apiToken, "zyx");

                Request.Builder builder = request.newBuilder();

                //set the authorization header with basic credentials.
                builder.addHeader("Authorization", credentials);

                request = builder.build();

                return chain.proceed(request);
            }
        }).build();

    }

    private Converter.Factory createConverterFactory() {

        return LoganSquareConverterFactory.create();

    }

    private CallAdapter.Factory createCallAdapterFactory() {

        return RxJavaCallAdapterFactory.create();

    }

    private Retrofit createRetrofit(String baseUrl) {

        return new Retrofit.Builder().
                baseUrl(baseUrl).
                client(createOkHttpClient()).
                addConverterFactory(createConverterFactory()).
                addCallAdapterFactory(createCallAdapterFactory()).
                build();

    }


}
