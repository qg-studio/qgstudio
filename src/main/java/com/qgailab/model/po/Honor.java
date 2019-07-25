package  com.qgailab.model.po;


import lombok.Data;

import java.math.BigInteger;
@Data
public class Honor {

  private BigInteger id;
  private String uuid;
  private String title;
  private String description;
  private java.sql.Date date;
  private java.sql.Timestamp gmtCreate;
  private java.sql.Timestamp gmtModified;


}
