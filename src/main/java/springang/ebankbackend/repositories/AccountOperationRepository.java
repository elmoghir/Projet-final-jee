package springang.ebankbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springang.ebankbackend.entities.AccountOperation;
import springang.ebankbackend.entities.BankAccount;

public interface AccountOperationRepository extends JpaRepository<AccountOperation, String> {
}
