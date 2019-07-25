package  com.qgailab.model.po;


import lombok.Data;

import java.math.BigInteger;
@Data
public class Member {

  private BigInteger id;
  private String uuid;
  private String name;
  private String grade;
  private String field;
  private java.sql.Timestamp gmtCreate;
  private java.sql.Timestamp gmtModified;


}
