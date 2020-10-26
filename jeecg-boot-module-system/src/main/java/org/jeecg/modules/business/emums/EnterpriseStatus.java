package org.jeecg.modules.business.emums;


/**
 * 企业状态
 */
public enum EnterpriseStatus {

    wait_audit("10","未合作"),
    disable("30","合作过期"),
    normal("20","合作中"),
    delete("40","已删除");

    private String id;
    private String name;

    EnterpriseStatus(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
