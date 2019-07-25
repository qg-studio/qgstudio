package  com.qgailab.model.po;


import lombok.Data;

import java.math.BigInteger;
@Data
public class Patent {

  private BigInteger id;
  private BigInteger number;
  private String type;
  private String name;
  private String zl;
  private String inventor;
  private java.sql.Timestamp gmtCreate;
  private java.sql.Timestamp gmtModified;



}
