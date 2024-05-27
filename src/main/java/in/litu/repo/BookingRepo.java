package in.litu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.litu.entity.Booking;

public interface BookingRepo extends JpaRepository<Booking, Integer>{

}
