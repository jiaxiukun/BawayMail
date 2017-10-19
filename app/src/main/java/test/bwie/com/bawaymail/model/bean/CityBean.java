package test.bwie.com.bawaymail.model.bean;

import java.util.List;

/**
 * @类的用途：
 * @author: 贾秀坤
 * @date: 2017/6/22
 */

public class CityBean {

    /**
     * code : 200
     * datas : {"area_list":[{"area_id":"73","area_name":"石家庄市"},{"area_id":"74","area_name":"唐山市"},{"area_id":"75",
     * "area_name":"秦皇岛市"},{"area_id":"76","area_name":"邯郸市"},{"area_id":"77","area_name":"邢台市"},{"area_id":"78",
     * "area_name":"保定市"},{"area_id":"79","area_name":"张家口市"},{"area_id":"80","area_name":"承德市"},{"area_id":"81",
     * "area_name":"衡水市"},{"area_id":"82","area_name":"廊坊市"},{"area_id":"83","area_name":"沧州市"}]}
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
             * area_id : 73
             * area_name : 石家庄市
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
