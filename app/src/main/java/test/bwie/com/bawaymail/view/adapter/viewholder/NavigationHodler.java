package test.bwie.com.bawaymail.view.adapter.viewholder;

import android.view.View;
import android.widget.RadioButton;

import java.util.List;

import test.bwie.com.bawaymail.R;
import test.bwie.com.bawaymail.model.bean.Bean;

/**
 * Created by Administrator on 2017/10/9.
 */

public class NavigationHodler extends TypeAbstractViewHodler{

    public NavigationHodler(View itemView) {
        super(itemView);
        RadioButton radio_but1 = (RadioButton) itemView.findViewById(R.id.home_RadioButton1);
        RadioButton radio_but2 = (RadioButton) itemView.findViewById(R.id.home_RadioButton2);
        RadioButton radio_but3 = (RadioButton) itemView.findViewById(R.id.home_RadioButton3);
        RadioButton radio_but4 = (RadioButton) itemView.findViewById(R.id.home_RadioButton4);
        RadioButton radio_but5 = (RadioButton) itemView.findViewById(R.id.home_RadioButton5);
        RadioButton radio_but6 = (RadioButton) itemView.findViewById(R.id.home_RadioButton6);
        RadioButton radio_but7 = (RadioButton) itemView.findViewById(R.id.home_RadioButton7);
        RadioButton radio_but8 = (RadioButton) itemView.findViewById(R.id.home_RadioButton8);
    }

    @Override
    public void bindHolder(Bean.DatasBean.GoodsListBean modle) {

    }

    @Override
    public void imageHolder(List<String> modle) {

    }
}
