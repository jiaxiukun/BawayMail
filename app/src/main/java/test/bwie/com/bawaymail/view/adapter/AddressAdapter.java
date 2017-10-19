package test.bwie.com.bawaymail.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import test.bwie.com.bawaymail.R;
import test.bwie.com.bawaymail.model.bean.AddressBean;
import test.bwie.com.bawaymail.presenter.AddressPresenter;
/**
 * @ Description:
 * @ Date:2017/10/19
 * @ Author:贾秀坤
 */

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.MyViewHolder> implements View.OnClickListener {
    private List<AddressBean.DatasBean.AddressListBean> mList=new ArrayList<>();
    private Context mContext;
    private Activity mActivity;
    private MyViewHolder holder;
    private OnItemClickListener mOnItemClickListener;
    private AddressPresenter mPresenter;



    public AddressAdapter(Context context,Activity activity) {
        mContext = context;
        mActivity = activity;
    }
    public void setData(List<AddressBean.DatasBean.AddressListBean> list) {
        mList=list;
    }
    public void setHomePresenter(AddressPresenter presenter){
        this.mPresenter=presenter;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_list_address, null, false);
        holder = new MyViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.trueNameTextView.setText(mList.get(position).getTrue_name());
        holder.phoneTextView.setText(mList.get(position).getMob_phone());
        holder.addressTextView.setText(mList.get(position).getArea_info());
        holder.addressTextView.append(" ");
        holder.addressTextView.append(mList.get(position).getAddress());
        if (mList.get(position).getIs_default().equals("1")) {
            holder.defaultCheckBox.setChecked(true);
        } else {
            holder.defaultCheckBox.setChecked(false);
        }
       holder.itemView.setTag(position);

        holder.defaultCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mList.get(position).getIs_default().equals("1")) {
                    holder.defaultCheckBox.setChecked(true);
                } else {
                    holder.defaultCheckBox.setChecked(false);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener!=null){
            mOnItemClickListener.onClick(v,(int)v.getTag());
        }
    }

    public interface OnItemClickListener{
        void onClick(View view ,int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener ){
        this.mOnItemClickListener=onItemClickListener;
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout mRelativeLayout;
        public CheckBox defaultCheckBox;
        public TextView trueNameTextView;
        public TextView phoneTextView;
        public TextView addressTextView;
        public MyViewHolder(View view) {
            super(view);
            mRelativeLayout = (RelativeLayout) view.findViewById(R.id.mainRelativeLayout);
            defaultCheckBox = (CheckBox) view.findViewById(R.id.defaultCheckBox);
            trueNameTextView = (TextView) view.findViewById(R.id.trueNameTetView);
            phoneTextView = (TextView) view.findViewById(R.id.phoneTextView);
            addressTextView = (TextView) view.findViewById(R.id.addressTextView);
        }
    }
}
