package  com.qgailab.model.po;


import lombok.Data;

import java.math.BigInteger;

@Data
public class Log {

  private BigInteger id;
  private java.sql.Timestamp time;
  private String note;
  private java.sql.Timestamp gmtCreate;
  private java.sql.Timestamp gmtModified;



}
