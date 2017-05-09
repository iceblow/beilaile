package com.warehouse.entity;

public class InKu {
    private Integer rid;

    private String rdate;

    private String boci;

    private String mianliao;

    private String color;

    private String cun1;

    private String cun2;

    private String cun3;

    private String cun4;

    private String cun5;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRdate() {
        return rdate;
    }

    public void setRdate(String rdate) {
        this.rdate = rdate == null ? null : rdate.trim();
    }

    public String getBoci() {
        return boci;
    }

    public void setBoci(String boci) {
        this.boci = boci == null ? null : boci.trim();
    }

    public String getMianliao() {
        return mianliao;
    }

    public void setMianliao(String mianliao) {
        this.mianliao = mianliao == null ? null : mianliao.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getCun1() {
        return cun1;
    }

    public void setCun1(String cun1) {
        this.cun1 = cun1 == null ? null : cun1.trim();
    }

    public String getCun2() {
        return cun2;
    }

    public void setCun2(String cun2) {
        this.cun2 = cun2 == null ? null : cun2.trim();
    }

    public String getCun3() {
        return cun3;
    }

    public void setCun3(String cun3) {
        this.cun3 = cun3 == null ? null : cun3.trim();
    }

    public String getCun4() {
        return cun4;
    }

    public void setCun4(String cun4) {
        this.cun4 = cun4 == null ? null : cun4.trim();
    }

    public String getCun5() {
        return cun5;
    }

    public void setCun5(String cun5) {
        this.cun5 = cun5 == null ? null : cun5.trim();
    }
}