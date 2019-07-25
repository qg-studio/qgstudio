package com.qgailab.dao;

import com.qgailab.model.po.Patent;

import java.math.BigInteger;

public interface PatentDao {

    Patent getPatentById(BigInteger id);

    void removePatentById(BigInteger id);
}
