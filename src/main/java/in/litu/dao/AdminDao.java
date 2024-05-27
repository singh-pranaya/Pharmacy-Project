package in.litu.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.litu.entity.Admin;
import in.litu.repo.AdminRepo;

@Repository
public class AdminDao {

	@Autowired
	private AdminRepo adminRepo;

	public Admin saveAdmin(Admin admin) {
		return adminRepo.save(admin);
		
	}

	public Admin updateAdmin(int adminId, Admin admin) {
		Optional<Admin> optional = adminRepo.findById(adminId);
		if (optional.isPresent()) {
			admin.setAdminId(adminId);
			return adminRepo.save(admin);
		}
		return null;
	}

	public Admin findAdmin(int adminId) {
		Optional<Admin> optional = adminRepo.findById(adminId);
		
		if (optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}

	public Admin deleteAdmin(int adminId) {
		Optional<Admin> optional = adminRepo.findById(adminId);
		if(optional.isPresent())
		{
			Admin admin=optional.get();
			adminRepo.delete(admin);
			return admin;
		}else {
			return null;
		}
		
	}
}
