package test.bwie.com.bawaymail.view.iview;


import test.bwie.com.bawaymail.model.bean.CartDataBean;
import test.bwie.com.bawaymail.model.bean.DelCartBean;

/**
 * @ Description:
 * @ Date:2017/10/22
 * @ Author:贾秀坤
 */

public interface CartView<T> extends IView{

    void getCartListData(CartDataBean str);

    void getCartDelData(DelCartBean str);



}
