package com.center.common;

public interface ConstantEnum {

    /**
     * 定义、格式化规则
     */
    enum Specification implements ConstantEnum {
        DATE_TIME(new String[]{
                "yyyy-MM-dd",
                "yyyy-MM-dd HH:mm:ss",
                "yyyy-MM-dd HH:mm",
                "yyyy-MM",
                "yyyy/MM/dd",
                "yyyy/MM/dd HH:mm:ss",
                "yyyy/MM/dd HH:mm",
                "yyyy/MM",
                "yyyy.MM.dd",
                "yyyy.MM.dd HH:mm:ss",
                "yyyy.MM.dd HH:mm",
                "yyyy.MM"
        });

        private final String[] formats;

        Specification(String[] formats) {
            this.formats = formats;
        }

        public String[] getFormats() {
            return formats;
        }
    }

    /**
     * 数据状态
     */
    enum Status implements ConstantEnum {

        FAILED(-1, "失败"),
        SUCCEEDED(0, "成功"),
        LOCKED(1, "锁定"),
        UNLOCKED(2, "解锁"),
        DISABLED(3, "禁用"),
        ENABLED(4, "启用"),
        UNPUBLISHED(5, "未发布"),
        PUBLISHED(6, "已发布");

        private final int code;

        private final String name;

        Status(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

    }

    /**
     * 用户操作
     */
    enum Login implements ConstantEnum {

        ADMIN("admin", "管理员用户登录账号"),
        SESSION_USER("SESSION_USER", "存取session当前用户键"),
        AUTHORIZATION("Authorization", "存取授权码键");

        private final String name;

        private final String des;

        Login(String name, String des) {
            this.name = name;
            this.des = des;
        }

        public String getName() {
            return name;
        }

        public String getDes() {
            return des;
        }
    }

}
