package test.bwie.com.bawaymail.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import test.bwie.com.bawaymail.R;
import test.bwie.com.bawaymail.model.bean.CartDataBean;
import test.bwie.com.bawaymail.model.utils.Constant;
import test.bwie.com.bawaymail.presenter.CartPresenter;
import test.bwie.com.bawaymail.view.fragment.CartFragment;

import static test.bwie.com.bawaymail.view.fragment.CartFragment.mCartDataBean;

/**
 * @ Description:
 * @ Date:2017/10/19
 * @ Author:贾秀坤
 */

public class CartAdapter extends  RecyclerView.Adapter<CartAdapter.MyViewHolder>{
    private OnItemClickListener mOnItemClickListener;
    private CartPresenter mPresenter;
    private Context mContext;
    private List<CartDataBean.DatasBean.CartListBean.GoodsBean> mList=new ArrayList<>();

    public CartAdapter(Context context) {
        mContext = context;
    }

    public void setHomePresenter(CartPresenter presenter){
        this.mPresenter=presenter;
    }
    public void setData(List<CartDataBean.DatasBean.CartListBean.GoodsBean> list) {
        if(list!=null){
            mList=list;
            CartFragment.calcTextView.setVisibility(View.VISIBLE);
            CartFragment.buyTextView.setVisibility(View.VISIBLE);
            CartFragment.mCartAdapter.notifyDataSetChanged();
        }else{
            mList.clear();
            CartFragment.calcTextView.setVisibility(View.GONE);
            CartFragment.buyTextView.setVisibility(View.GONE);
            CartFragment.mCartAdapter.notifyDataSetChanged();
        }

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.item_list_cart, null,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        final float priceFloat = Float.parseFloat(mList.get(position).getGoods_price());
        final int countInt = Integer.parseInt(mList.get(position).getGoods_num());
        final float countFloat = priceFloat * countInt;

        holder.storeTextView.setText(mList.get(position).getStore_name());
        mPresenter.getImageFromServer(mContext,mList.get(position).getGoods_image_url(),holder.mImageView);
        holder.titleTextView.setText(mList.get(position).getGoods_name());
        String info1 = "<font color='#FF5001'> ￥ " + priceFloat + "</font><br>x " + countInt;
        holder.info1TextView.setText(Html.fromHtml(info1));
        String info2 = "共 <font color='#FF5001'>" + countInt + "</font> 件商品，";
        info2 += "合计 <font color='#FF5001'>" + countFloat + "</font> 元";
        holder.info2TextView.setText(Html.fromHtml(info2));
        info2 = countInt + "";
        holder.numEditText.setText(info2);
        holder.delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userKeyString = Constant.mSharedPreferences.getString("userKeyString", "");
                String cart_id = mList.get(position).getCart_id();
                mPresenter.getCartDelDataFromF(userKeyString,cart_id);
            }
        });


        holder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String total = mCartDataBean.getDatas().getCart_count()+"";
                mCartDataBean.getDatas().setCart_count(Integer.parseInt(total) + 1 );
                mCartDataBean.getDatas().getCart_list().get(0).getGoods().get(position).setGoods_num(countInt + 1+"");
                updateCalc();
            }
        });

        holder.subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countInt > 1) {
                    String total = mCartDataBean.getDatas().getCart_count()+"";
                    mCartDataBean.getDatas().setCart_count(Integer.parseInt(total) - 1 );
                    mCartDataBean.getDatas().getCart_list().get(0).getGoods().get(position).setGoods_num(countInt - 1+"");
                    updateCalc();
                }
            }
        });
    }
    public void updateCalc() {

        float count = 0.0f;

        for (int i = 0; i < mList.size(); i++) {
            float priceFloat = Float.parseFloat(mList.get(i).getGoods_price());
            int countInt = Integer.parseInt(mList.get(i).getGoods_num());
            float countFloat = priceFloat * countInt;
            count += countFloat;
        }

        mCartDataBean.getDatas().setSum(count + "");
        String total = "共 <font color='#FF5001'>" + mCartDataBean.getDatas().getCart_count() + "</font> 件商品，";
        total += "共 <font color='#FF5001'>" + mCartDataBean.getDatas().getSum() + "</font> 元";
        CartFragment.calcTextView.setText(Html.fromHtml(total));
        CartFragment.mCartAdapter.notifyDataSetChanged();

    }
    @Override
    public int getItemCount() {
        return mList.size();
    }

    public interface OnItemClickListener{
        void onClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener ){
        this.mOnItemClickListener=onItemClickListener;
    }
    class MyViewHolder extends RecyclerView.ViewHolder
    {

        public RelativeLayout mRelativeLayout;
        public TextView storeTextView;
        public ImageView mImageView;
        public TextView titleTextView;
        public TextView info1TextView;
        public TextView info2TextView;
        public Button delButton;
        public Button addButton;
        public EditText numEditText;
        public Button subButton;

        public MyViewHolder(View view)
        {
            super(view);
            mRelativeLayout = (RelativeLayout) view.findViewById(R.id.mainRelativeLayout);
            storeTextView = (TextView) view.findViewById(R.id.storeTextView);
            mImageView = (ImageView) view.findViewById(R.id.mainImageView);
            titleTextView = (TextView) view.findViewById(R.id.titleTextView);
            info1TextView = (TextView) view.findViewById(R.id.info1TextView);
            info2TextView = (TextView) view.findViewById(R.id.info2TextView);
            delButton = (Button) view.findViewById(R.id.delButton);
            addButton = (Button) view.findViewById(R.id.addButton);
            numEditText = (EditText) view.findViewById(R.id.numEditText);
            subButton = (Button) view.findViewById(R.id.subButton);
        }
    }
}

