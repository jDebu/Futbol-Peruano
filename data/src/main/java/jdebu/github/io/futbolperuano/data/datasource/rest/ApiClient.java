package jdebu.github.io.futbolperuano.data.datasource.rest;


import jdebu.github.io.futbolperuano.data.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jose on 18/04/2017.
 */

public class ApiClient {
    private static final String API_BASE_URL= BuildConfig.BASE_URL;
    private  static DevServicesApiInterface devServicesApiInterface;
    private static OkHttpClient.Builder httpClient;

    public static  DevServicesApiInterface getDevServicesApiClient(){
        if(devServicesApiInterface == null){
            Retrofit.Builder builder=new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

            httpClient=new OkHttpClient.Builder();
            httpClient.addInterceptor(interceptor());

            Retrofit retrofit=builder.client(httpClient.build()).build();
            devServicesApiInterface = retrofit.create(DevServicesApiInterface.class);
        }
        return devServicesApiInterface;
    }
    private  static HttpLoggingInterceptor interceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor= new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }
}
