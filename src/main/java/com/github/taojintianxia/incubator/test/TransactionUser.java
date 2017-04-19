/**
 * TransactionUser.java
 * 
 * @author kane
 * @created 2016年5月11日
 */
package com.github.taojintianxia.incubator.test;

import java.math.BigDecimal;

import lombok.Data;

/**
 * @author kane
 *
 */

@Data
public class TransactionUser {

    long userId;
    int apiUser;
    BigDecimal amount;
    short transType;
}
