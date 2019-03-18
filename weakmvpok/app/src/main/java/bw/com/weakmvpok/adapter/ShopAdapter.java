package bw.com.weakmvpok.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import bw.com.weakmvpok.MainActivity;
import bw.com.weakmvpok.R;
import bw.com.weakmvpok.bean.ShopBean;
import bw.com.weakmvpok.bean.ShopListBean;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {
    Context context;
    ShopListBean shopListBean;
    private ShopListBean.ResultBeans resultBeans;

    public ShopAdapter(Context context, ShopListBean shopListBean){
        this.context  = context;
        this.shopListBean = shopListBean;
    }

    //绑定布局
    @NonNull
    @Override
    public ShopAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.shop_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    //view绑定数据
    @Override
    public void onBindViewHolder(@NonNull ShopAdapter.ViewHolder viewHolder, int i) {
        resultBeans = shopListBean.getResult().get(i);

        Glide.with(context).load(resultBeans.getMasterPic()).into(viewHolder.img_shop);
        viewHolder.text_shop.setText(resultBeans.getCommodityName());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //实现方法
                recyclerviewListener.callBack(v.getId(),resultBeans.getCommodityId());
            }
        });
    }
    //返回数量
    @Override
    public int getItemCount() {
        return shopListBean.getResult().size();
    }
    //初始化视图
    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img_shop;
        private final TextView text_shop;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_shop = itemView.findViewById(R.id.img_shop);
            text_shop = itemView.findViewById(R.id.text_shop);
        }
    }
    RecyclerviewListener recyclerviewListener;

    public void setRecyclerviewListener(RecyclerviewListener recyclerviewListener) {
        this.recyclerviewListener = recyclerviewListener;
    }
    //定义接口
    public interface RecyclerviewListener{
        void  callBack(int i,String id);
    }
}
