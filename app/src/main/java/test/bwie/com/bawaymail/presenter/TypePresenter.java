package test.bwie.com.bawaymail.presenter;

import java.util.Map;

import test.bwie.com.bawaymail.model.bean.AddCartBean;
import test.bwie.com.bawaymail.model.bean.BuyNowBean;
import test.bwie.com.bawaymail.model.bean.GoodsDetailBean;
import test.bwie.com.bawaymail.model.bean.PayDataBean;
import test.bwie.com.bawaymail.model.bean.ShopDetailBean;
import test.bwie.com.bawaymail.model.bean.ShopItemBean;
import test.bwie.com.bawaymail.model.bean.TypeBean;
import test.bwie.com.bawaymail.model.utils.HttpUtils;
import test.bwie.com.bawaymail.view.iview.TypeView;

/**
 * @ Description:
 * @ Date:2017/10/18
 * @ Author:贾秀坤
 */

public class TypePresenter extends BasePresenter<TypeView> {
     public <T>void getDataFromF(Class<T> t){
          HttpUtils.getTypeData(new HttpUtils.CallBackDataF<TypeBean>() {
               @Override
               public void callBackF(TypeBean typeBean) {
                    getIView().getDataSuc(typeBean);
               }
          });
     }
     public <T>void getShopDataFromF(String id,Class<T> t){
          HttpUtils.getShopData(id, new HttpUtils.CallBackDataF<ShopDetailBean>() {
               @Override
               public void callBackF(ShopDetailBean shopDetailBean) {
                    getIView().getShopDetailSuc(shopDetailBean);
               }
          });
     }
     public <T>void getShopFromF(String id,Class<T> t){
          HttpUtils.getShopData(id, new HttpUtils.CallBackDataF<ShopDetailBean>() {
               @Override
               public void callBackF(ShopDetailBean shopDetailBean) {
                    getIView().getShopSuc(shopDetailBean);
               }
          });
     }
    public <T>void getGoodsFromF(String id,Class<T> t){
          HttpUtils.getGoodsData(id, new HttpUtils.CallBackDataF<GoodsDetailBean>() {
               @Override
               public void callBackF(GoodsDetailBean goodDetailBean) {
                    getIView().getGoodsDetail(goodDetailBean);
               }
          });
     }

     public<T> void getShopItemData(String id,String key,Class<T> t){
          HttpUtils.getShopItemData (id,key, new HttpUtils.CallBackDataF<ShopItemBean>() {
               @Override
               public void callBackF(ShopItemBean shopItemBean) {
                         getIView().getItemData(shopItemBean);
               }
          });
     }
     public  <T> void  getGoodsIntroduceFromF(String link){
          HttpUtils.getGoodsIntroduceData(link,new HttpUtils.CallBackDataF<String>() {
               @Override
               public void callBackF(String homeBean) {
                    getIView().getGoodsItduData(homeBean);
               }
          });
     }
     public  <T> void  getGoodsBuyNowFromF(Class<T> t,String key,String cart_id){

          HttpUtils.getBuyGoodsData(key,cart_id,new HttpUtils.CallBackDataF<BuyNowBean>() {
               @Override
               public void callBackF(BuyNowBean homeBean) {
                    getIView().getGoodsBuyNowData(homeBean);
               }
          });
     }

     public  <T> void  getGoodsAddCartFromF(String userKeyString,String mId,String quantity){

          HttpUtils.getGoodsAddCartData(userKeyString,mId,quantity,new HttpUtils.CallBackDataF<AddCartBean>() {
               @Override
               public void callBackF(AddCartBean homeBean) {
                    getIView().getGoodsAddCartData(homeBean);
               }
          });
     }
    public  <T> void  getGoodsPreIdFromF(Map<String, Object> map ){

        HttpUtils.getGoodsPreIdData(map,new HttpUtils.CallBackDataF<PayDataBean>() {
            @Override
            public void callBackF(PayDataBean homeBean) {
                getIView().getGoodsPreIdData(homeBean);
            }
        });
    }
}
