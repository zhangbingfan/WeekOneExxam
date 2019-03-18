package bw.com.weakmvpok.mvp.model;

public interface IModel {

    void getModel(String mTextEditString,String page,String count,ModelCallBack modelCallBack);

    interface ModelCallBack{
        void onSuccess(Object data);

        void onFaill(Exception e);
    }
}