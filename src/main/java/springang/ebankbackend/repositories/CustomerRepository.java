package springang.ebankbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springang.ebankbackend.entities.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findCustomerByNameContains(String keyword);
}
