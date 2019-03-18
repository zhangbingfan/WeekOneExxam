package bw.com.weakmvpok.http;

import android.util.Log;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkUtils {
//  单例模式
    private static  OkUtils okUtils;

    private OkUtils() {
    }
    public  static OkUtils getinstance()
    {
        if (okUtils==null)
        {
            //同步锁
            synchronized (OkUtils.class)
            {
                if (okUtils==null)
                {
                    okUtils=new OkUtils();
                }
            }
        }
        return okUtils;
    }
    public void doget(String url, Callback callback)
    {
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("xxx",message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
        Request request=new Request.Builder()
                .url(url)
                .build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}
