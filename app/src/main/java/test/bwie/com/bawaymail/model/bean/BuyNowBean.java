package test.bwie.com.bawaymail.model.bean;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @类的用途：
 * @author: 王成哲
 * @date: 2017/6/18
 */

public class BuyNowBean {

    /**
     * code : 200
     * datas : {"store_cart_list":{"1":{"goods_list":[{"goods_num":1,"goods_id":100007,"goods_commonid":"100007",
     * "gc_id":"587","store_id":"1","goods_name":"劳力士Rolex 蚝式恒动系列自动机械钢带男表正品116523-8DI-78593",
     * "goods_price":"146300.00","store_name":"好商城V5","goods_image":"1_04752627900055146.png","transport_id":"0",
     * "goods_freight":"0.00","goods_vat":"0","goods_storage":"100","goods_storage_alarm":"0","is_fcode":"0",
     * "have_gift":"0","state":true,"storage_state":true,"groupbuy_info":null,"xianshi_info":null,"is_chain":"0",
     * "is_book":"0","book_down_payment":"0.00","book_final_payment":"0.00","book_down_time":"0","cart_id":100007,
     * "bl_id":0,"sole_info":[],"contractlist":[],"goods_total":"146300.00",
     * "goods_image_url":"http://192.168.56.1/data/upload/shop/store/goods/1/1_04752627900055146_240.png"}],
     * "store_goods_total":"146300.00","store_mansong_rule_list":null,"store_voucher_info":[],
     * "store_voucher_list":[],"freight":"1","store_name":"好商城V5"}},
     * "freight_hash":"FP5kPUA01UUq4_pHUOC5n-v1dJl
     * -mkOAqPUAjQZGvxSIwZv8SCbNgO0YPNI4yemZzMIWNv3aPJafk3WTfHCXSelPPyxd2gv-ntDGh9WMyly4fQbF0aJSwSrNijt7vVUA-SKHR
     * -qVBKDcvMsH0mfaBPwS-8wew6XeDfSO_i2","address_info":{"address_id":"6","member_id":"7","true_name":"qqq",
     * "area_id":"1298","city_id":"84","area_info":"山西 太原市 万柏林区","address":"qqq","tel_phone":null,"mob_phone":"7777",
     * "is_default":"1","dlyp_id":"0"},"ifshow_offpay":null,"vat_hash":"51lkjv41aegl9H1qft3a9LrA-qN2GHu7nGp",
     * "inv_info":{"content":"不需要发票"},"available_predeposit":null,"available_rc_balance":null,"rpt_list":[],
     * "zk_list":[],"order_amount":"146300.00","rpt_info":[],"address_api":{"state":"success","content":{"1":"0.00"},
     * "no_send_tpl_ids":[],"allow_offpay":"0","allow_offpay_batch":[],"offpay_hash":"gnWOmbeQhY1nIfMC
     * .ts9hHhps_y9xtHv8isuZzC","offpay_hash_batch":"K1PGQl1NCvILAsEs1BC_w2vP01q636-"},
     * "store_final_total_list":{"1":"146300.00"}}
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
         * store_cart_list : {"1":{"goods_list":[{"goods_num":1,"goods_id":100007,"goods_commonid":"100007",
         * "gc_id":"587","store_id":"1","goods_name":"劳力士Rolex 蚝式恒动系列自动机械钢带男表正品116523-8DI-78593",
         * "goods_price":"146300.00","store_name":"好商城V5","goods_image":"1_04752627900055146.png","transport_id":"0",
         * "goods_freight":"0.00","goods_vat":"0","goods_storage":"100","goods_storage_alarm":"0","is_fcode":"0",
         * "have_gift":"0","state":true,"storage_state":true,"groupbuy_info":null,"xianshi_info":null,"is_chain":"0",
         * "is_book":"0","book_down_payment":"0.00","book_final_payment":"0.00","book_down_time":"0",
         * "cart_id":100007,"bl_id":0,"sole_info":[],"contractlist":[],"goods_total":"146300.00",
         * "goods_image_url":"http://192.168.56.1/data/upload/shop/store/goods/1/1_04752627900055146_240.png"}],
         * "store_goods_total":"146300.00","store_mansong_rule_list":null,"store_voucher_info":[],
         * "store_voucher_list":[],"freight":"1","store_name":"好商城V5"}}
         * freight_hash :
         * FP5kPUA01UUq4_pHUOC5n-v1dJl-mkOAqPUAjQZGvxSIwZv8SCbNgO0YPNI4yemZzMIWNv3aPJafk3WTfHCXSelPPyxd2gv
         * -ntDGh9WMyly4fQbF0aJSwSrNijt7vVUA-SKHR-qVBKDcvMsH0mfaBPwS-8wew6XeDfSO_i2
         * address_info : {"address_id":"6","member_id":"7","true_name":"qqq","area_id":"1298","city_id":"84",
         * "area_info":"山西 太原市 万柏林区","address":"qqq","tel_phone":null,"mob_phone":"7777","is_default":"1","dlyp_id":"0"}
         * ifshow_offpay : null
         * vat_hash : 51lkjv41aegl9H1qft3a9LrA-qN2GHu7nGp
         * inv_info : {"content":"不需要发票"}
         * available_predeposit : null
         * available_rc_balance : null
         * rpt_list : []
         * zk_list : []
         * order_amount : 146300.00
         * rpt_info : []
         * address_api : {"state":"success","content":{"1":"0.00"},"no_send_tpl_ids":[],"allow_offpay":"0",
         * "allow_offpay_batch":[],"offpay_hash":"gnWOmbeQhY1nIfMC.ts9hHhps_y9xtHv8isuZzC",
         * "offpay_hash_batch":"K1PGQl1NCvILAsEs1BC_w2vP01q636-"}
         * store_final_total_list : {"1":"146300.00"}
         */

        private StoreCartListBean store_cart_list;
        private String freight_hash;
        private AddressInfoBean address_info;
       // private Object[] address_info;
        private Object ifshow_offpay;
        private String vat_hash;
        private InvInfoBean inv_info;
        private Object available_predeposit;
        private Object available_rc_balance;
        private String order_amount;
        private AddressApiBean address_api;
        //private String address_api;

        private StoreFinalTotalListBean store_final_total_list;
        private List<?> rpt_list;
        private List<?> zk_list;
        private List<?> rpt_info;

        public AddressApiBean getAddress_api() {
            return address_api;
        }

        public void setAddress_api(AddressApiBean address_api) {
            this.address_api = address_api;
        }

        public StoreCartListBean getStore_cart_list() {
            return store_cart_list;
        }

        public void setStore_cart_list(StoreCartListBean store_cart_list) {
            this.store_cart_list = store_cart_list;
        }

        public String getFreight_hash() {
            return freight_hash;
        }

        public void setFreight_hash(String freight_hash) {
            this.freight_hash = freight_hash;
        }

        public AddressInfoBean getAddress_info() {
            return address_info;
        }

        public void setAddress_info(AddressInfoBean address_info) {
            this.address_info = address_info;
        }

//        public Object[] getAddress_info() {
//            return address_info;
//        }
//
//        public void setAddress_info(Object[] address_info) {
//            this.address_info = address_info;
//        }

        public Object getIfshow_offpay() {
            return ifshow_offpay;
        }

        public void setIfshow_offpay(Object ifshow_offpay) {
            this.ifshow_offpay = ifshow_offpay;
        }

        public String getVat_hash() {
            return vat_hash;
        }

        public void setVat_hash(String vat_hash) {
            this.vat_hash = vat_hash;
        }

        public InvInfoBean getInv_info() {
            return inv_info;
        }

        public void setInv_info(InvInfoBean inv_info) {
            this.inv_info = inv_info;
        }

        public Object getAvailable_predeposit() {
            return available_predeposit;
        }

        public void setAvailable_predeposit(Object available_predeposit) {
            this.available_predeposit = available_predeposit;
        }

        public Object getAvailable_rc_balance() {
            return available_rc_balance;
        }

        public void setAvailable_rc_balance(Object available_rc_balance) {
            this.available_rc_balance = available_rc_balance;
        }

        public String getOrder_amount() {
            return order_amount;
        }

        public void setOrder_amount(String order_amount) {
            this.order_amount = order_amount;
        }

//        public String  getAddress_api() {
//            return address_api;
//        }
//
//        public void setAddress_api(String address_api) {
//            this.address_api = address_api;
//        }

        public StoreFinalTotalListBean getStore_final_total_list() {
            return store_final_total_list;
        }

        public void setStore_final_total_list(StoreFinalTotalListBean store_final_total_list) {
            this.store_final_total_list = store_final_total_list;
        }

        public List<?> getRpt_list() {
            return rpt_list;
        }

        public void setRpt_list(List<?> rpt_list) {
            this.rpt_list = rpt_list;
        }

        public List<?> getZk_list() {
            return zk_list;
        }

        public void setZk_list(List<?> zk_list) {
            this.zk_list = zk_list;
        }

        public List<?> getRpt_info() {
            return rpt_info;
        }

        public void setRpt_info(List<?> rpt_info) {
            this.rpt_info = rpt_info;
        }

        public static class StoreCartListBean {
            /**
             * 1 : {"goods_list":[{"goods_num":1,"goods_id":100007,"goods_commonid":"100007","gc_id":"587",
             * "store_id":"1","goods_name":"劳力士Rolex 蚝式恒动系列自动机械钢带男表正品116523-8DI-78593","goods_price":"146300.00",
             * "store_name":"好商城V5","goods_image":"1_04752627900055146.png","transport_id":"0",
             * "goods_freight":"0.00","goods_vat":"0","goods_storage":"100","goods_storage_alarm":"0","is_fcode":"0",
             * "have_gift":"0","state":true,"storage_state":true,"groupbuy_info":null,"xianshi_info":null,
             * "is_chain":"0","is_book":"0","book_down_payment":"0.00","book_final_payment":"0.00",
             * "book_down_time":"0","cart_id":100007,"bl_id":0,"sole_info":[],"contractlist":[],
             * "goods_total":"146300.00","goods_image_url":"http://192.168.56.1/data/upload/shop/store/goods/1
             * /1_04752627900055146_240.png"}],"store_goods_total":"146300.00","store_mansong_rule_list":null,
             * "store_voucher_info":[],"store_voucher_list":[],"freight":"1","store_name":"好商城V5"}
             */

            @SerializedName("1")
            private _$1Bean _$1;

            public _$1Bean get_$1() {
                return _$1;
            }

            public void set_$1(_$1Bean _$1) {
                this._$1 = _$1;
            }

            public static class _$1Bean {
                /**
                 * goods_list : [{"goods_num":1,"goods_id":100007,"goods_commonid":"100007","gc_id":"587",
                 * "store_id":"1","goods_name":"劳力士Rolex 蚝式恒动系列自动机械钢带男表正品116523-8DI-78593","goods_price":"146300.00",
                 * "store_name":"好商城V5","goods_image":"1_04752627900055146.png","transport_id":"0",
                 * "goods_freight":"0.00","goods_vat":"0","goods_storage":"100","goods_storage_alarm":"0",
                 * "is_fcode":"0","have_gift":"0","state":true,"storage_state":true,"groupbuy_info":null,
                 * "xianshi_info":null,"is_chain":"0","is_book":"0","book_down_payment":"0.00",
                 * "book_final_payment":"0.00","book_down_time":"0","cart_id":100007,"bl_id":0,"sole_info":[],
                 * "contractlist":[],"goods_total":"146300.00",
                 * "goods_image_url":"http://192.168.56.1/data/upload/shop/store/goods/1/1_04752627900055146_240.png"}]
                 * store_goods_total : 146300.00
                 * store_mansong_rule_list : null
                 * store_voucher_info : []
                 * store_voucher_list : []
                 * freight : 1
                 * store_name : 好商城V5
                 */

                private String store_goods_total;
                private Object store_mansong_rule_list;
                private String freight;
                private String store_name;
                private List<GoodsListBean> goods_list;
                private List<?> store_voucher_info;
                private List<?> store_voucher_list;

                public String getStore_goods_total() {
                    return store_goods_total;
                }

                public void setStore_goods_total(String store_goods_total) {
                    this.store_goods_total = store_goods_total;
                }

                public Object getStore_mansong_rule_list() {
                    return store_mansong_rule_list;
                }

                public void setStore_mansong_rule_list(Object store_mansong_rule_list) {
                    this.store_mansong_rule_list = store_mansong_rule_list;
                }

                public String getFreight() {
                    return freight;
                }

                public void setFreight(String freight) {
                    this.freight = freight;
                }

                public String getStore_name() {
                    return store_name;
                }

                public void setStore_name(String store_name) {
                    this.store_name = store_name;
                }

                public List<GoodsListBean> getGoods_list() {
                    return goods_list;
                }

                public void setGoods_list(List<GoodsListBean> goods_list) {
                    this.goods_list = goods_list;
                }

                public List<?> getStore_voucher_info() {
                    return store_voucher_info;
                }

                public void setStore_voucher_info(List<?> store_voucher_info) {
                    this.store_voucher_info = store_voucher_info;
                }

                public List<?> getStore_voucher_list() {
                    return store_voucher_list;
                }

                public void setStore_voucher_list(List<?> store_voucher_list) {
                    this.store_voucher_list = store_voucher_list;
                }

                public static class GoodsListBean {
                    /**
                     * goods_num : 1
                     * goods_id : 100007
                     * goods_commonid : 100007
                     * gc_id : 587
                     * store_id : 1
                     * goods_name : 劳力士Rolex 蚝式恒动系列自动机械钢带男表正品116523-8DI-78593
                     * goods_price : 146300.00
                     * store_name : 好商城V5
                     * goods_image : 1_04752627900055146.png
                     * transport_id : 0
                     * goods_freight : 0.00
                     * goods_vat : 0
                     * goods_storage : 100
                     * goods_storage_alarm : 0
                     * is_fcode : 0
                     * have_gift : 0
                     * state : true
                     * storage_state : true
                     * groupbuy_info : null
                     * xianshi_info : null
                     * is_chain : 0
                     * is_book : 0
                     * book_down_payment : 0.00
                     * book_final_payment : 0.00
                     * book_down_time : 0
                     * cart_id : 100007
                     * bl_id : 0
                     * sole_info : []
                     * contractlist : []
                     * goods_total : 146300.00
                     * goods_image_url : http://192.168.56.1/data/upload/shop/store/goods/1/1_04752627900055146_240.png
                     */

                    private int goods_num;
                    private int goods_id;
                    private String goods_commonid;
                    private String gc_id;
                    private String store_id;
                    private String goods_name;
                    private String goods_price;
                    private String store_name;
                    private String goods_image;
                    private String transport_id;
                    private String goods_freight;
                    private String goods_vat;
                    private String goods_storage;
                    private String goods_storage_alarm;
                    private String is_fcode;
                    private String have_gift;
                    private boolean state;
                    private boolean storage_state;
                    private Object groupbuy_info;
                    private Object xianshi_info;
                    private String is_chain;
                    private String is_book;
                    private String book_down_payment;
                    private String book_final_payment;
                    private String book_down_time;
                    private int cart_id;
                    private int bl_id;
                    private String goods_total;
                    private String goods_image_url;
                    private List<?> sole_info;
                    private List<?> contractlist;

                    public int getGoods_num() {
                        return goods_num;
                    }

                    public void setGoods_num(int goods_num) {
                        this.goods_num = goods_num;
                    }

                    public int getGoods_id() {
                        return goods_id;
                    }

                    public void setGoods_id(int goods_id) {
                        this.goods_id = goods_id;
                    }

                    public String getGoods_commonid() {
                        return goods_commonid;
                    }

                    public void setGoods_commonid(String goods_commonid) {
                        this.goods_commonid = goods_commonid;
                    }

                    public String getGc_id() {
                        return gc_id;
                    }

                    public void setGc_id(String gc_id) {
                        this.gc_id = gc_id;
                    }

                    public String getStore_id() {
                        return store_id;
                    }

                    public void setStore_id(String store_id) {
                        this.store_id = store_id;
                    }

                    public String getGoods_name() {
                        return goods_name;
                    }

                    public void setGoods_name(String goods_name) {
                        this.goods_name = goods_name;
                    }

                    public String getGoods_price() {
                        return goods_price;
                    }

                    public void setGoods_price(String goods_price) {
                        this.goods_price = goods_price;
                    }

                    public String getStore_name() {
                        return store_name;
                    }

                    public void setStore_name(String store_name) {
                        this.store_name = store_name;
                    }

                    public String getGoods_image() {
                        return goods_image;
                    }

                    public void setGoods_image(String goods_image) {
                        this.goods_image = goods_image;
                    }

                    public String getTransport_id() {
                        return transport_id;
                    }

                    public void setTransport_id(String transport_id) {
                        this.transport_id = transport_id;
                    }

                    public String getGoods_freight() {
                        return goods_freight;
                    }

                    public void setGoods_freight(String goods_freight) {
                        this.goods_freight = goods_freight;
                    }

                    public String getGoods_vat() {
                        return goods_vat;
                    }

                    public void setGoods_vat(String goods_vat) {
                        this.goods_vat = goods_vat;
                    }

                    public String getGoods_storage() {
                        return goods_storage;
                    }

                    public void setGoods_storage(String goods_storage) {
                        this.goods_storage = goods_storage;
                    }

                    public String getGoods_storage_alarm() {
                        return goods_storage_alarm;
                    }

                    public void setGoods_storage_alarm(String goods_storage_alarm) {
                        this.goods_storage_alarm = goods_storage_alarm;
                    }

                    public String getIs_fcode() {
                        return is_fcode;
                    }

                    public void setIs_fcode(String is_fcode) {
                        this.is_fcode = is_fcode;
                    }

                    public String getHave_gift() {
                        return have_gift;
                    }

                    public void setHave_gift(String have_gift) {
                        this.have_gift = have_gift;
                    }

                    public boolean isState() {
                        return state;
                    }

                    public void setState(boolean state) {
                        this.state = state;
                    }

                    public boolean isStorage_state() {
                        return storage_state;
                    }

                    public void setStorage_state(boolean storage_state) {
                        this.storage_state = storage_state;
                    }

                    public Object getGroupbuy_info() {
                        return groupbuy_info;
                    }

                    public void setGroupbuy_info(Object groupbuy_info) {
                        this.groupbuy_info = groupbuy_info;
                    }

                    public Object getXianshi_info() {
                        return xianshi_info;
                    }

                    public void setXianshi_info(Object xianshi_info) {
                        this.xianshi_info = xianshi_info;
                    }

                    public String getIs_chain() {
                        return is_chain;
                    }

                    public void setIs_chain(String is_chain) {
                        this.is_chain = is_chain;
                    }

                    public String getIs_book() {
                        return is_book;
                    }

                    public void setIs_book(String is_book) {
                        this.is_book = is_book;
                    }

                    public String getBook_down_payment() {
                        return book_down_payment;
                    }

                    public void setBook_down_payment(String book_down_payment) {
                        this.book_down_payment = book_down_payment;
                    }

                    public String getBook_final_payment() {
                        return book_final_payment;
                    }

                    public void setBook_final_payment(String book_final_payment) {
                        this.book_final_payment = book_final_payment;
                    }

                    public String getBook_down_time() {
                        return book_down_time;
                    }

                    public void setBook_down_time(String book_down_time) {
                        this.book_down_time = book_down_time;
                    }

                    public int getCart_id() {
                        return cart_id;
                    }

                    public void setCart_id(int cart_id) {
                        this.cart_id = cart_id;
                    }

                    public int getBl_id() {
                        return bl_id;
                    }

                    public void setBl_id(int bl_id) {
                        this.bl_id = bl_id;
                    }

                    public String getGoods_total() {
                        return goods_total;
                    }

                    public void setGoods_total(String goods_total) {
                        this.goods_total = goods_total;
                    }

                    public String getGoods_image_url() {
                        return goods_image_url;
                    }

                    public void setGoods_image_url(String goods_image_url) {
                        this.goods_image_url = goods_image_url;
                    }

                    public List<?> getSole_info() {
                        return sole_info;
                    }

                    public void setSole_info(List<?> sole_info) {
                        this.sole_info = sole_info;
                    }

                    public List<?> getContractlist() {
                        return contractlist;
                    }

                    public void setContractlist(List<?> contractlist) {
                        this.contractlist = contractlist;
                    }
                }
            }
        }

        public static class AddressInfoBean {
            /**
             * address_id : 6
             * member_id : 7
             * true_name : qqq
             * area_id : 1298
             * city_id : 84
             * area_info : 山西 太原市 万柏林区
             * address : qqq
             * tel_phone : null
             * mob_phone : 7777
             * is_default : 1
             * dlyp_id : 0
             */

            private String address_id;
            private String member_id;
            private String true_name;
            private String area_id;
            private String city_id;
            private String area_info;
            private String address;
            private Object tel_phone;
            private String mob_phone;
            private String is_default;
            private String dlyp_id;

            public String getAddress_id() {
                return address_id;
            }

            public void setAddress_id(String address_id) {
                this.address_id = address_id;
            }

            public String getMember_id() {
                return member_id;
            }

            public void setMember_id(String member_id) {
                this.member_id = member_id;
            }

            public String getTrue_name() {
                return true_name;
            }

            public void setTrue_name(String true_name) {
                this.true_name = true_name;
            }

            public String getArea_id() {
                return area_id;
            }

            public void setArea_id(String area_id) {
                this.area_id = area_id;
            }

            public String getCity_id() {
                return city_id;
            }

            public void setCity_id(String city_id) {
                this.city_id = city_id;
            }

            public String getArea_info() {
                return area_info;
            }

            public void setArea_info(String area_info) {
                this.area_info = area_info;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public Object getTel_phone() {
                return tel_phone;
            }

            public void setTel_phone(Object tel_phone) {
                this.tel_phone = tel_phone;
            }

            public String getMob_phone() {
                return mob_phone;
            }

            public void setMob_phone(String mob_phone) {
                this.mob_phone = mob_phone;
            }

            public String getIs_default() {
                return is_default;
            }

            public void setIs_default(String is_default) {
                this.is_default = is_default;
            }

            public String getDlyp_id() {
                return dlyp_id;
            }

            public void setDlyp_id(String dlyp_id) {
                this.dlyp_id = dlyp_id;
            }
        }

        public static class InvInfoBean {
            /**
             * content : 不需要发票
             */

            private String content;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }

        public static class AddressApiBean {
            /**
             * state : success
             * content : {"1":"0.00"}
             * no_send_tpl_ids : []
             * allow_offpay : 0
             * allow_offpay_batch : []
             * offpay_hash : gnWOmbeQhY1nIfMC.ts9hHhps_y9xtHv8isuZzC
             * offpay_hash_batch : K1PGQl1NCvILAsEs1BC_w2vP01q636-
             */

            private String state;
            private ContentBean content;
            private String allow_offpay;
            private String offpay_hash;
            private String offpay_hash_batch;
            private List<?> no_send_tpl_ids;
            private List<?> allow_offpay_batch;

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public ContentBean getContent() {
                return content;
            }

            public void setContent(ContentBean content) {
                this.content = content;
            }

            public String getAllow_offpay() {
                return allow_offpay;
            }

            public void setAllow_offpay(String allow_offpay) {
                this.allow_offpay = allow_offpay;
            }

            public String getOffpay_hash() {
                return offpay_hash;
            }

            public void setOffpay_hash(String offpay_hash) {
                this.offpay_hash = offpay_hash;
            }

            public String getOffpay_hash_batch() {
                return offpay_hash_batch;
            }

            public void setOffpay_hash_batch(String offpay_hash_batch) {
                this.offpay_hash_batch = offpay_hash_batch;
            }

            public List<?> getNo_send_tpl_ids() {
                return no_send_tpl_ids;
            }

            public void setNo_send_tpl_ids(List<?> no_send_tpl_ids) {
                this.no_send_tpl_ids = no_send_tpl_ids;
            }

            public List<?> getAllow_offpay_batch() {
                return allow_offpay_batch;
            }

            public void setAllow_offpay_batch(List<?> allow_offpay_batch) {
                this.allow_offpay_batch = allow_offpay_batch;
            }

            public static class ContentBean {
                /**
                 * 1 : 0.00
                 */

                @SerializedName("1")
                private String _$1;

                public String get_$1() {
                    return _$1;
                }

                public void set_$1(String _$1) {
                    this._$1 = _$1;
                }
            }
        }

        public static class StoreFinalTotalListBean {
            /**
             * 1 : 146300.00
             */

            @SerializedName("1")
            private String _$1;

            public String get_$1() {
                return _$1;
            }

            public void set_$1(String _$1) {
                this._$1 = _$1;
            }
        }
    }
}
