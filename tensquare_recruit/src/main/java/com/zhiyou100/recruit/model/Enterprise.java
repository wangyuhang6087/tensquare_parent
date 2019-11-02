package com.zhiyou100.recruit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author:Rain
 * @date 2019/10/31 18:42
 * @desc
 */
@Entity
@Table(name = "tb_enterprise")
public class Enterprise {
    @Id
    private String id;  // id
    private String name; // 公司名
    private String summary;  // 公司简介
    private String address;  // 公司地址
    private String labels;   // 公司所有标签
    private String coordinate; // 坐标
    private String ishot;    // 是否热门
    private String logo;     // logo
    private String jobcount;  // 职位数
    private String url;

    public Enterprise() {
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getIshot() {
        return ishot;
    }

    public void setIshot(String ishot) {
        this.ishot = ishot;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getJobcount() {
        return jobcount;
    }

    public void setJobcount(String jobcount) {
        this.jobcount = jobcount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Enterprise(String id, String name, String summary, String address, String labels, String coordinate, String ishot, String logo, String jobcount, String url) {
        this.id = id;
        this.name = name;
        this.summary = summary;
        this.address = address;
        this.labels = labels;
        this.coordinate = coordinate;
        this.ishot = ishot;
        this.logo = logo;
        this.jobcount = jobcount;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Enterprise{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", summary='" + summary + '\'' +
                ", address='" + address + '\'' +
                ", labels='" + labels + '\'' +
                ", coordinate='" + coordinate + '\'' +
                ", ishot='" + ishot + '\'' +
                ", logo='" + logo + '\'' +
                ", jobcount='" + jobcount + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
