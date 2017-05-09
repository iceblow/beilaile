package com.warehouse.entity;

public class OutKu {
    private Integer oid;

    private String gongying;

    private String odate;

    private String oboci;

    private String mianliao;

    private String ocolor;

    private String chu1;

    private String chu2;

    private String chu3;

    private String chu4;

    private String chu5;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getGongying() {
        return gongying;
    }

    public void setGongying(String gongying) {
        this.gongying = gongying == null ? null : gongying.trim();
    }

    public String getOdate() {
        return odate;
    }

    public void setOdate(String odate) {
        this.odate = odate == null ? null : odate.trim();
    }

    public String getOboci() {
        return oboci;
    }

    public void setOboci(String oboci) {
        this.oboci = oboci == null ? null : oboci.trim();
    }

    public String getMianliao() {
        return mianliao;
    }

    public void setMianliao(String mianliao) {
        this.mianliao = mianliao == null ? null : mianliao.trim();
    }

    public String getOcolor() {
        return ocolor;
    }

    public void setOcolor(String ocolor) {
        this.ocolor = ocolor == null ? null : ocolor.trim();
    }

    public String getChu1() {
        return chu1;
    }

    public void setChu1(String chu1) {
        this.chu1 = chu1 == null ? null : chu1.trim();
    }

    public String getChu2() {
        return chu2;
    }

    public void setChu2(String chu2) {
        this.chu2 = chu2 == null ? null : chu2.trim();
    }

    public String getChu3() {
        return chu3;
    }

    public void setChu3(String chu3) {
        this.chu3 = chu3 == null ? null : chu3.trim();
    }

    public String getChu4() {
        return chu4;
    }

    public void setChu4(String chu4) {
        this.chu4 = chu4 == null ? null : chu4.trim();
    }

    public String getChu5() {
        return chu5;
    }

    public void setChu5(String chu5) {
        this.chu5 = chu5 == null ? null : chu5.trim();
    }
}