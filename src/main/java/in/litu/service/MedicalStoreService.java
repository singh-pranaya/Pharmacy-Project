package in.litu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import in.litu.dao.AddressDao;
import in.litu.dao.AdminDao;
import in.litu.dao.MedcalStoreDao;
import in.litu.dto.AddressDto;
import in.litu.dto.AdminDto;
import in.litu.dto.MedicalStoreDto;
import in.litu.entity.Address;
import in.litu.entity.Admin;
import in.litu.entity.MedicalStore;
import in.litu.execption.AddressIdNotFoundException;
import in.litu.execption.AdminIdNotFoundExecption;
import in.litu.execption.MedicalidNotFoundException;
import in.litu.util.ResponseStructure;

@Service
public class MedicalStoreService {

	@Autowired
	private MedcalStoreDao dao;
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private AddressDao addressDao;
	
	@Autowired
	private MedicalStoreDto dto;
	
	@Autowired
	private AddressDto addressDto;
	
	@Autowired
	private AdminDto adminDto;

	public ResponseEntity<ResponseStructure<MedicalStoreDto>> saveMedicalStore(int adminId, int addressId,
			MedicalStore store) {
		Admin dbAdmin=adminDao.findAdmin(adminId);
		if (dbAdmin!=null) {
			
			Address dbAddress=addressDao.findAddress(addressId);
			if (dbAddress!=null) {
				store.setAdmin(dbAdmin);
				store.setAddress(dbAddress);
				dbAddress.setMedicalStore(store);
				
				MedicalStore dbMedicalStore=dao.saveMedicalStore(store);
				
				dto.setManagerName(dbMedicalStore.getManagerName());
				dto.setName(dbMedicalStore.getName());
				dto.setPhone(dbMedicalStore.getPhone());
				dto.setStoreId(dbMedicalStore.getStoreId());
				dto.setStoreId(dbMedicalStore.getStoreId());
				
				Address address=dbMedicalStore.getAddress();
				
				addressDto.setAddressId(address.getAddressId());
				addressDto.setCity(address.getCity());
				addressDto.setPincode(address.getPincode());
				addressDto.setState(address.getState());
				addressDto.setStreetName(address.getStreetName());
				dto.setAddressDto(addressDto);
				
				
				Admin admin=dbMedicalStore.getAdmin();
				
				adminDto.setAdminEmail(admin.getAdminEmail());
				adminDto.setAdminId(admin.getAdminId());
				adminDto.setAdminName(admin.getAdminName());
				dto.setAdminDto(adminDto);
				
				
				ResponseStructure<MedicalStoreDto> structure=new ResponseStructure<>();
				structure.setMessage("medicalstore saved succesfully");
				structure.setHttpStatus(HttpStatus.CREATED.value());
				structure.setData(dto);
				return new ResponseEntity<ResponseStructure<MedicalStoreDto>>(structure,HttpStatus.CREATED);
				
			}else {
				throw new AddressIdNotFoundException("sorry  failed to open medical store");
			}
			
			
			
		}else {
			throw new AdminIdNotFoundExecption("sorry failed to open medical store");
		}
		
	}

	public ResponseEntity<ResponseStructure<MedicalStoreDto>> updateMedicalStore(int storeId, MedicalStore store) {
		MedicalStore dbMedicalStore=dao.updateMedicalStore(storeId,store);
		if(dbMedicalStore!=null)
		{
			dto.setManagerName(dbMedicalStore.getManagerName());
			dto.setName(dbMedicalStore.getName());
			dto.setPhone(dbMedicalStore.getPhone());
			dto.setStoreId(dbMedicalStore.getStoreId());
			
			Address address=dbMedicalStore.getAddress();
			addressDto.setAddressId(address.getAddressId());
			addressDto.setCity(address.getCity());
			addressDto.setPincode(address.getPincode());
			addressDto.setState(address.getState());
			addressDto.setStreetName(address.getStreetName());
			dto.setAddressDto(addressDto);
			
			
			Admin admin=dbMedicalStore.getAdmin();
			adminDto.setAdminEmail(admin.getAdminEmail());
			adminDto.setAdminId(admin.getAdminId());
			adminDto.setAdminName(admin.getAdminName());
			dto.setAdminDto(adminDto);
			
			
			ResponseStructure<MedicalStoreDto> structure=new ResponseStructure<>();
			structure.setMessage("medicalstore updated succesfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<MedicalStoreDto>>(structure,HttpStatus.OK);
			
		}else {
			throw new MedicalidNotFoundException("failed to update medical store");
		}
	}

	public ResponseEntity<ResponseStructure<MedicalStoreDto>> findMedicalStore(int storeId) {
		MedicalStore dbMedicalStore=dao.findMedicalStore(storeId);
		if (dbMedicalStore!=null) {
			dto.setManagerName(dbMedicalStore.getManagerName());
			dto.setName(dbMedicalStore.getName());
			dto.setPhone(dbMedicalStore.getPhone());
			dto.setStoreId(dbMedicalStore.getStoreId());
			
			Address address=dbMedicalStore.getAddress();
			addressDto.setAddressId(address.getAddressId());
			addressDto.setCity(address.getCity());
			addressDto.setPincode(address.getPincode());
			addressDto.setState(address.getState());
			addressDto.setStreetName(address.getStreetName());
			dto.setAddressDto(addressDto);
			
			
			Admin admin=dbMedicalStore.getAdmin();
			adminDto.setAdminEmail(admin.getAdminEmail());
			adminDto.setAdminId(admin.getAdminId());
			adminDto.setAdminName(admin.getAdminName());
			dto.setAdminDto(adminDto);
			
			
			ResponseStructure<MedicalStoreDto> structure=new ResponseStructure<>();
			structure.setMessage("medicalstore fetch succesfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<MedicalStoreDto>>(structure,HttpStatus.FOUND);
		}
		else {
			throw new MedicalidNotFoundException("failed to find medical store");
		}
	}

	public ResponseEntity<ResponseStructure<MedicalStoreDto>> deleteMedicalStore(int storeId) {
		MedicalStore dbMedicalStore=dao.deleteMedicalStore(storeId);
		if (dbMedicalStore!=null) {
			dto.setManagerName(dbMedicalStore.getManagerName());
			dto.setName(dbMedicalStore.getName());
			dto.setPhone(dbMedicalStore.getPhone());
			dto.setStoreId(dbMedicalStore.getStoreId());
			
			Address address=dbMedicalStore.getAddress();
			addressDto.setAddressId(address.getAddressId());
			addressDto.setCity(address.getCity());
			addressDto.setPincode(address.getPincode());
			addressDto.setState(address.getState());
			addressDto.setStreetName(address.getStreetName());
			dto.setAddressDto(addressDto);
			
			
			Admin admin=dbMedicalStore.getAdmin();
			adminDto.setAdminEmail(admin.getAdminEmail());
			adminDto.setAdminId(admin.getAdminId());
			adminDto.setAdminName(admin.getAdminName());
			dto.setAdminDto(adminDto);
			
			
			ResponseStructure<MedicalStoreDto> structure=new ResponseStructure<>();
			structure.setMessage("medicalstore deleted succesfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<MedicalStoreDto>>(structure,HttpStatus.FOUND);
		}
		else {
			throw new MedicalidNotFoundException("failed to delete medical store");
		}
	}
}
