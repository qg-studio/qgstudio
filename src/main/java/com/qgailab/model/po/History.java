package  com.qgailab.model.po;

import lombok.Data;

import java.math.BigInteger;

@Data
public class History {

  private BigInteger id;
  private String uuid;
  private String title;
  private String description;
  private java.sql.Timestamp gmtCreate;
  private java.sql.Timestamp gmtModified;




}
