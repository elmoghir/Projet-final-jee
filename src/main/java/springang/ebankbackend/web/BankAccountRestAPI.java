package springang.ebankbackend.web;

import org.springframework.web.bind.annotation.*;
import springang.ebankbackend.dtos.AccountHistoryDTO;
import springang.ebankbackend.dtos.AccountOperationDTO;
import springang.ebankbackend.dtos.BankAccountDTO;
import springang.ebankbackend.exceptions.BankAccountNotFoundException;
import springang.ebankbackend.services.BankAccountService;

import java.util.List;

@RestController
@CrossOrigin("*")
public class BankAccountRestAPI {
    private BankAccountService bankAccountService;

    public BankAccountRestAPI(BankAccountService bankAccountRestAPI)
    {
        this.bankAccountService = bankAccountRestAPI;
    }
    @GetMapping("/accounts/{accountId}")
    public BankAccountDTO getBankAccount(@PathVariable String accountId) throws BankAccountNotFoundException {
        return bankAccountService.getBankAccount(accountId);
    }
    @GetMapping("/accounts")
    public List<BankAccountDTO> listAccounts()
    {
        return bankAccountService.bankAccountList();
    }
    @GetMapping("/accounts/{accountId}/operations")
    public List<AccountOperationDTO> getHistory(@PathVariable String accountId)
    {
        return bankAccountService.accountHistory(accountId);
    }
    @GetMapping("/accounts/{accountId}/pageOperations")
    public AccountHistoryDTO getAccountHistory(@PathVariable String accountId,
                                               @RequestParam(name="page",defaultValue = "0") int page,
                                               @RequestParam(name="size",defaultValue = "5")int size) throws BankAccountNotFoundException {
        return bankAccountService.getAccountHistory(accountId,page,size);
    }

}
