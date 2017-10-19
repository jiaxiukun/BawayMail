package test.bwie.com.bawaymail.view.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import test.bwie.com.bawaymail.model.bean.Bean;


/*
* viewHolder 的抽象类。主页recyclerView中的viewholder继承他，抽取的方法
* */
public abstract class TypeAbstractViewHodler extends RecyclerView.ViewHolder{
    public TypeAbstractViewHodler(View itemView) {
        super(itemView);
    }
    public  abstract void bindHolder(Bean.DatasBean.GoodsListBean modle);
    public  abstract void imageHolder(List<String> modle);
}