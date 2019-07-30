package com.qgailab.model.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Leader implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column leader.id
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column leader.uuid
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    private String uuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column leader.name
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column leader.position
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    private String position;
    private List<Image> images;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column leader.gmt_create
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column leader.gmt_modified
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column leader.description
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    private String description;


}