package in.litu.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.litu.entity.Address;
import in.litu.entity.MedicalStore;
import in.litu.repo.MedicalStoreRepo;

@Repository
public class MedcalStoreDao {
	
	@Autowired
	private MedicalStoreRepo repo;

	public MedicalStore saveMedicalStore(MedicalStore store) {
		
		return repo.save(store);
	}

	public MedicalStore updateMedicalStore(int storeId, MedicalStore store) {
		Optional<MedicalStore> optional = repo.findById(storeId);
		if (optional.isPresent()) {
			//ID IS PRESENT AND WE CAN UPDATE
			//BEFORE CALLING UPDATE METHOD WE NEED TO SET DATA
			store.setAddress(optional.get().getAddress());
			store.setAdmin(optional.get().getAdmin());
			store.setStoreId(storeId);

			return repo.save(store);
		}else {
			return null;
		}
	}

	public MedicalStore findMedicalStore(int storeId) {
		Optional<MedicalStore> optional = repo.findById(storeId);
		if (optional.isPresent()) {
			
			return optional.get();
		}else {
			return null;
		}
	}

	public MedicalStore deleteMedicalStore(int storeId) {
		Optional<MedicalStore> optional = repo.findById(storeId);
		if (optional.isPresent()) {
			MedicalStore medicalStore=optional.get();
			Address address=medicalStore.getAddress();
			address.setMedicalStore(null);
			repo.deleteById(storeId);
			return optional.get();
		}else {
			return null;
		}
	}

}
