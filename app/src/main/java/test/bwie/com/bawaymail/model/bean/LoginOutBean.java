package test.bwie.com.bawaymail.model.bean;

/**
 * @类的用途：
 * @author: 贾秀坤
 * @date: 2017/6/16
 */

public class LoginOutBean {

    /**
     * code : 200
     * datas : 1
     */

    private int code;
    private String datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDatas() {
        return datas;
    }

    public void setDatas(String datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "LoginOutBean{" +
                "code=" + code +
                ", datas='" + datas + '\'' +
                '}';
    }
}
