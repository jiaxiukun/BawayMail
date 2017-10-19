package test.bwie.com.bawaymail.presenter;

import test.bwie.com.bawaymail.model.bean.LoginBean;
import test.bwie.com.bawaymail.model.utils.Constant;
import test.bwie.com.bawaymail.model.utils.HttpUtils;
import test.bwie.com.bawaymail.view.iview.LoginView;



public class LoginPresenter extends BasePresenter<LoginView> {
    public <T> void getLoginData(final String username, final String pwd){
        HttpUtils.getLoginData(username, pwd, new HttpUtils.CallBackDataF<LoginBean>() {
            @Override
            public void callBackF(LoginBean loginBean) {
                if (loginBean.getCode()==200){
                    getIView().getLoginViewSuc(loginBean);
                    Constant.userLoginBoolean = true;
                    Constant.userUsernameString = username;
                    Constant.userPasswordString = pwd;

                    Constant.mSharedPreferencesEditor.putBoolean("User_Login", true);
                    Constant.mSharedPreferencesEditor.putString("User_Username", username);
                    Constant.mSharedPreferencesEditor.putString("User_Password", pwd);
                    Constant.mSharedPreferencesEditor.putString("userKeyString", loginBean.getDatas().getKey());
                    Constant.mSharedPreferencesEditor.apply();
                    Constant.userIdString = loginBean.getDatas().getUserid();
                    Constant.userKeyString = loginBean.getDatas().getKey();
                }else {
                    getIView().getLoginErr("登陆失败",0);
                }



            }
        });
    }
}
