package in.litu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.litu.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

}
