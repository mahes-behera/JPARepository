package com.MBProject.SpringJpa.dto;

import com.MBProject.SpringJpa.model.User;
import lombok.*;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
public class OrderRequest {
    private User user;
}
