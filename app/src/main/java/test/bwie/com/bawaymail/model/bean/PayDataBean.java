package test.bwie.com.bawaymail.model.bean;

/**
 * @ Description:
 * @ Date:2017/10/18
 * @ Author:贾秀坤
 */

public class PayDataBean {

    /**
     * code : 200
     * datas : {"pay_sn":"520553016220656015","payment_code":"online"}
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
        @Override
        public String toString() {
            return "DatasBean{" +
                    "pay_sn='" + pay_sn + '\'' +
                    ", payment_code='" + payment_code + '\'' +
                    '}';
        }

        /**
         * pay_sn : 520553016220656015
         * payment_code : online
         */

        private String pay_sn;
        private String payment_code;

        public String getPay_sn() {
            return pay_sn;
        }

        public void setPay_sn(String pay_sn) {
            this.pay_sn = pay_sn;
        }

        public String getPayment_code() {
            return payment_code;
        }

        public void setPayment_code(String payment_code) {
            this.payment_code = payment_code;
        }
    }
}
