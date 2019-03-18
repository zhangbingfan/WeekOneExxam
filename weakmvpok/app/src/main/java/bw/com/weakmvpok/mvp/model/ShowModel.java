package bw.com.weakmvpok.mvp.model;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

import java.io.IOException;

import bw.com.weakmvpok.bean.Xiangbean;
import bw.com.weakmvpok.http.OkUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ShowModel {
      String url="http://172.17.8.100/small/commodity/v1/findCommodityDetailsById";
      public interface onShowClickListener
      {
          void onResult(Xiangbean.ResultBean result);
      }
      private onShowClickListener onShowClickListener;

    public void setOnShowClickListener(ShowModel.onShowClickListener onShowClickListener) {
        this.onShowClickListener = onShowClickListener;
    }

    private Handler handler=new Handler()
      {
          @Override
          public void handleMessage(Message msg) {
              super.handleMessage(msg);
              switch (msg.what)
              {
                  case 0:
                       String obj = (String) msg.obj;
                       Gson gson = new Gson();
                       Xiangbean xiangbean = gson.fromJson(obj, Xiangbean.class);
                       Xiangbean.ResultBean result = xiangbean.getResult();
                       onShowClickListener.onResult(result);
                      break;
              }
          }
      };
    public void showData(String id) {
        OkUtils.getinstance().doget(url + "?commodityId=" + id, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                 String json = response.body().string();

                 Message message = new Message();
                 message.what=0;
                 message.obj=json;

                 //发送消息
                handler.sendMessage(message);
            }
        });
    }
}
