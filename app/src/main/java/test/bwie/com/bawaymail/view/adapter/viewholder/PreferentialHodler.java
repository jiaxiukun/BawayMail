package test.bwie.com.bawaymail.view.adapter.viewholder;

import android.view.View;

import java.util.List;

import test.bwie.com.bawaymail.R;
import test.bwie.com.bawaymail.model.bean.Bean;

/**
 * Created by Administrator on 2017/10/9.
 */

public class PreferentialHodler extends TypeAbstractViewHodler{

    private final VerticalSwitchTextView textView;
    public PreferentialHodler(View itemView) {
        super(itemView);
        textView = (VerticalSwitchTextView) itemView.findViewById(R.id.Vertical_Tv);
    }

    @Override
    public void bindHolder(Bean.DatasBean.GoodsListBean modle) {

    }

    @Override
    public void imageHolder(List<String> modle) {

    }
}
