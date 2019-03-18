package bw.com.weakmvpok.mvp.presenter;

import bw.com.weakmvpok.bean.Xiangbean;
import bw.com.weakmvpok.mvp.model.ShowModel;
import bw.com.weakmvpok.mvp.view.ShowView;

public class ShowPresenter {

    private ShowModel model;
    private final ShowView showView;

    //在构造方法中实例化model和View
    public ShowPresenter(ShowView view) {
        model = new ShowModel();
        showView = view;
    }

    public void show(String id) {
        model.showData(id);
        model.setOnShowClickListener(new ShowModel.onShowClickListener() {
            @Override
            public void onResult(Xiangbean.ResultBean result) {
                showView.view(result);
            }
        });
    }
}
