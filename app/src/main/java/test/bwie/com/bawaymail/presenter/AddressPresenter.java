package test.bwie.com.bawaymail.presenter;

import java.util.Map;

import test.bwie.com.bawaymail.model.bean.AddressAddBean;
import test.bwie.com.bawaymail.model.bean.AddressBean;
import test.bwie.com.bawaymail.model.bean.AddressEditBean;
import test.bwie.com.bawaymail.model.bean.AreaBean;
import test.bwie.com.bawaymail.model.bean.CityBean;
import test.bwie.com.bawaymail.model.bean.ProvinceBean;
import test.bwie.com.bawaymail.model.utils.HttpUtils;
import test.bwie.com.bawaymail.view.iview.AddressView;



public class AddressPresenter extends BasePresenter<AddressView> {


    public  <T> void  getAddressData(String key){

        HttpUtils.getAddressData(key,new HttpUtils.CallBackDataF<AddressBean>() {
            @Override
            public void callBackF(AddressBean homeBean) {
                getIView().getAddressData(homeBean);
            }
        });
    }
    public  <T> void  getAddressCityData(String key,String area_id){

        HttpUtils.getAddressCityData(key,area_id,new HttpUtils.CallBackDataF<CityBean>() {
            @Override
            public void callBackF(CityBean homeBean) {
                getIView().getAddressCityData(homeBean);
            }
        });
    }

    public  <T> void  getAddressAreaData(String key,String area_id){

        HttpUtils.getAddressAreaData(key,area_id,new HttpUtils.CallBackDataF<AreaBean>() {
            @Override
            public void callBackF(AreaBean homeBean) {
                getIView().getAddressAreaData(homeBean);
            }
        });
    }

    public  <T> void  getAddressAddData(Map<String,String> map){

        HttpUtils.getAddressAddData(map,new HttpUtils.CallBackDataF<AddressAddBean>() {
            @Override
            public void callBackF(AddressAddBean homeBean) {
                getIView().getAddressAddData(homeBean);
            }
        });
    }
    public  <T> void  getAddressEditData(Map<String,String> map){

        HttpUtils.getAddressEditData(map,new HttpUtils.CallBackDataF<AddressEditBean>() {
            @Override
            public void callBackF(AddressEditBean homeBean) {
                getIView().getAddressEditData(homeBean);
            }
        });
    }
    public  <T> void  getAddressProvinceData(String key){

        HttpUtils.getAddressProvinceData(key,new HttpUtils.CallBackDataF<ProvinceBean>() {
            @Override
            public void callBackF(ProvinceBean homeBean) {
               getIView().getAddressProvinceData(homeBean);
            }
        });
    }
}
