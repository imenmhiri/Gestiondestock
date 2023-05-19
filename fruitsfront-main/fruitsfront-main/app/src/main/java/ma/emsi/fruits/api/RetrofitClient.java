package ma.emsi.fruits.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "http://192.168.64.1:8080/API/";
    private static RetrofitClient monInstance;
    private Retrofit retrofit;

    private RetrofitClient() {
    retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }
    public static synchronized RetrofitClient getInstance(){
            if(monInstance ==null){
                monInstance =new RetrofitClient();
            }
            return monInstance;
        }

        public Api getApi(){
        return retrofit.create(Api.class);
        }

}
