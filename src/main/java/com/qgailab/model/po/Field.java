package com.qgailab.model.po;

import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class Field {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column field.id
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column field.uuid
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    private String uuid;



    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column field.name
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    private String name;
    private List<Image> images;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column field.gmt_create
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    private Date gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column field.gmt_modified
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    private Date gmtModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column field.description
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    private String description;


}