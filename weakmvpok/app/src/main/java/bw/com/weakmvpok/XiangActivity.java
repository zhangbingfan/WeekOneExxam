package bw.com.weakmvpok;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;

import bw.com.weakmvpok.bean.ShopDilBean;
import bw.com.weakmvpok.bean.Xiangbean;
import bw.com.weakmvpok.http.OkHttp;
import bw.com.weakmvpok.mvp.presenter.ShowPresenter;
import bw.com.weakmvpok.mvp.view.ShowView;

public class XiangActivity extends AppCompatActivity implements ShowView {
    public static final String TAG="XiangActivity";
    private String s;
    ShopDilBean shopDilBean;
    public static final String BaseUrlx="http://172.17.8.100/small/commodity/v1/findCommodityDetailsById";
    private String id;
    private ViewPager pager;
    private WebView webView;
    private TextView text_image;
    private TextView textView1;
    private TextView item_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang);
        pager = findViewById(R.id.pager);
        webView = findViewById(R.id.web);
        text_image = findViewById(R.id.text_image);
         textView1 = findViewById(R.id.text1);
        item_text = findViewById(R.id.item_text);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        Log.i(TAG, "onCreate: "+ id);
        //实例化presenter
        ShowPresenter presenter=new ShowPresenter(this);
        presenter.show(id);
      /*  web_view.loadUrl("http://a.vpimg3.com/upload/merchandise/pdcvis/2018/10/17/56/7403c318-24a5-4701-af07-47039f12f795.jpg");
       web_view.getSettings().setJavaScriptEnabled(true);
       web_view.setWebChromeClient(new WebChromeClient());*/

    }

    @Override
    public void view(Xiangbean.ResultBean result) {
        //xiangq
         String details = result.getDetails();
        webView.loadData(details, "text/html", "UTF-8");
        //设置本页面加载
        webView.setWebChromeClient(new WebChromeClient());
        final WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
//        -------------------------------------------------------
        String picture = result.getPicture();
        int price = result.getPrice();
        String categoryName = result.getDescribe();
         String commodityName = result.getCommodityName();
         item_text.setText(commodityName);
        text_image.setText("￥："+price+"");
        textView1.setText(categoryName);

        String[] split = picture.split(",");
        final ArrayList<ImageView> imageViews=new ArrayList<>();
        for (int i=0;i<split.length;i++)
        {
             String s = split[i];
             ImageView imageView = new ImageView(XiangActivity.this);
            Glide.with(XiangActivity.this).load(split[i]).into(imageView);
            imageViews.add(imageView);
        }
        pager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imageViews.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
                return view==o;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                ImageView imageView=imageViews.get(position);
                container.addView(imageView);
                return imageView;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView((View) object);
            }
        });

    }
}
