package test.bwie.com.bawaymail.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import test.bwie.com.bawaymail.R;
import test.bwie.com.bawaymail.model.bean.GoodsDetailBean;
import test.bwie.com.bawaymail.presenter.TypePresenter;
import test.bwie.com.bawaymail.view.activity.GoodDetailActivity;


public class GoodsCmdAdapter extends BaseAdapter implements View.OnClickListener {

    private TypePresenter mPresenter;
    private Context mContext;
    private List<GoodsDetailBean.DatasBean.GoodsCommendListBean> mList=new ArrayList<>();

    public GoodsCmdAdapter(Context context) {
        mContext = context;
    }

    public void setHomePresenter(TypePresenter presenter){
        this.mPresenter=presenter;
    }

    public void setData(List<GoodsDetailBean.DatasBean.GoodsCommendListBean> list) {
        if(list!=null){
            this.mList.addAll(list);
        }

    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        MyViewHolder holder;
        if(convertView==null){
            convertView=View.inflate(mContext, R.layout.class_goods_cmd, null);
            holder=new MyViewHolder();
            holder.tv = (TextView) convertView.findViewById(R.id.class_goods_goodsname);
            holder.img = (ImageView) convertView.findViewById(R.id.class_goods_img);
            holder.tvprice = (TextView) convertView.findViewById(R.id.class_goods_goodsprice);
            holder.mLinearLayout = (LinearLayout) convertView.findViewById(R.id.cmd_linear);
            holder.btn = (ImageView) convertView.findViewById(R.id.btn);
            convertView.setTag(holder);
        }else{
            holder= (MyViewHolder) convertView.getTag();
        }
        holder.tv.setText(mList.get(position).getGoods_name());
        holder.tvprice.setText("￥ "+mList.get(position).getGoods_promotion_price());
        mPresenter.getImageFromServer(mContext,mList.get(position).getGoods_image_url().toString(),holder.img);
        holder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,GoodDetailActivity.class);
                intent.putExtra("id",mList.get(position).getGoods_id());
                mContext.startActivity(intent);

            }
        });
        holder.btn.setOnClickListener(this);
        return convertView;
    }

    @Override
    public void onClick(View v) {
        if (mListener != null) {
            mListener.add(v);
        }
    }

    private AddClickListener mListener;

    public void setListener(AddClickListener listener) {
        mListener = listener;
    }

    public interface AddClickListener {
        void add(View v);
    }

    class MyViewHolder
    {
        ImageView img,btn;
        TextView tv;
        TextView tvprice;
        LinearLayout mLinearLayout;
    }

}
