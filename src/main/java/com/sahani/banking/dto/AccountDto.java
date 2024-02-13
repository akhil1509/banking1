package com.sahani.banking.dto;

import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private  Long id;
    private  String accountHolder;
    private  double balance;
}
