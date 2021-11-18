package com.customer.app.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * My <b>lombok</b>.
 * My annotations of lombok
 *
 * @Data
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeCustomer {
  private String id;
  private EnumTypeCustomer value;
  private SubType subType;

  /**
   * * My <b>enum</b>.
   * es una class native de java
   *
   * @enum
   */
  public enum EnumTypeCustomer {
    EMPRESARIAL,
      PERSONAL
  }
}
