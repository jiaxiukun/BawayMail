package test.bwie.com.bawaymail.view.adapter.viewholder;

import android.view.View;

import com.youth.banner.Banner;

import java.util.List;

import test.bwie.com.bawaymail.R;
import test.bwie.com.bawaymail.model.bean.Bean;

/**
 * Created by Administrator on 2017/10/9.
 */

public class BannerTypeHodler extends TypeAbstractViewHodler{
    private final Banner banner;

    public BannerTypeHodler(View itemView) {
        super(itemView);
        banner = (Banner) itemView.findViewById(R.id.Home_banner);
    }

    @Override
    public void bindHolder(Bean.DatasBean.GoodsListBean modle) {

    }


    @Override
    public void imageHolder(List<String> modle) {
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(modle);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }
}
