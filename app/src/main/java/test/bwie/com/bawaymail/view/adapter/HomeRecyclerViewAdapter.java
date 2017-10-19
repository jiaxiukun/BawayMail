package test.bwie.com.bawaymail.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import test.bwie.com.bawaymail.R;
import test.bwie.com.bawaymail.model.bean.Bean;
import test.bwie.com.bawaymail.view.adapter.viewholder.BannerTypeHodler;
import test.bwie.com.bawaymail.view.adapter.viewholder.GoodsDetailsHodler;
import test.bwie.com.bawaymail.view.adapter.viewholder.NavigationHodler;
import test.bwie.com.bawaymail.view.adapter.viewholder.PreferentialHodler;

/**
 * Created by Administrator on 2017/10/9.
 */

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Bean.DatasBean.GoodsListBean> list;
    private List<String> list_image;
    private Context context;
    private BannerTypeHodler bannerTypeHodlerhodler;
    private NavigationHodler mNavigationHodler;
    private PreferentialHodler mpreferentialHodler;
    private GoodsDetailsHodler mgoodsDetailsHodler;
    private List<String> list_str;

    public HomeRecyclerViewAdapter(List<Bean.DatasBean.GoodsListBean> list, List<String> list_image, Context context) {
        this.list = list;
        this.list_image = list_image;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                bannerTypeHodlerhodler = new BannerTypeHodler(LayoutInflater.from(context).inflate(R.layout.banner_layout, parent, false));
                return bannerTypeHodlerhodler;
            case 1:
                mNavigationHodler = new NavigationHodler(LayoutInflater.from(context).inflate(R.layout.navig_layout, parent, false));
                return mNavigationHodler;
            case 2:
                mpreferentialHodler = new PreferentialHodler(LayoutInflater.from(context).inflate(R.layout.preferent_layout, parent, false));
                return mpreferentialHodler;
            case 3:
                mgoodsDetailsHodler = new GoodsDetailsHodler(LayoutInflater.from(context).inflate(R.layout.goodsdetails_layout, parent, false));
                return mgoodsDetailsHodler;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        int viewType = getItemViewType(position);
        switch (viewType){
            case 0:
                bannerTypeHodlerhodler.imageHolder(list_image);
                break;
            case 1:
                break;
            case 2:
                list_str = new ArrayList<String>();
                list_str.add("苹果,橘子大降价了,全场九五折!!!!");
                list_str.add("金得利复合肥你忠诚的伙伴!!!");
                list_str.add("没啥事情就是想打个广告!");
                list_str.add("有些钱烧的就是想打广告");
                list_str.add("看见旁边的这位打广告我也想打");
                list_str.add("苹果,橘子大降价了,全场九五折!!!!");
                list_str.add("苹果,橘子大降价了,全场九五折!!!!");
                list_str.add("苹果,橘子大降价了,全场九五折!!!!");
                mpreferentialHodler.imageHolder(list_str);
                break;
            case 3:
                mgoodsDetailsHodler.bindHolder(list.get(position));
                Glide.with(context).load(list.get(position).goods_image_url).into( mgoodsDetailsHodler.image);
                break;

        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else if (position == 2) {
            return 2;
        } else {
            return 3;
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }
}
