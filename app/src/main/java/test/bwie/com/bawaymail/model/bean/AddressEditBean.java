package test.bwie.com.bawaymail.model.bean;

/**
 * @ Description:
 * @ Date:2017/7/8
 * @ Author:贾秀坤
 */

public class AddressEditBean {
    @Override
    public String toString() {
        return "AddressEditBean{" +
                "code=" + code +
                ", datas=" + datas +
                '}';
    }

    /**
     * code : 200
     * datas : {"address_id":2}
     */

    private int code;
    private Object datas;
//    private AddressAddBean.DatasBean datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
//
//    public AddressAddBean.DatasBean getDatas() {
//        return datas;
//    }
//
//    public void setDatas(AddressAddBean.DatasBean datas) {
//        this.datas = datas;
//    }
//
//    public static class DatasBean {
//        @Override
//        public String toString() {
//            return "DatasBean{" +
//                    "address_id=" + address_id +
//                    '}';
//        }
//
//        /**
//         * address_id : 2
//         */
//
//        private int address_id;
//
//        public int getAddress_id() {
//            return address_id;
//        }
//
//        public void setAddress_id(int address_id) {
//            this.address_id = address_id;
//        }
//    }
}
