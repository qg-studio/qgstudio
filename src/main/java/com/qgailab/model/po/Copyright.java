package  com.qgailab.model.po;


import lombok.Data;

import java.math.BigInteger;
@Data
public class Copyright {

  private BigInteger id;
  private BigInteger number;
  private String name;
  private String rn;
  private java.sql.Date date;
  private java.sql.Timestamp gmtCreate;
  private java.sql.Timestamp gmtModified;



}
