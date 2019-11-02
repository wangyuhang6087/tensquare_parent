package com.zhiyou100.qa.model;

/**
 * @author:Rain
 * @date 2019/11/1 21:22
 * @desc
 */
public class Pl {
    private String problemid;
    private String labelid;

    public Pl(String problemid, String labelid) {
        this.problemid = problemid;
        this.labelid = labelid;
    }

    public String getProblemid() {
        return problemid;
    }

    public void setProblemid(String problemid) {
        this.problemid = problemid;
    }

    public String getLabelid() {
        return labelid;
    }

    public void setLabelid(String labelid) {
        this.labelid = labelid;
    }
}
