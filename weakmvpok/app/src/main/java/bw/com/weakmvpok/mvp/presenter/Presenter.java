package bw.com.weakmvpok.mvp.presenter;

import java.lang.ref.SoftReference;

import bw.com.weakmvpok.MainActivity;
import bw.com.weakmvpok.mvp.model.IModel;
import bw.com.weakmvpok.mvp.model.Model;
import bw.com.weakmvpok.mvp.view.IView;

public class Presenter implements IPresenter{

    private  IModel model;
    private  SoftReference<IModel> iModelSoftReference;
    MainActivity mainActivity;

    @Override
    public void getPreData(String mTextEditString,String page,String count) {
        model.getModel(mTextEditString,page,count,new IModel.ModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                mainActivity.getView(data);
            }

            @Override
            public void onFaill(Exception e) {

            }
        });
    }

    @Override
    public void attchView(IView iView) {
        this.mainActivity = (MainActivity) iView;
        model = new Model();
        iModelSoftReference = new SoftReference<IModel>(model);

    }

    @Override
    public void Detchview() {
        iModelSoftReference.clear();

    }
}
