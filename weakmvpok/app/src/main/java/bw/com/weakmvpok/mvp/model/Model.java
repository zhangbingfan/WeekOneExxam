package bw.com.weakmvpok.mvp.model;

import bw.com.weakmvpok.bean.ShopBean;
import bw.com.weakmvpok.bean.ShopListBean;
import bw.com.weakmvpok.http.OkHttp;
/*
* 商品搜索列表
* */
public class Model  implements IModel{

 String Base_url="http://172.17.8.100/small/commodity/v1/findCommodityByKeyword";

    @Override
    public void getModel(String mTextEditString ,String page,String count,final ModelCallBack modelCallBack) {
        OkHttp.getInstance().doGet(Base_url+"?"+"keyword="+mTextEditString+"&page="+page+"&count="+count, ShopListBean.class, new OkHttp.NetCallBack() {
            @Override
            public void LoadSuccess(Object obj) {
                modelCallBack.onSuccess(obj);
            }

            @Override
            public void LoadFail() {

            }
        });
    }
}
