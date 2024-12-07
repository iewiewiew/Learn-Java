package basedemo;

public enum MessageEnum {
    SYSTEM("1","系统消息"),
    ORDER_STATE("2","运单状态消息");

    private String type;    //类型
    private String desc;    //描述

    MessageEnum(String type, String desc){
        this.type=type;
        this.desc=desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
