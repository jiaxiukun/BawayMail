package test.bwie.com.bawaymail.model.home;

import retrofit2.Call;
import test.bwie.com.bawaymail.model.utils.Constant;

/**
 * Created by Administrator on 2017/10/9.
 */

public class ApiHome {
    private static volatile ApiHome instance;
    private BaseService baseService;

    public ApiHome() {
        baseService = ApiGenerator.getBaseService();
    }

    public ApiHome getInstance() {
        if (instance == null) {
            synchronized (ApiHome.class) {
                if (instance == null) {
                    instance = new ApiHome();
                }
            }
        }
        return instance;
    }
    public Call<String> getConfigFromService(){

        if(baseService == null){
            baseService = ApiGenerator.getBaseService();
        }
        return  baseService.baseGetRequest(getBaseUrl());

    }
    //private修饰，防止暴露，得到url地址
    private String getBaseUrl(){

        StringBuffer stringBuffer = new StringBuffer();
        return stringBuffer.append(Constant.LINK_ANDROID)
                .toString();
    }
}
