package test.bwie.com.bawaymail.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import test.bwie.com.bawaymail.R;
import test.bwie.com.bawaymail.model.bean.ShopItemBean;
import test.bwie.com.bawaymail.presenter.TypePresenter;

/**
 * @ Description:
 * @ Date:2017/10/19
 * @ Author:贾秀坤
 */

public class ShopDetailAdapter extends RecyclerView.Adapter<ShopDetailAdapter.MyViewHolder> {
    private List<ShopItemBean.DatasBean.GoodsListBean> list=new ArrayList<>();
    private Context mContext;
    private TypePresenter mPresenter;
    private OnitemClickListener mOnitemClickListener;

    public ShopDetailAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<ShopItemBean.DatasBean.GoodsListBean>mlist){
        if (mlist!=null){
            this.list.addAll(mlist);
        }
    }
    public void setOnitemClickListener(OnitemClickListener onitemClickListener){
        this.mOnitemClickListener=onitemClickListener;
    }
    public void setPresenter(TypePresenter presenter){
        this.mPresenter=presenter;
    }
    @Override
    public ShopDetailAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_shopdetail, null,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ShopDetailAdapter.MyViewHolder holder, final int position) {
        holder.tv_shopName.setText(list.get(position).getGoods_name());
        holder.tv_shopPrice.setText("￥"+list.get(position).getGoods_marketprice());
        holder.tv_shopSell.setText("已售:"+list.get(position).getGoods_salenum()+"件");
        mPresenter.getImageFromServer(mContext,list.get(position).getGoods_image_url(),holder.pic);
        if(mOnitemClickListener!=null){
            holder.tv_shopName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    notifyDataSetChanged();
                    mOnitemClickListener.onClick(position);
                }
            });
            holder.pic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    notifyDataSetChanged();
                    mOnitemClickListener.onClick(position);
                }
            });

        }
    }



    public    interface OnitemClickListener{
        void onClick(int position);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView pic;
        private final TextView tv_shopName;
        private final TextView tv_shopPrice;
        private final TextView tv_shopSell;

        public MyViewHolder(View itemView) {
            super(itemView);
            pic = (ImageView) itemView.findViewById(R.id.pic);
            tv_shopName = (TextView) itemView.findViewById(R.id.tv_shopName);
            tv_shopPrice= (TextView) itemView.findViewById(R.id.tv_shopPrice);
            tv_shopSell = (TextView) itemView.findViewById(R.id.tv_shopSell);
        }
    }
}
