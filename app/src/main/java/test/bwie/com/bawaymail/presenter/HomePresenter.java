package test.bwie.com.bawaymail.presenter;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import test.bwie.com.bawaymail.model.bean.Bean;
import test.bwie.com.bawaymail.model.utils.Constant;
import test.bwie.com.bawaymail.model.utils.OkHttpManager;
import test.bwie.com.bawaymail.view.iview.IView;

/**
 * Created by Administrator on 2017/10/11.
 */

public class HomePresenter implements IHomePresenter {
    private IView iView;
    private List<String> list_image = new ArrayList<String>();
    private List<Bean.DatasBean.GoodsListBean> beanList = new ArrayList<>();


    public HomePresenter(IView iView, List<String> list_image, List<Bean.DatasBean.GoodsListBean> beanList) {
        this.iView = iView;
        this.list_image = list_image;
        this.beanList = beanList;
    }

    public HomePresenter() {
    }

    @Override
    public void onLoadStart() {
        iView.showOrHideLoading(true);
        getDataFromF();
    }

    @Override
    public void detachView() {
        if (iView != null) {
            iView = null;
        }
    }

    @Override
    public void getDataFromF() {
        OkHttpManager.getInstance().asyncJsonStringByURL(Constant.LINK_MOBILE_GOODS_SEARCH, new OkHttpManager.Func1() {
            @Override
            public void onResponse(String result) {
                if (iView != null) {
                    iView.showOrHideLoading(false);
                }
                String replace = result.replace("192.168.56.1", "169.254.34.113");
                Gson gson = new Gson();
                Bean bean = gson.fromJson(replace, Bean.class);
                beanList = bean.datas.goods_list;
                list_image = new ArrayList<String>();
                for (int i = 0; i < 4; i++) {
                    list_image.add(beanList.get(i).goods_image_url);
                }
            }
        });
    }
}
