package test.bwie.com.bawaymail.view.iview;

/**
 * @ Description:
 * @ Date:2017/10/22
 * @ Author:贾秀坤
 */

public interface IHomeView<T> extends IView {
    void callbackStr(T t);


    void showOrHideLoading(boolean flag);

    void callbackErr(String err, int code);


}
