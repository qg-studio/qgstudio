package  com.qgailab.model.po;


import lombok.Data;

import java.math.BigInteger;
@Data
public class Award {

  private BigInteger id;
  private BigInteger number;
  private String project;
  private String game;
  private java.sql.Date date;
  private String level;
  private String prize;
  private String institution;
  private String winner;
  private String leader;
  private java.sql.Timestamp gmtCreate;
  private java.sql.Timestamp gmtModified;



}
