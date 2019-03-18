package bw.com.weakmvpok.bean;

import java.util.List;

public class ShopListBean  {

    /**
     * result : [{"commodityId":110,"commodityName":"轻松小熊系列 苹果手机自拍杆 三级美颜补光灯 苹果华为便携自拍","masterPic":"http://172.17.8.100/images/small/commodity/sjsm/sjpj/4/1.jpg","price":98,"saleNum":0},{"commodityId":105,"commodityName":"小米8 256GB 全面屏 双频GPS智能拍照游戏手机","masterPic":"http://172.17.8.100/images/small/commodity/sjsm/sj/6/1.jpg","price":3099,"saleNum":0},{"commodityId":120,"commodityName":"德米克 高端正品3d眼镜虚拟现实VR BOX眼镜二代定制LOGO手机家庭影院","masterPic":"http://172.17.8.100/images/small/commodity/sjsm/yyyl/7/1.jpg","price":189,"saleNum":0},{"commodityId":101,"commodityName":"vivo X23幻彩版 多套餐 全面屏拍照美颜超大广角摄影水滴屏智能4G 正品vivox23手机","masterPic":"http://172.17.8.100/images/small/commodity/sjsm/sj/2/1.jpg","price":2798,"saleNum":0},{"commodityId":112,"commodityName":"黑色重力支架 车载手机架汽车用导航支架车上支撑出风口汽车内多功能通用型金属车载支架","masterPic":"http://172.17.8.100/images/small/commodity/sjsm/sjpj/6/1.jpg","price":35,"saleNum":0},{"commodityId":109,"commodityName":"新款奢华镶钻镜面iphone xs max手机壳苹果7plusl软边时尚保护套","masterPic":"http://172.17.8.100/images/small/commodity/sjsm/sjpj/3/1.jpg","price":89,"saleNum":0},{"commodityId":104,"commodityName":"OPPO R17 全网通 8G+128G 美拍补光灯+美容补水仪套餐 全面屏AI智慧美颜双摄拍照手机","masterPic":"http://172.17.8.100/images/small/commodity/sjsm/sj/5/1.jpg","price":3799,"saleNum":0},{"commodityId":119,"commodityName":"斯泰克 吃鸡神器手游键盘 快捷射击辅助按键四指手机游戏 绝地求生刺激战场游戏手柄合金款 苹果安卓通用 扳机射击按键（2件装）","masterPic":"http://172.17.8.100/images/small/commodity/sjsm/yyyl/6/1.jpg","price":39,"saleNum":0},{"commodityId":100,"commodityName":"【壳膜线套餐】 苹果 iPhone XS 256G 全网通手机","masterPic":"http://172.17.8.100/images/small/commodity/sjsm/sj/1/1.jpg","price":10069,"saleNum":0},{"commodityId":111,"commodityName":"三合一充电器数据线苹果二合一拖安卓手机多用功能多头车载苹果安卓一拖三数据线Type-C铝合金编织线 土豪金","masterPic":"http://172.17.8.100/images/small/commodity/sjsm/sjpj/5/1.jpg","price":39,"saleNum":0}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBeans> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBeans> getResult() {
        return result;
    }

    public void setResult(List<ResultBeans> result) {
        this.result = result;
    }

    public static class ResultBeans {
        /**
         * commodityId : 110
         * commodityName : 轻松小熊系列 苹果手机自拍杆 三级美颜补光灯 苹果华为便携自拍
         * masterPic : http://172.17.8.100/images/small/commodity/sjsm/sjpj/4/1.jpg
         * price : 98
         * saleNum : 0
         */

        private String commodityId;
        private String commodityName;
        private String masterPic;
        private String price;
        private String saleNum;

        public String getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(String commodityId) {
            this.commodityId = commodityId;
        }

        public String getCommodityName() {
            return commodityName;
        }

        public void setCommodityName(String commodityName) {
            this.commodityName = commodityName;
        }

        public String getMasterPic() {
            return masterPic;
        }

        public void setMasterPic(String masterPic) {
            this.masterPic = masterPic;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getSaleNum() {
            return saleNum;
        }

        public void setSaleNum(String saleNum) {
            this.saleNum = saleNum;
        }
    }
}
