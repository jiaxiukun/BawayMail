package test.bwie.com.bawaymail.model.bean;

/**
 * @ Description:
 * @ Date:2017/6/11
 * @ Author:贾秀坤
 */

public class LoginBean {

    /**
     * code : 200
     * datas : {"username":"liugang0324","userid":"3","key":"2ff35fbe0060b0fb3498868d5c3e5bd3"}
     */

    private int code;
    private DatasBean datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DatasBean getDatas() {
        return datas;
    }

    public void setDatas(DatasBean datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        /**
         * username : liugang0324
         * userid : 3
         * key : 2ff35fbe0060b0fb3498868d5c3e5bd3
         */

        private String username;
        private String userid;
        private String key;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return "DatasBean{" +
                    "key='" + key + '\'' +
                    ", username='" + username + '\'' +
                    ", userid='" + userid + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "code=" + code +
                ", datas=" + datas +
                '}';
    }
}
