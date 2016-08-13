package com.vishnus1224.rxjavateamworkclient;

import com.github.aurae.retrofit2.LoganSquareConverterFactory;

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
public class TeamworkApiClient {

    private final String apiToken;

    private final String baseUrl;

    private Retrofit retrofit;

    public TeamworkApiClient(String apiToken, String baseUrl) {

        if (apiToken == null || apiToken.isEmpty()) {

            throw new IllegalArgumentException("Token cannot be null or empty");

        }

        if (baseUrl == null || baseUrl.isEmpty()) {

            throw new IllegalArgumentException("Url cannot be null or empty");

        }

        this.apiToken = apiToken;

        this.baseUrl = baseUrl;

        this.retrofit = createRetrofit();

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

    private Retrofit createRetrofit() {

        return new Retrofit.Builder().
                baseUrl(baseUrl).
                client(createOkHttpClient()).
                addConverterFactory(createConverterFactory()).
                addCallAdapterFactory(createCallAdapterFactory()).
                build();

    }

}
