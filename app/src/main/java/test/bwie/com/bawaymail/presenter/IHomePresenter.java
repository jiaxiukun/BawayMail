package test.bwie.com.bawaymail.presenter;

/**
 * @ Description:
 * @ Date:2017/10/18
 * @ Author:贾秀坤
 */

public interface IHomePresenter {


    void onLoadStart();


    void detachView();
    void getDataFromF();
     /* HttpUtils.getRetrofitData(UrLUtils.homeuri
              ,new HttpUtils.CallBackDataF<HomeBean>(){

          @Override
          public void callBackF(HomeBean homeBean) {
              getIView().callbackStr(homeBean);
          }
      });*/

}
