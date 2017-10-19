package test.bwie.com.bawaymail.view.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import test.bwie.com.bawaymail.R;
import test.bwie.com.bawaymail.model.bean.BuyNowBean;

public class BuyGoodsListAdapter extends BaseAdapter {

    private Context mContext;
    private List<BuyNowBean.DatasBean.StoreCartListBean._$1Bean.GoodsListBean> mArrayList;

    public BuyGoodsListAdapter(Context mContext, List<BuyNowBean.DatasBean.StoreCartListBean._$1Bean.GoodsListBean> arrayList) {
        this.mContext = mContext;
        this.mArrayList = arrayList;
    }

    @Override
    public int getCount() {
        if (mArrayList != null) {
            return mArrayList.size();
        }
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return mArrayList.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final Holder holder;

        if (convertView == null) {
            holder = new Holder();
            convertView = View.inflate(mContext, R.layout.item_list_buy_goods, null);
            holder.mRelativeLayout = (RelativeLayout) convertView.findViewById(R.id.mainRelativeLayout);
            holder.storeTextView = (TextView) convertView.findViewById(R.id.storeTextView);
            holder.mImageView = (ImageView) convertView.findViewById(R.id.mainImageView);
            holder.titleTextView = (TextView) convertView.findViewById(R.id.titleTextView);
            holder.info1TextView = (TextView) convertView.findViewById(R.id.info1TextView);
            holder.info2TextView = (TextView) convertView.findViewById(R.id.info2TextView);
            holder.messageEditText = (EditText) convertView.findViewById(R.id.messageEditText);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }


        holder.storeTextView.setText(mArrayList.get(position).getStore_name());
        Glide.with(mContext).load(mArrayList.get(position).getGoods_image_url()).into(holder.mImageView);
        holder.titleTextView.setText(mArrayList.get(position).getGoods_name());
        String info1 = "<font color='#FF5001'> ￥ " + mArrayList.get(position).getGoods_price()+ "</font><br>x " + mArrayList.get(position).getGoods_num();
        holder.info1TextView.setText(Html.fromHtml(info1));
        String info2 = "共 <font color='#FF5001'>" + mArrayList.get(position).getGoods_num() + "</font> 件商品，";
        info2 += "合计 <font color='#FF5001'>" + mArrayList.get(position).getGoods_total() + "</font> 元";
        holder.info2TextView.setText(Html.fromHtml(info2));

        holder.messageEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               // BuySetupActivity.pay_message.put(hashMap.get("store_id"), hashMap.get("store_id") + "|" + holder.messageEditText.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return convertView;

    }

    public class Holder {

        public RelativeLayout mRelativeLayout;
        public TextView storeTextView;
        public ImageView mImageView;
        public TextView titleTextView;
        public TextView info1TextView;
        public TextView info2TextView;
        public EditText messageEditText;

    }

}