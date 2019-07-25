package  com.qgailab.model.po;


import lombok.Data;

import java.math.BigInteger;
@Data
public class Leader {

  private BigInteger id;
  private String uuid;
  private String name;
  private String position;
  private String description;
  private java.sql.Timestamp gmtCreate;
  private java.sql.Timestamp gmtModified;


}
