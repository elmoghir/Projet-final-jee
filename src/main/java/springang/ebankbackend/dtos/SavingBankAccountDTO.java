package springang.ebankbackend.dtos;

import lombok.Data;
import springang.ebankbackend.entities.BankAccount;
import springang.ebankbackend.enums.AccountStatus;

import java.util.Date;

@Data
public class SavingBankAccountDTO extends BankAccountDTO {
    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    private CustomerDTO customerDTO;
    private double interestRate;
}
