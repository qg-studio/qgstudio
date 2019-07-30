package com.qgailab.model.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Honor implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column honor.id
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column honor.uuid
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    private String uuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column honor.title
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column honor.date
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date date;
    private List<Image> images;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column honor.gmt_create
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column honor.gmt_modified
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column honor.description
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    private String description;


}