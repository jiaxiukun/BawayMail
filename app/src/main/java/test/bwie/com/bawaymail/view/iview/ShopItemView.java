package test.bwie.com.bawaymail.view.iview;

/**
 * @ Description:
 * @ Date:2017/10/22
 * @ Author:贾秀坤
 */

public interface ShopItemView<T> extends IView {
    void  getShopItemView(T t);
    void  getShopItemViewErr(String str,int code);
}
