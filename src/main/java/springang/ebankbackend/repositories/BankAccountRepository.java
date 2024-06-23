package springang.ebankbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springang.ebankbackend.entities.BankAccount;
import springang.ebankbackend.entities.Customer;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}
