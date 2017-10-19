package test.bwie.com.bawaymail.presenter;


import test.bwie.com.bawaymail.model.bean.CartDataBean;
import test.bwie.com.bawaymail.model.bean.DelCartBean;
import test.bwie.com.bawaymail.model.utils.HttpUtils;
import test.bwie.com.bawaymail.view.iview.CartView;



public class CartPresenter extends BasePresenter<CartView>{


    public  <T> void  getCartDelDataFromF(String key,String cart_id){

        HttpUtils.getGoodsDelData(key,cart_id,new HttpUtils.CallBackDataF<DelCartBean>() {
            @Override
            public void callBackF(DelCartBean homeBean) {
                getIView().getCartDelData(homeBean);
            }
        });
    }


    public  <T> void  getCartListDataFromF(String key){

        HttpUtils.getCartListData(key,new HttpUtils.CallBackDataF<CartDataBean>() {
            @Override
            public void callBackF(CartDataBean homeBean) {
                getIView().getCartListData(homeBean);
            }
        });
    }


}
