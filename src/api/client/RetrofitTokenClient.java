package api.client;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import api.common.RetrofitConfig;
import api.retrofit.ContentRetrofitApi;
import api.retrofit.ProgramRetrofitApi;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

public class RetrofitTokenClient {
	
	private static String BASE_URL = "http://127.0.0.1:8080/api/" ; 
	
	public static ProgramRetrofitApi getProgramRetrofitApi() {
		return getInstance().create(ProgramRetrofitApi.class);
	}
	
	public static ContentRetrofitApi getContentRetrofitApi() {
		return getInstance().create(ContentRetrofitApi.class);
	}
	
	public static void reBaseUrl(String ip) {
		BASE_URL = "http://" + ip + ":8080/api/";
	}
	
	private static Retrofit getInstance() {
		Gson gson = new GsonBuilder().create();
		
		return new Retrofit.Builder()
				.baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create(gson))
				.client(jsonPlaceholderOkHttpClient())
				.build()
				;
	}
	
	public static OkHttpClient jsonPlaceholderOkHttpClient() {

        return new OkHttpClient.Builder()
                .addInterceptor(new JsonPlaceholderInterceptor())
                .build();
    }
	
	public static class JsonPlaceholderInterceptor implements Interceptor {

	    @Override
	    public Response intercept(Chain chain) throws IOException {

	    	Request original = chain.request();
	        HttpUrl originalHttpUrl = original.url();
	 
	        HttpUrl url = originalHttpUrl.newBuilder()
	                .addQueryParameter("token", RetrofitConfig.TOKEN)
	                .build();
	 
	        Request.Builder requestBuilder = original.newBuilder()
	                .url(url);
	 
	        Request request = requestBuilder.build();
	        
	        return chain.proceed(request);
	    }
	}
}

