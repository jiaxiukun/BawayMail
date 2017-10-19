package test.bwie.com.bawaymail.model.home;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import test.bwie.com.bawaymail.model.utils.Constant;

/**
 * @ Description:
 * @ Date:2017/10/18
 * @ Author:贾秀坤
 */

public class ApiGenerator {

    static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constant.LINK_ANDROID)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build();

    public static BaseService getBaseService(){
        return retrofit.create(BaseService.class);
    }


}
