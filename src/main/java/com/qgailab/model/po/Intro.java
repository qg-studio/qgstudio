package com.qgailab.model.po;

import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class Intro {



    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column intro.uuid
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    private String uuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column intro.title
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    private String title;
    private List<Image> images;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column intro.gmt_create
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    private Date gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column intro.gmt_modified
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    private Date gmtModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column intro.description
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    private String description;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column intro.id
     *
     * @return the value of intro.id
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column intro.id
     *
     * @param id the value for intro.id
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column intro.uuid
     *
     * @return the value of intro.uuid
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column intro.uuid
     *
     * @param uuid the value for intro.uuid
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column intro.title
     *
     * @return the value of intro.title
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column intro.title
     *
     * @param title the value for intro.title
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column intro.gmt_create
     *
     * @return the value of intro.gmt_create
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column intro.gmt_create
     *
     * @param gmtCreate the value for intro.gmt_create
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column intro.gmt_modified
     *
     * @return the value of intro.gmt_modified
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column intro.gmt_modified
     *
     * @param gmtModified the value for intro.gmt_modified
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column intro.description
     *
     * @return the value of intro.description
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column intro.description
     *
     * @param description the value for intro.description
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}