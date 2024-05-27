package in.litu.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import in.litu.dao.AdminDao;
import in.litu.dao.MedcalStoreDao;
import in.litu.dao.StaffDao;import in.litu.dto.AdminDto;
import in.litu.dto.MedicalStoreDto;
import in.litu.dto.StaffDto;
import in.litu.entity.Admin;
import in.litu.entity.MedicalStore;
import in.litu.entity.Staff;
import in.litu.execption.AdminIdNotFoundExecption;
import in.litu.execption.MedicalidNotFoundException;
import in.litu.execption.StaffidNotFoundException;
import in.litu.util.ResponseStructure;

@Service
public class Staffservice {

	@Autowired
	private StaffDao dao;
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private MedcalStoreDao storeDao;
	
	@Autowired
	private StaffDto dto;
	
	@Autowired
	private ModelMapper mapper;

	public ResponseEntity<ResponseStructure<StaffDto>> saveStaff(int adminId, int storeId, Staff staff) {
		Admin admin = adminDao.findAdmin(adminId);
		if (admin!=null) {
			staff.setAdmin(admin);
			MedicalStore store = storeDao.findMedicalStore(storeId);
			if (store!=null) {
				staff.setMedicalStore(store);
				Staff dbStaff=dao.saveStaff(staff);
				StaffDto dto = this.mapper.map(dbStaff, StaffDto.class);
				
				
				Admin dbAdmin=dbStaff.getAdmin();
				AdminDto adminDto=this.mapper.map(dbAdmin, AdminDto.class);
				MedicalStore dbMedicalStore=dbStaff.getMedicalStore();
				MedicalStoreDto medicalStoreDto=this.mapper.map(dbMedicalStore, MedicalStoreDto.class);
				dto.setAdminDto(adminDto);
				dto.setMedicalStoreDto(medicalStoreDto);
				
	
				
				
				ResponseStructure<StaffDto> structure=new ResponseStructure<>();
				structure.setMessage("staff saved succesfully");
				structure.setHttpStatus(HttpStatus.CREATED.value());
				structure.setData(dto);
				return new ResponseEntity<ResponseStructure<StaffDto>>(structure,HttpStatus.CREATED);
			}else {
				throw new MedicalidNotFoundException("sorry failed to add staff");
			}
		}else {
			throw new AdminIdNotFoundExecption("sorry failed to save staff");
		}
		
	}

	public ResponseEntity<ResponseStructure<StaffDto>> updateStaff(int staffId, Staff staff) {
		Staff dbStaff=dao.updateStaff(staffId,staff);
		if (dbStaff!=null) {
			StaffDto dto = this.mapper.map(dbStaff, StaffDto.class);
			
			
			
			Admin dbAdmin=dbStaff.getAdmin();
			AdminDto adminDto=this.mapper.map(dbAdmin, AdminDto.class);
			MedicalStore dbMedicalStore=dbStaff.getMedicalStore();
			MedicalStoreDto medicalStoreDto=this.mapper.map(dbMedicalStore, MedicalStoreDto.class);
			dto.setAdminDto(adminDto);
			dto.setMedicalStoreDto(medicalStoreDto);
			
			
			
			
			
			
			
			
			
			
			ResponseStructure<StaffDto> structure=new ResponseStructure<>();
			structure.setMessage("staff updated succesfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<StaffDto>>(structure,HttpStatus.OK);
		}else {
			throw new StaffidNotFoundException("sorry failed to updatestaff");
		}
	}

	public ResponseEntity<ResponseStructure<StaffDto>> findStaff(int staffId) {
		Staff dbStaff=dao.findStaff(staffId);
		if (dbStaff!=null) {
			StaffDto dto = this.mapper.map(dbStaff, StaffDto.class);
			
			
			
			Admin dbAdmin=dbStaff.getAdmin();
			AdminDto adminDto=this.mapper.map(dbAdmin, AdminDto.class);
			MedicalStore dbMedicalStore=dbStaff.getMedicalStore();
			MedicalStoreDto medicalStoreDto=this.mapper.map(dbMedicalStore, MedicalStoreDto.class);
			dto.setAdminDto(adminDto);
			dto.setMedicalStoreDto(medicalStoreDto);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			ResponseStructure<StaffDto> structure=new ResponseStructure<>();
			structure.setMessage("staff fetched succesfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<StaffDto>>(structure,HttpStatus.FOUND);
		}else {
			throw new StaffidNotFoundException("sorry failed to updatestaff");
		}
	}

	public ResponseEntity<ResponseStructure<StaffDto>> deleteStaff(int staffId) {
		Staff dbStaff=dao.deleteStaff(staffId);
		if (dbStaff!=null) {
			StaffDto dto = this.mapper.map(dbStaff, StaffDto.class);
			
			
			Admin dbAdmin=dbStaff.getAdmin();
			AdminDto adminDto=this.mapper.map(dbAdmin, AdminDto.class);
			MedicalStore dbMedicalStore=dbStaff.getMedicalStore();
			MedicalStoreDto medicalStoreDto=this.mapper.map(dbMedicalStore, MedicalStoreDto.class);
			dto.setAdminDto(adminDto);
			dto.setMedicalStoreDto(medicalStoreDto);
			
			
			
			
			
			
			
			
			
			
			ResponseStructure<StaffDto> structure=new ResponseStructure<>();
			structure.setMessage("staff fetched succesfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<StaffDto>>(structure,HttpStatus.FOUND);
		}else {
			throw new StaffidNotFoundException("sorry failed to updatestaff");
		}
	}
}
