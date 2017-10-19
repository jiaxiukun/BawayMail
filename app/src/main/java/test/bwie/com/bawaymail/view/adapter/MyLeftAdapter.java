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
import test.bwie.com.bawaymail.model.bean.TypeBean;
import test.bwie.com.bawaymail.presenter.TypePresenter;

/**
 * @ Description:
 * @ Date:2017/10/19
 * @ Author:贾秀坤
 */
public class MyLeftAdapter extends RecyclerView.Adapter<MyLeftAdapter.MyViewHolder> {
    private List<TypeBean.DatasBean.ClassListBean>list=new ArrayList<>();
    private Context mContext;
    private TypePresenter mPresenter;
    private OnitemClickListener mOnitemClickListener;

    public MyLeftAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<TypeBean.DatasBean.ClassListBean>mlist){
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
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_list_class1, null,false));

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv.setText(list.get(position).getGc_name());
        mPresenter.getImageFromServer(mContext,list.get(position).getImage(),holder.img);
        if (mOnitemClickListener!=null){
            holder.tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnitemClickListener.onClick(position);
                }
            });
            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnitemClickListener.onClick(position);
                }
            });
        }
    }

 
    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnitemClickListener{


        void onClick(int position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        ImageView img;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.class_rlvone_text);
            img = (ImageView) itemView.findViewById(R.id.class_rlvone_img);        }
    }
}
