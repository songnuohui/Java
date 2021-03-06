package com.song.trip.web.domain;

import java.util.Date;

public class Food {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_food.tp_fid
     *
     * @mbg.generated
     */
    private Integer tpFid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_food.tp_ftitle
     *
     * @mbg.generated
     */
    private String tpFtitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_food.tp_fname
     *
     * @mbg.generated
     */
    private String tpFname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_food.tp_address
     *
     * @mbg.generated
     */
    private String tpAddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_food.tp_fpic
     *
     * @mbg.generated
     */
    private String tpFpic;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_food.tp_fprice
     *
     * @mbg.generated
     */
    private Integer tpFprice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_food.tp_phone
     *
     * @mbg.generated
     */
    private String tpPhone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_food.tp_fcreated
     *
     * @mbg.generated
     */
    private Date tpFcreated;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_food.tp_fcontent
     *
     * @mbg.generated
     */
    private String tpFcontent;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_food.tp_fid
     *
     * @return the value of tp_food.tp_fid
     *
     * @mbg.generated
     */
    public Integer getTpFid() {
        return tpFid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_food.tp_fid
     *
     * @param tpFid the value for tp_food.tp_fid
     *
     * @mbg.generated
     */
    public void setTpFid(Integer tpFid) {
        this.tpFid = tpFid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_food.tp_ftitle
     *
     * @return the value of tp_food.tp_ftitle
     *
     * @mbg.generated
     */
    public String getTpFtitle() {
        return tpFtitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_food.tp_ftitle
     *
     * @param tpFtitle the value for tp_food.tp_ftitle
     *
     * @mbg.generated
     */
    public void setTpFtitle(String tpFtitle) {
        this.tpFtitle = tpFtitle == null ? null : tpFtitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_food.tp_fname
     *
     * @return the value of tp_food.tp_fname
     *
     * @mbg.generated
     */
    public String getTpFname() {
        return tpFname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_food.tp_fname
     *
     * @param tpFname the value for tp_food.tp_fname
     *
     * @mbg.generated
     */
    public void setTpFname(String tpFname) {
        this.tpFname = tpFname == null ? null : tpFname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_food.tp_address
     *
     * @return the value of tp_food.tp_address
     *
     * @mbg.generated
     */
    public String getTpAddress() {
        return tpAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_food.tp_address
     *
     * @param tpAddress the value for tp_food.tp_address
     *
     * @mbg.generated
     */
    public void setTpAddress(String tpAddress) {
        this.tpAddress = tpAddress == null ? null : tpAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_food.tp_fpic
     *
     * @return the value of tp_food.tp_fpic
     *
     * @mbg.generated
     */
    public String getTpFpic() {
        return tpFpic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_food.tp_fpic
     *
     * @param tpFpic the value for tp_food.tp_fpic
     *
     * @mbg.generated
     */
    public void setTpFpic(String tpFpic) {
        this.tpFpic = tpFpic == null ? null : tpFpic.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_food.tp_fprice
     *
     * @return the value of tp_food.tp_fprice
     *
     * @mbg.generated
     */
    public Integer getTpFprice() {
        return tpFprice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_food.tp_fprice
     *
     * @param tpFprice the value for tp_food.tp_fprice
     *
     * @mbg.generated
     */
    public void setTpFprice(Integer tpFprice) {
        this.tpFprice = tpFprice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_food.tp_phone
     *
     * @return the value of tp_food.tp_phone
     *
     * @mbg.generated
     */
    public String getTpPhone() {
        return tpPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_food.tp_phone
     *
     * @param tpPhone the value for tp_food.tp_phone
     *
     * @mbg.generated
     */
    public void setTpPhone(String tpPhone) {
        this.tpPhone = tpPhone == null ? null : tpPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_food.tp_fcreated
     *
     * @return the value of tp_food.tp_fcreated
     *
     * @mbg.generated
     */
    public Date getTpFcreated() {
        return tpFcreated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_food.tp_fcreated
     *
     * @param tpFcreated the value for tp_food.tp_fcreated
     *
     * @mbg.generated
     */
    public void setTpFcreated(Date tpFcreated) {
        this.tpFcreated = tpFcreated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_food.tp_fcontent
     *
     * @return the value of tp_food.tp_fcontent
     *
     * @mbg.generated
     */
    public String getTpFcontent() {
        return tpFcontent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_food.tp_fcontent
     *
     * @param tpFcontent the value for tp_food.tp_fcontent
     *
     * @mbg.generated
     */
    public void setTpFcontent(String tpFcontent) {
        this.tpFcontent = tpFcontent == null ? null : tpFcontent.trim();
    }
}