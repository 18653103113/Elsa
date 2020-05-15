package com.cvicse.msa.druid;

public enum DataSourceKey {

    PRIMARY("mysql"),    //默认数据源
    SECONDARY("oracle"),
    THIRDLY("postgres");

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private DataSourceKey(String name) {
        this.name = name;
    }

}
