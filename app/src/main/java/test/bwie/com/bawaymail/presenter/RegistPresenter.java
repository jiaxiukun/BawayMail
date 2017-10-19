package test.bwie.com.bawaymail.presenter;

import test.bwie.com.bawaymail.model.bean.RegistBean;
import test.bwie.com.bawaymail.model.utils.HttpUtils;
import test.bwie.com.bawaymail.view.iview.RegistView;



public class RegistPresenter extends BasePresenter<RegistView> {
    public <T>void getDataFromF(String name,String email,String pwd,String pwdconfirm){
        HttpUtils.getRegistData(name, email, pwd, pwdconfirm, new HttpUtils.CallBackDataF<RegistBean>() {
            @Override
            public void callBackF(RegistBean registBean) {
                getIView().getViewSuccess(registBean);
            }
        });
    }
}
