package test.bwie.com.bawaymail.view.iview;

/**
 * @ Description:
 * @ Date:2017/10/22
 * @ Author:贾秀坤
 */

public interface LoginOutView<T> extends IView{
    void getDataSuccess(T t);
    void getDataError(String strMsg, int errCode);
}
