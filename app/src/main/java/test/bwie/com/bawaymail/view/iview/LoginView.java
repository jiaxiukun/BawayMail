package test.bwie.com.bawaymail.view.iview;

/**
 * @ Description:
 * @ Date:2017/10/22
 * @ Author:贾秀坤
 */

public interface LoginView<T> extends IView {
    void getLoginViewSuc(T t);
    void  getLoginErr(String str,int code);
}
