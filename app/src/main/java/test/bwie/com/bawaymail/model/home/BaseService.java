package test.bwie.com.bawaymail.model.home;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Url;

/**
 * @ Description:
 * @ Date:2017/10/18
 * @ Author:贾秀坤
 */

public interface BaseService {
    // http://h5test.newaircloud.com/api/getConfig?sid=xy

    @GET
    Call<String> baseGetRequest(@Url String user);

    //带请求头的get请求
    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @GET
    public Call<String> baseGetRequestHeaders(@Url String user, @Header("token") String token);

    @FormUrlEncoded
    @POST
    Call<String> basePostRequest(@Url String user, @FieldMap Map<String, String> params);

    //带请求头的post请求
    @FormUrlEncoded
    @POST
    Call<String> basePostRequestHeaders(@Url String user, @FieldMap Map<String, String> params, @Header("token") String token);
    //文件上传
    @Multipart
    @POST
    Call<String> baseUploadFile(@Url String user, @PartMap Map<String, String> params);

}
