package test.bwie.com.bawaymail.model.bean;

/**
 * @类的用途：
 * @author: 贾秀坤
 * @date: 2017/6/22
 */

public class AddressAddBean {

    /**
     * code : 200
     * datas : {"address_id":2}
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
         * address_id : 2
         */

        private int address_id;

        public int getAddress_id() {
            return address_id;
        }

        public void setAddress_id(int address_id) {
            this.address_id = address_id;
        }
    }
}
