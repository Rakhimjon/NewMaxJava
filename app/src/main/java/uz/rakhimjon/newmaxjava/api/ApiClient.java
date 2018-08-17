package uz.rakhimjon.newmaxjava.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import uz.rakhimjon.newmaxjava.model.NewsModel;
import uz.rakhimjon.newmaxjava.model.NewsSource;

public class ApiClient {

    private  static  final String BASE_URL = "https://newsapi.org/v1/";
    private static ApiInterface apiInterface;
    private static final String NEWS_API_KEY ="f05eb39fa88d4c2fb85c0011d662b4f3";



    public static ApiInterface getClient(){
        if (apiInterface == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build();

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiInterface = client.create(ApiInterface.class);
        }
        return apiInterface;
    }



    public interface ApiInterface {
        @GET("articles?source=google-news&apiKey=" +NEWS_API_KEY)
        Call<NewsSource> getNewsSource();



    }
}
