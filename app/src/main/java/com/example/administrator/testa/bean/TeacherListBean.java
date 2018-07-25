package com.example.administrator.testa.bean;

import java.util.List;

/**
 * Author: Administrator
 * Date: 2018/7/25
 * Dscription:This is com.example.administrator.testa.bean
 */

public class TeacherListBean {
    /**
     * error_code : 0
     * error :
     * data : {"list":[{"id":1,"name":"王老师","honorary":"最佳优秀奖","phone":15852369855,"desc":"优秀歌唱教师。国家级教师，在北京和各地赛事上多次获奖。多年拉丁舞教育教学经验，主攻少儿拉丁舞教学，教学科学严谨，广受家长和学员的喜爱。","img":"http://api.kuailaiyingka.com/upload/2018/07/04/c01d38ea-c.png","status":1},{"id":2,"name":"罗老师","honorary":"世界舞蹈大赛一等奖","phone":15852369855,"desc":"北京大学，优秀拉丁舞教师。国家级教师，在北京和各地赛事上多次获奖。多年拉丁舞教育教学经验，主攻少儿拉丁舞教学，教学科学严谨，广受家长和学员的喜爱。多年拉丁舞教育教学经验。","img":"http://api.kuailaiyingka.com/upload/2018/07/04/22d3d8bd-f.jpg","status":1},{"id":3,"name":"林老师","honorary":"国家级大奖","phone":15852369855,"desc":"北京大学，优秀体育教师。国家级教师，在北京和各地赛事上多次获奖。多年拉丁舞教育教学经验，主攻少儿拉丁舞教学，教学科学严谨，广受家长和学员的喜爱。","img":"http://api.kuailaiyingka.com/upload/2018/07/04/9d925ba1-8.png","status":1}]}
     */

    private int error_code;
    private String error;
    private DataBean data;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 1
             * name : 王老师
             * honorary : 最佳优秀奖
             * phone : 15852369855
             * desc : 优秀歌唱教师。国家级教师，在北京和各地赛事上多次获奖。多年拉丁舞教育教学经验，主攻少儿拉丁舞教学，教学科学严谨，广受家长和学员的喜爱。
             * img : http://api.kuailaiyingka.com/upload/2018/07/04/c01d38ea-c.png
             * status : 1
             */

            private int id;
            private String name;
            private String honorary;
            private long phone;
            private String desc;
            private String img;
            private int status;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getHonorary() {
                return honorary;
            }

            public void setHonorary(String honorary) {
                this.honorary = honorary;
            }

            public long getPhone() {
                return phone;
            }

            public void setPhone(long phone) {
                this.phone = phone;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }
    }
}
