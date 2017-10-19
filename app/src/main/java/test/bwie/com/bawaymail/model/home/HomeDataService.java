package test.bwie.com.bawaymail.model.home;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import test.bwie.com.bawaymail.model.bean.AddCartBean;
import test.bwie.com.bawaymail.model.bean.AddressAddBean;
import test.bwie.com.bawaymail.model.bean.AddressBean;
import test.bwie.com.bawaymail.model.bean.AddressEditBean;
import test.bwie.com.bawaymail.model.bean.AreaBean;
import test.bwie.com.bawaymail.model.bean.BuyNowBean;
import test.bwie.com.bawaymail.model.bean.CartDataBean;
import test.bwie.com.bawaymail.model.bean.CityBean;
import test.bwie.com.bawaymail.model.bean.DelCartBean;
import test.bwie.com.bawaymail.model.bean.GoodsDetailBean;
import test.bwie.com.bawaymail.model.bean.LoginBean;
import test.bwie.com.bawaymail.model.bean.LoginOutBean;
import test.bwie.com.bawaymail.model.bean.PayDataBean;
import test.bwie.com.bawaymail.model.bean.ProvinceBean;
import test.bwie.com.bawaymail.model.bean.RegistBean;
import test.bwie.com.bawaymail.model.bean.ShopDetailBean;
import test.bwie.com.bawaymail.model.bean.ShopItemBean;
import test.bwie.com.bawaymail.model.bean.TypeBean;

/**
 * @ Description:
 * @ Date:2017/10/18
 * @ Author:贾秀坤
 */

public interface HomeDataService {

     @FormUrlEncoded
     @POST("mobile/index.php?act=member_cart&op=cart_list")
     Observable<CartDataBean> getGCartListData(@FieldMap Map<String, String> options);

     @FormUrlEncoded
     @POST("mobile/index.php?act=member_cart&op=cart_del")
     Observable<DelCartBean> getGoodsDelData(@FieldMap Map<String, String> options);



     @GET("v1/daily/comic_lists/0")
     Observable<HomeBean> getData(@QueryMap Map<String,String> options);

     @FormUrlEncoded
     @POST("mobile/index.php?act=login&op=register")
     Observable<RegistBean> getRegist(@FieldMap Map<String,String> options);
     @FormUrlEncoded
     @POST("mobile/index.php?act=login")
     Observable<LoginBean> getLogin(@FieldMap Map<String,String> options);

     @GET("mobile/index.php?act=goods_class")
     Observable<TypeBean> getTypeData();

     @GET("mobile/index.php?act=goods&op=goods_body")
     Observable<String> getGoodsIntroduceData(@QueryMap Map<String, String> options);

     @GET("mobile/index.php?act=goods_class")
     Observable<ShopDetailBean> getShopData(@QueryMap Map<String,String> options);

     @GET("mobile/index.php?act=goods_class")
     Observable<ShopDetailBean> getShopDataSuc(@QueryMap Map<String,String> options);

     @GET("mobile/index.php?act=goods&op=goods_list&page=100")
     Observable<ShopItemBean> getShopItemDataSuc(@QueryMap Map<String,String> options);

     @GET("mobile/index.php?act=goods&op=goods_detail")
     Observable<GoodsDetailBean> getGoodsData(@QueryMap Map<String,String> options);

     @FormUrlEncoded
     @POST("mobile/index.php?act=member_buy&op=buy_step1")
     Observable<BuyNowBean> getBuyGoodsData(@FieldMap Map<String, String> options);
     @FormUrlEncoded
     @POST("mobile/index.php?act=member_cart&op=cart_add")
     Observable<AddCartBean> getGoodsAddCartData(@FieldMap Map<String, String> options);

     @FormUrlEncoded
     @POST("mobile/index.php?act=logout")
     Observable<LoginOutBean> getLoginOutData(@FieldMap Map<String, String> options);

     @FormUrlEncoded
     @POST("mobile/index.php?act=member_address&op=address_list")
     Observable<AddressBean> getAddressData(@FieldMap Map<String, String> options);



     @FormUrlEncoded
     @POST("mobile/index.php?act=area&op=index")
     Observable<ProvinceBean> getAddressProvinceData(@FieldMap Map<String, String> options);
     @FormUrlEncoded
     @POST("mobile/index.php?act=area&op=index")
     Observable<CityBean> getAddressCityData(@FieldMap Map<String, String> options);

     @FormUrlEncoded
     @POST("mobile/index.php?act=area&op=index")
     Observable<AreaBean> getAddressAreaData(@FieldMap Map<String, String> options);

     @FormUrlEncoded
     @POST("mobile/index.php?act=member_address&op=address_add")
     Observable<AddressAddBean> getAddressAddData(@FieldMap Map<String, String> options);

     @FormUrlEncoded
     @POST("mobile/index.php?act=member_address&op=address_edit")
     Observable<AddressEditBean> getAddressEditData(@FieldMap Map<String, String> options);

     @FormUrlEncoded
     @POST("mobile/index.php?act=member_buy&op=buy_step2")
     Observable<PayDataBean> getPayData(@FieldMap Map<String, Object> options);

}
