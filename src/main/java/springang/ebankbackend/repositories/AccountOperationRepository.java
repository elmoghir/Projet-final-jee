package springang.ebankbackend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import springang.ebankbackend.entities.AccountOperation;
import springang.ebankbackend.entities.BankAccount;

import java.util.List;

public interface AccountOperationRepository extends JpaRepository<AccountOperation, String> {
    List<AccountOperation> findByBankAccountId(String accountId);
    Page<AccountOperation> findByBankAccountId(String accountId, Pageable pageable);


}
