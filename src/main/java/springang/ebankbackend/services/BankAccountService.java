package springang.ebankbackend.services;

import springang.ebankbackend.dtos.CustomerDTO;
import springang.ebankbackend.entities.BankAccount;
import springang.ebankbackend.entities.CurrentAccount;
import springang.ebankbackend.entities.Customer;
import springang.ebankbackend.entities.SavingAccount;
import springang.ebankbackend.exceptions.BalanceNotSufficentException;
import springang.ebankbackend.exceptions.BankAccountNotFoundException;
import springang.ebankbackend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
     CustomerDTO saveCustomer(CustomerDTO customerDTO);
     CurrentAccount saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
     SavingAccount saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;

     List<CustomerDTO> listCustomers();
     BankAccount getBankAccount(String accountId) throws BankAccountNotFoundException;
     void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficentException;
     void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
     void transfer(String accountIdSource, String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficentException;

    List<BankAccount> bankAccountList();

     CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);
}
