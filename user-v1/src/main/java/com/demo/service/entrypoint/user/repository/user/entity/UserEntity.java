package com.demo.service.entrypoint.user.repository.user.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "`user`")
public class UserEntity implements Serializable {

  @Id
  @Column("user_id")
  protected Long userId;

  @Column("process_traceId")
  private String processTraceId;

  @Column("identity_document_type")
  private String documentType;

  @Column("identity_document_number")
  private String documentNumber;

  @Column("status")
  private boolean status;
}
