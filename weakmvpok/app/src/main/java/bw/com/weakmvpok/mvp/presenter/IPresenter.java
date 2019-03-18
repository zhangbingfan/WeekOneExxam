package bw.com.weakmvpok.mvp.presenter;

import bw.com.weakmvpok.MainActivity;
import bw.com.weakmvpok.mvp.view.IView;

public interface IPresenter {
     void getPreData(String mTextEditString,String page,String count);
     void attchView(IView iView);
     void Detchview();
}
