package bw.com.weakmvpok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bw.com.weakmvpok.adapter.ShopAdapter;
import bw.com.weakmvpok.bean.ShopBean;
import bw.com.weakmvpok.bean.ShopListBean;
import bw.com.weakmvpok.mvp.presenter.Presenter;
import bw.com.weakmvpok.mvp.view.IView;

public class MainActivity extends AppCompatActivity  implements IView {
    public static final String TAG="MainActivity";
    private RecyclerView recy_view;
    private Presenter presenter;
    private ShopListBean shopListBean;
    private ShopAdapter shopAdapter;
    private Button mBut;
    public EditText mEdit;
    public String mTextEditString="手机";
    String page="1";
    String count="10";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter  = new Presenter();
        presenter.attchView(this);
       presenter.getPreData("电脑",page,count);
        initView();

    }

    private void initView() {
        mBut = findViewById(R.id.button_cha);
        mEdit = findViewById(R.id.edi_cha);
        recy_view = findViewById(R.id.recy_view);
        recy_view.setLayoutManager(new GridLayoutManager(this,2));
        mTextEditString = mEdit.getText().toString();
        mBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mTextEditString.isEmpty()){
                    presenter.getPreData(mTextEditString,page,count);
                }else {
                    Toast.makeText(MainActivity.this,"搜索内容不可以未空",Toast.LENGTH_SHORT).show();

                }

            }
        });


    }

    @Override
    public void getView(Object data) {
        if(data!=null){
            shopListBean= (ShopListBean) data;
            shopAdapter = new ShopAdapter(MainActivity.this, shopListBean);
            recy_view.setAdapter(shopAdapter);

            shopAdapter.setRecyclerviewListener(new ShopAdapter.RecyclerviewListener() {
                //回调
                @Override
                public void callBack(int vid,String id) {
                    Intent intent = new Intent(MainActivity.this, XiangActivity.class);
                    Log.i(TAG, "dataid: "+id);
                    intent.putExtra("id",id);
                    startActivity(intent);
                }
            });
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.Detchview();
    }
}
