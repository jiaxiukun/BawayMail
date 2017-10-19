package test.bwie.com.bawaymail.view.iview;

/**
 * @ Description:
 * @ Date:2017/10/22
 * @ Author:贾秀坤
 */

public interface RegistView<T> extends IView {
    void getViewSuccess(T t);
    void getViewErr(String str,int code);
}
