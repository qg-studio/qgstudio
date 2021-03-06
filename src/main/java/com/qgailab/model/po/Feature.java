package com.qgailab.model.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Data
public class Feature implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feature.id
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feature.uuid
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    private String uuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feature.title
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    private String title;

    private List<Image> images;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feature.gmt_create
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feature.gmt_modified
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feature.description
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    private String description;


}