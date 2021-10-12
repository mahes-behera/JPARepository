package com.MBProject.SpringJpa.dto;

import lombok.*;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
public class OrderResponse {
  private String name;
  private String productName;
}
