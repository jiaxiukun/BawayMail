package test.bwie.com.bawaymail.model.utils;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import test.bwie.com.bawaymail.BuildConfig;
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
import test.bwie.com.bawaymail.model.home.HomeBean;
import test.bwie.com.bawaymail.model.home.HomeDataService;

public class HttpUtils {

    public  static Retrofit create(String url){
      OkHttpClient.Builder builder = new OkHttpClient.Builder();
      builder.readTimeout(10, TimeUnit.SECONDS);
      builder.connectTimeout(9,TimeUnit.SECONDS);

      if (BuildConfig.DEBUG){
          HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
          httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
          builder.addInterceptor(httpLoggingInterceptor);
      }

      return new Retrofit.Builder()
              .baseUrl(url).client(builder.build())
              .addConverterFactory(GsonConverterFactory .create())
              .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
              .build();
  }
    public static void  getGoodsPreIdData(Map<String, Object> map,final CallBackDataF<PayDataBean> callBackDataF){
        Retrofit retrofit1 = create(Constant.LINK_MAIN);
        HomeDataService service = retrofit1.create(HomeDataService.class);
        Observable<PayDataBean> goodsPreIdData = service.getPayData(map);
        goodsPreIdData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PayDataBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PayDataBean value) {
                      callBackDataF.callBackF(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                       Log.d("zzz",e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public static void  getAddressCityData(String key,String area_id,final CallBackDataF<CityBean> callBackDataF){
        Retrofit retrofit1 = create(Constant.LINK_MAIN);
        HomeDataService service = retrofit1.create(HomeDataService.class);
        Map<String, String> map = new HashMap<>();
        map.put("key", key);
        map.put("area_id", area_id);
        service.getAddressCityData(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CityBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(CityBean value) {
                        callBackDataF.callBackF(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
    public static void  getAddressAreaData(String key,String area_id,final CallBackDataF<AreaBean> callBackDataF){
        Retrofit retrofit1 = create(Constant.LINK_MAIN);
        HomeDataService service = retrofit1.create(HomeDataService.class);
        Map<String, String> map = new HashMap<>();
        map.put("key", key);
        map.put("area_id", area_id);
        service.getAddressAreaData(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AreaBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(AreaBean value) {
                        callBackDataF.callBackF(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                    }
                });

    }
    public static void  getAddressEditData(Map<String, String> map,final CallBackDataF<AddressEditBean> callBackDataF){
        Retrofit retrofit1 = create(Constant.LINK_MAIN);
        HomeDataService service = retrofit1.create(HomeDataService.class);
        service.getAddressEditData(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AddressEditBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(AddressEditBean value) {
                        callBackDataF.callBackF(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("xxx",e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                    }
                });

    }
    public static void  getAddressAddData(Map<String, String> map,final CallBackDataF<AddressAddBean> callBackDataF){
        Retrofit retrofit1 = create(Constant.LINK_MAIN);
        HomeDataService service = retrofit1.create(HomeDataService.class);
        service.getAddressAddData(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AddressAddBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(AddressAddBean value) {
                        callBackDataF.callBackF(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });

    }
    public static void  getAddressProvinceData(String key,final CallBackDataF<ProvinceBean> callBackDataF){
        Retrofit retrofit1 = create(Constant.LINK_MAIN);
        HomeDataService service = retrofit1.create(HomeDataService.class);
        Map<String, String> map = new HashMap<>();
        map.put("key", key);
        service.getAddressProvinceData(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ProvinceBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ProvinceBean value) {
                        callBackDataF.callBackF(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public static void  getAddressData(String key,final CallBackDataF<AddressBean> callBackDataF){
        Retrofit retrofit1 = create(Constant.LINK_MAIN);
        HomeDataService service = retrofit1.create(HomeDataService.class);
        Map<String, String> map = new HashMap<>();
        map.put("key", key);
        service.getAddressData(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AddressBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AddressBean value) {
                        callBackDataF.callBackF(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public static void  getLoginOutData(final CallBackDataF<LoginOutBean> callBackDataF){
        Retrofit retrofit1 = create(Constant.LINK_MAIN);
        HomeDataService service = retrofit1.create(HomeDataService.class);
        Map<String, String> map = new HashMap<>();
        String mUserKeyString = Constant.mSharedPreferences.getString("userKeyString","");
        String User_Username = Constant.mSharedPreferences.getString("User_Username","");
        map.put("key", mUserKeyString);
        map.put("username", User_Username);
        map.put("client", Constant.SYSTEM_TYPE);
        service.getLoginOutData(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginOutBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginOutBean value) {

                        callBackDataF.callBackF(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public static void  getCartListData(String key,final CallBackDataF<CartDataBean> callBackDataF){
        Retrofit retrofit1 = create(Constant.LINK_MAIN);
        HomeDataService service = retrofit1.create(HomeDataService.class);
        Map<String, String> map = new HashMap<>();
        map.put("key", key);
        service.getGCartListData(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CartDataBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CartDataBean value) {
                        callBackDataF.callBackF(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public static void  getGoodsDelData(String key,String cart_id,final CallBackDataF<DelCartBean> callBackDataF){
        Retrofit retrofit1 = create(Constant.LINK_MAIN);
        HomeDataService service = retrofit1.create(HomeDataService.class);
        Map<String, String> map = new HashMap<>();
        map.put("key", key);
        map.put("cart_id", cart_id);
        service.getGoodsDelData(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DelCartBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(DelCartBean value) {
                        callBackDataF.callBackF(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                    @Override
                    public void onComplete() {
                    }
                });
    }
    public static void  getGoodsAddCartData(String userKeyString,String mId,String quantity,final CallBackDataF<AddCartBean> callBackDataF){
        Retrofit retrofit1 = create(Constant.LINK_MAIN);
        HomeDataService service = retrofit1.create(HomeDataService.class);
        Map<String,String> map = new HashMap<>();
        map.put("key", userKeyString);
        map.put("goods_id", mId);
        map.put("quantity", quantity);
        service.getGoodsAddCartData(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AddCartBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AddCartBean value) {
                        callBackDataF.callBackF(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public static void  getBuyGoodsData(String key,String cart_id,final CallBackDataF<BuyNowBean> callBackDataF){
        Retrofit retrofit1 = create(Constant.LINK_MAIN);
        HomeDataService service = retrofit1.create(HomeDataService.class);
        Map<String, String> map = new HashMap<>();
        map.put("key",key);
        map.put("cart_id", cart_id);
        service.getBuyGoodsData(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BuyNowBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(BuyNowBean value) {
                        callBackDataF.callBackF(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("ZZZ",e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }



    public static void  getGoodsIntroduceData(String link,final CallBackDataF<String> callBackDataF){
        Retrofit retrofit1 = create(Constant.LINK_MAIN);
        HomeDataService service = retrofit1.create(HomeDataService.class);
        Map<String, String> map = new HashMap<>();
        map.put("goods_id", link);
        service.getGoodsIntroduceData(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String value) {
                        callBackDataF.callBackF(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
    public static void getGoodsData(String id, final CallBackDataF<GoodsDetailBean>callBackDataF){
        Retrofit retrofit = create(Constant.LINK_MAIN);
        HomeDataService homeDataService = retrofit.create(HomeDataService.class);

        Map<String,String> map=new HashMap<>();
        map.put("goods_id", id);
        homeDataService.getGoodsData(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GoodsDetailBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GoodsDetailBean value) {
                         callBackDataF.callBackF(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


    public static void getShopItemData(String key,String id, final CallBackDataF<ShopItemBean>callBackDataF){
        Retrofit retrofit = create(Constant.LINK_MAIN);
        HomeDataService homeDataService = retrofit.create(HomeDataService.class);

        Map<String,String> map=new HashMap<>();
        map.put("keyword", id);
        map.put("key",key);
        homeDataService.getShopItemDataSuc(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShopItemBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShopItemBean value) {
                        callBackDataF.callBackF(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    public static void getShopDataSuc(String id, final CallBackDataF<ShopDetailBean>callBackDataF){
        Retrofit retrofit = create(Constant.LINK_MAIN);
        HomeDataService homeDataService = retrofit.create(HomeDataService.class);

        Map<String,String> map=new HashMap<>();
        map.put("gc_id", id);
        homeDataService.getShopDataSuc(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShopDetailBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShopDetailBean value) {
                        callBackDataF.callBackF(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    public static void getShopData(String id, final CallBackDataF<ShopDetailBean>callBackDataF){
        Retrofit retrofit = create(Constant.LINK_MAIN);
        HomeDataService homeDataService = retrofit.create(HomeDataService.class);

        Map<String,String> map=new HashMap<>();
        map.put("gc_id", id);
        homeDataService.getShopData(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShopDetailBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShopDetailBean value) {
                        callBackDataF.callBackF(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    public static void getTypeData(final CallBackDataF<TypeBean>callBackDataF){
        Retrofit retrofit = create(Constant.LINK_MAIN);
        HomeDataService homeDataService = retrofit.create(HomeDataService.class);
        homeDataService.getTypeData()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<TypeBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(TypeBean value) {
               callBackDataF.callBackF(value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    public static void  getLoginData(String username, String pwd, final CallBackDataF<LoginBean> callBackDataF){
        Retrofit retrofit = create(Constant.LINK_MAIN);
        HomeDataService service = retrofit.create(HomeDataService.class);
        Map<String, String> map=new HashMap<>();
        map.put("username", username);
        map.put("password", pwd);
        map.put("client", Constant.SYSTEM_TYPE);
        service.getLogin(map)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<LoginBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(LoginBean value) {
                 callBackDataF.callBackF(value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
    public static void getRegistData(String username, String email, String pwd, String pwdConfirm, final CallBackDataF<RegistBean> callBackDataF){
        Retrofit retrofit = create(Constant.LINK_MAIN);
        HomeDataService homeDataService = retrofit.create(HomeDataService.class);
        Map<String, String> map=new HashMap<>();
        map.put("username", username);
        map.put("password", pwd);
        map.put("password_confirm", pwdConfirm);
        map.put("email", email);
        map.put("client", Constant.SYSTEM_TYPE);
        homeDataService.getRegist(map)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<RegistBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RegistBean value) {
                 callBackDataF.callBackF(value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
    public  static  void  getRetrofitData(String url, final CallBackDataF<HomeBean>callBackDataF){
        Retrofit retrofit = create(url);
        HomeDataService homeDataService = retrofit.create(HomeDataService.class);
        Map<String,String> map=new HashMap<>();
        map.put("since", "0");
        map.put("gender", "0");
        map.put("sa_event", "eyJwcm9qZWN0Ijoia3VhaWthbl9hcHAiLCJ0aW1lIjoxNDg3NzQyMjQwNjE1LCJwcm9wZXJ0aWVzIjp7IkhvbWVwYWdlVGFiTmFtZSI6IueDremXqCIsIlZDb21tdW5pdHlUYWJOYW1lIjoi54Ot6ZeoIiwiJG9zX3ZlcnNpb24iOiI0LjQuMiIsIkdlbmRlclR5cGUiOiLlpbPniYgiLCJGcm9tSG9tZXBhZ2VUYWJOYW1lIjoi54Ot6ZeoIiwiJGxpYl92ZXJzaW9uIjoiMS42LjEzIiwiJG5ldHdvcmtfdHlwZSI6IldJRkkiLCIkd2lmaSI6dHJ1ZSwiJG1hbnVmYWN0dXJlciI6ImJpZ25veCIsIkZyb21Ib21lcGFnZVVwZGF0ZURhdGUiOjAsIiRzY3JlZW5faGVpZ2h0IjoxMjgwLCJIb21lcGFnZVVwZGF0ZURhdGUiOjAsIlByb3BlcnR5RXZlbnQiOiJSZWFkSG9tZVBhZ2UiLCJGaW5kVGFiTmFtZSI6IuaOqOiNkCIsImFidGVzdF9ncm91cCI6MTEsIiRzY3JlZW5fd2lkdGgiOjcyMCwiJG9zIjoiQW5kcm9pZCIsIlRyaWdnZXJQYWdlIjoiSG9tZVBhZ2UiLCIkY2FycmllciI6IkNoaW5hIE1vYmlsZSIsIiRtb2RlbCI6IlZQaG9uZSIsIiRhcHBfdmVyc2lvbiI6IjMuNi4yIn0sInR5cGUiOiJ0cmFjayIsImRpc3RpbmN0X2lkIjoiQTo2YWRkYzdhZTQ1MjUwMzY1Iiwib3JpZ2luYWxfaWQiOiJBOjZhZGRjN2FlNDUyNTAzNjUiLCJldmVudCI6IlJlYWRIb21lUGFnZSJ9");
        homeDataService.getData(map)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<HomeBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(HomeBean value) {
                callBackDataF.callBackF(value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        })
        ;
    }
 public  interface CallBackDataF<T>{
     void callBackF(T t);
 }
}
