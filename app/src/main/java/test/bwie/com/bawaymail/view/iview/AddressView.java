package test.bwie.com.bawaymail.view.iview;

import test.bwie.com.bawaymail.model.bean.AddressAddBean;
import test.bwie.com.bawaymail.model.bean.AddressBean;
import test.bwie.com.bawaymail.model.bean.AddressEditBean;
import test.bwie.com.bawaymail.model.bean.AreaBean;
import test.bwie.com.bawaymail.model.bean.CityBean;
import test.bwie.com.bawaymail.model.bean.ProvinceBean;

/**
 * @ Description:
 * @ Date:2017/10/22
 * @ Author:贾秀坤
 */

public interface AddressView<T> extends IView {
    void getAddressData(AddressBean str);
    void getAddressProvinceData(ProvinceBean str);
    void getAddressCityData(CityBean str);
    void getAddressAreaData(AreaBean str);
    void getAddressAddData(AddressAddBean str);
    void getAddressEditData(AddressEditBean str);

}
