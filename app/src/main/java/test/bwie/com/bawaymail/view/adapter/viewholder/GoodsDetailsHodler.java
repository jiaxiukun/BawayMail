package test.bwie.com.bawaymail.view.adapter.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import test.bwie.com.bawaymail.R;
import test.bwie.com.bawaymail.model.bean.Bean;

/**
 * Created by Administrator on 2017/10/9.
 */

public class GoodsDetailsHodler extends TypeAbstractViewHodler{

    private final TextView text1;
    private final TextView text2;
    public ImageView image;

    public GoodsDetailsHodler(View itemView) {
        super(itemView);
        text1 = (TextView) itemView.findViewById(R.id.Tv_home_goodsderails_1);
        text2 = (TextView) itemView.findViewById(R.id.Tv_home_goodsderails_2);
        image = (ImageView) itemView.findViewById(R.id.image_home_gooodsderails);
    }

    @Override
    public void bindHolder(Bean.DatasBean.GoodsListBean modle) {
        text1.setText(modle.goods_jingle);
        text2.setText(modle.goods_name);
    }

    @Override
    public void imageHolder(List<String> modle) {

    }
}
