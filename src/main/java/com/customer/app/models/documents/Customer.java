package com.customer.app.models.documents;

import com.customer.app.models.dto.TypeCustomer;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * My <b>lombok</b>.
 * My annotations of lombok
 *
 * @Data
 */
@Data
@Builder
@Document(collection = "customer")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
  @Id
  private String id;
  private DocumentType documentType; //ruc/dni
  private String documentNumber; //ruc o dni
  private String names; //nombres o razon social
  private String gender; //masculino / feminino
  private String numberphone; //telefono
  private String address;
  @JsonFormat(pattern = "dd/MM/yyyy")
  private Date dateBirth;
  private TypeCustomer typeCustomer;
  @DateTimeFormat(pattern = "yyyy/MM/dd")
  private Date createAc;

  /**
   * * My <b>enum</b>.
   * es una class native de java
   *
   * @enum
   */
  public enum DocumentType {
    DNI,
    RUC
  }
}
