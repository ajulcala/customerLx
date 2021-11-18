package com.customer.app.models.dto;

import lombok.Data;

/**
 * My <b>lombok</b>.
 * My annotations of lombok
 *
 * @Data
 */
@Data
public class SubType {
  private String id;
  private EnumSubType value;

  /**
   * * My <b>enum</b>.
   * es una class native de java
   *
   * @enum
   */

  public enum EnumSubType {
      NORMAL,
      VIP,
      PYME
  }
}
