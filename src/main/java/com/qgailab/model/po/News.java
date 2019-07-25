package  com.qgailab.model.po;


import lombok.Data;

import java.math.BigInteger;
@Data
public class News {

  private BigInteger id;
  private BigInteger number;
  private String title;
  private String url;
  private java.sql.Timestamp gmtCreate;
  private java.sql.Timestamp gmtModified;


}
