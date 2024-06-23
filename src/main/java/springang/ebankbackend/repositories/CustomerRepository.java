package springang.ebankbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springang.ebankbackend.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
