package in.litu.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.litu.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	
	@Query("select c from Customer c where c.customerEmail=?1")
	Optional<Customer> findByEmail(String email);

}
