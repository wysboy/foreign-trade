package org.jeecg.modules.business.emums;

public enum EnterpriseContractType {

    b_p_contract("1","企业与平台合同"),
    b_c_contract("2","企业与C端业务合同");

    private String id;
    private String name;

    EnterpriseContractType(String id, String name) {
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
