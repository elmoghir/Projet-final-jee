package springang.ebankbackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springang.ebankbackend.dtos.BankAccountDTO;
import springang.ebankbackend.dtos.CurrentBankAccountDTO;
import springang.ebankbackend.dtos.CustomerDTO;
import springang.ebankbackend.dtos.SavingBankAccountDTO;
import springang.ebankbackend.entities.*;
import springang.ebankbackend.enums.AccountStatus;
import springang.ebankbackend.enums.OperationType;
import springang.ebankbackend.exceptions.BalanceNotSufficentException;
import springang.ebankbackend.exceptions.BankAccountNotFoundException;
import springang.ebankbackend.exceptions.CustomerNotFoundException;
import springang.ebankbackend.repositories.AccountOperationRepository;
import springang.ebankbackend.repositories.BankAccountRepository;
import springang.ebankbackend.repositories.CustomerRepository;
import springang.ebankbackend.services.BankAccountService;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankBackendApplication.class, args);
    }
       @Bean
       CommandLineRunner commandLineRunner(BankAccountService bankAccountService){
        return args -> {
          Stream.of("Abdessamad","Youssef","Ahmed").forEach(name->{
              CustomerDTO customer = new CustomerDTO();
              customer.setName(name);
              customer.setEmail(name+"@gmail.com");
              bankAccountService.saveCustomer(customer);
          });
          bankAccountService.listCustomers().forEach(customer -> {
              try {
                  bankAccountService.saveCurrentBankAccount(Math.random()*9000,9000,customer.getId());
                  bankAccountService.saveSavingBankAccount(Math.random()*120000,5.5,customer.getId());


              }catch (CustomerNotFoundException e)
              {
                  e.printStackTrace();
              }
          });
            List<BankAccountDTO> bankAccounts = bankAccountService.bankAccountList();
            for(BankAccountDTO bankAccount:bankAccounts){
                for(int i = 0; i < 10; i++){
                    String accountId;
                    if(bankAccount instanceof SavingBankAccountDTO)
                    {
                        accountId =((SavingBankAccountDTO)  bankAccount).getId();
                    }else{
                        accountId = ((CurrentBankAccountDTO) bankAccount).getId();
                    }
                    bankAccountService.credit(accountId, 1000+Math.random()*120000,"Credit");
                    bankAccountService.debit(accountId,1000+Math.random()*9000,"Debit");
                }
            }
        };
       }

    //        @Bean
        CommandLineRunner start(CustomerRepository customerRepository,
                                BankAccountRepository bankAccountRepository,
                                AccountOperationRepository accountOperationRepository){
            return args-> {
                Stream.of("Abdessamad", "Mohamed", "Brahim").forEach(
                        name->{
                            Customer customer = new Customer();
                            customer.setName(name);
                            customer.setEmail(name+"@gmail.com");
                            customerRepository.save(customer);
                        }
                );
                customerRepository.findAll().forEach(
                        cust->{
                            CurrentAccount currentAccount = new CurrentAccount();
                            currentAccount.setId(UUID.randomUUID().toString());
                            currentAccount.setBalance(Math.random()*90000);
                            currentAccount.setCreatedAt(new Date());
                            currentAccount.setStatus(AccountStatus.CREATED);
                            currentAccount.setCustomer(cust);
                            currentAccount.setOverDraft(9000);
                            bankAccountRepository.save(currentAccount);

                            SavingAccount savingAccount = new SavingAccount();
                            savingAccount.setId(UUID.randomUUID().toString());
                            savingAccount.setBalance(Math.random()*90000);
                            savingAccount.setCreatedAt(new Date());
                            savingAccount.setStatus(AccountStatus.CREATED);
                            savingAccount.setCustomer(cust);
                            savingAccount.setInterestRate(5.5);
                            bankAccountRepository.save(savingAccount);
                        }
                );
                bankAccountRepository.findAll().forEach(
                        acc->{
                            for(int i = 0; i < 10; i++)
                            {
                                AccountOperation accountOperation = new AccountOperation();
                                accountOperation.setOperationDate(new Date());
                                accountOperation.setAmount(Math.random()*12000);
                                accountOperation.setType(Math.random()>0.5? OperationType.DEBIT:OperationType.CREDIT);
                                accountOperation.setBankAccount(acc);
                                accountOperationRepository.save(accountOperation);
                            }
                        }
                );
            };

        }

}
