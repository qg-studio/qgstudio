package  com.qgailab.model.po;


import lombok.Data;

import java.math.BigInteger;
@Data
public class User {

  private BigInteger id;
  private String username;
  private String password;
  private String type;
  private java.sql.Timestamp gmtCreate;
  private java.sql.Timestamp gmtModified;



}
