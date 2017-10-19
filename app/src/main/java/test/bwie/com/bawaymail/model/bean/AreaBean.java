package test.bwie.com.bawaymail.model.bean;

import java.util.List;

/**
 * @类的用途：
 * @author: 贾秀坤
 * @date: 2017/6/22
 */

public class AreaBean {

    /**
     * code : 200
     * datas : {"area_list":[{"area_id":"1126","area_name":"井陉县"},{"area_id":"1127","area_name":"井陉矿区"},
     * {"area_id":"1128","area_name":"元氏县"},{"area_id":"1129","area_name":"平山县"},{"area_id":"1130",
     * "area_name":"新乐市"},{"area_id":"1131","area_name":"新华区"},{"area_id":"1132","area_name":"无极县"},
     * {"area_id":"1133","area_name":"晋州市"},{"area_id":"1134","area_name":"栾城县"},{"area_id":"1135",
     * "area_name":"桥东区"},{"area_id":"1136","area_name":"桥西区"},{"area_id":"1137","area_name":"正定县"},
     * {"area_id":"1138","area_name":"深泽县"},{"area_id":"1139","area_name":"灵寿县"},{"area_id":"1140",
     * "area_name":"藁城市"},{"area_id":"1141","area_name":"行唐县"},{"area_id":"1142","area_name":"裕华区"},
     * {"area_id":"1143","area_name":"赞皇县"},{"area_id":"1144","area_name":"赵县"},{"area_id":"1145","area_name":"辛集市"},
     * {"area_id":"1146","area_name":"长安区"},{"area_id":"1147","area_name":"高邑县"},{"area_id":"1148","area_name":"鹿泉市"}]}
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
        private List<AreaListBean> area_list;

        public List<AreaListBean> getArea_list() {
            return area_list;
        }

        public void setArea_list(List<AreaListBean> area_list) {
            this.area_list = area_list;
        }

        public static class AreaListBean {
            /**
             * area_id : 1126
             * area_name : 井陉县
             */

            private String area_id;
            private String area_name;

            public String getArea_id() {
                return area_id;
            }

            public void setArea_id(String area_id) {
                this.area_id = area_id;
            }

            public String getArea_name() {
                return area_name;
            }

            public void setArea_name(String area_name) {
                this.area_name = area_name;
            }
        }
    }
}
