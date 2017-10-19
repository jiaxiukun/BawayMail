package test.bwie.com.bawaymail.view.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;


public class DetailPicAdapter extends PagerAdapter {
    private List<ImageView> viewlist;
    private Context mContext;

    public DetailPicAdapter(List<ImageView> viewlist, Context mContext) {
        this.viewlist = viewlist;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return viewlist.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
//        // TODO Auto-generated method stub
//        ImageView img=new ImageView(mContext);
//        img.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
//        img.setScaleType(ImageView.ScaleType.FIT_XY);
//        Glide.with(mContext).load(viewlist.get(position)).placeholder(R.mipmap.ic_normal_class_press).into(img);
//        container.addView(img);

        // TODO Auto-generated method stub
        ImageView img=viewlist.get(position);
        img.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        img.setScaleType(ImageView.ScaleType.FIT_XY);
//        Glide.with(mContext).load(viewlist.get(position)).placeholder(R.mipmap.ic_normal_class_press).into(img);
        container.addView(img);
        return img;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
        ((ViewPager) container).removeView((View) object);
    }

}
