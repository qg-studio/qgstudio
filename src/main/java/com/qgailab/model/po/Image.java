package  com.qgailab.model.po;


import lombok.Data;

import java.math.BigInteger;
@Data
public class Image {

  private BigInteger id;
  private String fuuid;
  private String filename;
  private java.sql.Timestamp gmtCreate;
  private java.sql.Timestamp gmtModified;

}
