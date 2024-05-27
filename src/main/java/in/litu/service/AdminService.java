package in.litu.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import in.litu.dao.AdminDao;
import in.litu.dto.AdminDto;
import in.litu.entity.Admin;
import in.litu.execption.AdminIdNotFoundExecption;
import in.litu.util.ResponseStructure;

@Service
public class AdminService {

	@Autowired
	private AdminDao dao;
	
	
	@Autowired
	private AdminDto dto;
	
	@Autowired
	private ModelMapper modelMapper;
	

	public ResponseEntity<ResponseStructure<AdminDto>> saveAdmin(Admin admin)
	{
		Admin dbAdmin=dao.saveAdmin(admin);
		AdminDto dto=this.modelMapper.map(dbAdmin, AdminDto.class);
		ResponseStructure<AdminDto> structure=new ResponseStructure<>();
		structure.setMessage("Admin Data Saved Succesfully");
		structure.setHttpStatus(HttpStatus.CREATED.value());
		structure.setData(dto);
		return new ResponseEntity<ResponseStructure<AdminDto>>(structure,HttpStatus.CREATED);
		
	}

	public ResponseEntity<ResponseStructure<AdminDto>> updateAdmin(int adminId, Admin admin) {
		Admin dbAdmin=dao.updateAdmin(adminId,admin);
		if (dbAdmin!=null) {
			AdminDto dto=this.modelMapper.map(dbAdmin, AdminDto.class);
			ResponseStructure<AdminDto> structure=new ResponseStructure<>();
			structure.setMessage("Admin data updated succesfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dto);
			
			return new ResponseEntity<ResponseStructure<AdminDto>> (structure,HttpStatus.OK);
		}else {
			throw new AdminIdNotFoundExecption("sorry failed to update the data");
		}
	}

	public ResponseEntity<ResponseStructure<AdminDto>> findAdmin(int adminId) {
		Admin dbAdmin=dao.findAdmin(adminId);
		if (dbAdmin!=null) {
			AdminDto dto=this.modelMapper.map(dbAdmin, AdminDto.class);
			ResponseStructure<AdminDto> structure=new ResponseStructure<>();
			structure.setMessage("Admin data fetched succesfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dto);
			
			return new ResponseEntity<ResponseStructure<AdminDto>> (structure,HttpStatus.FOUND);
		}else {
			throw new AdminIdNotFoundExecption("sorry failed to fetch the data");
		}
	}

	public ResponseEntity<ResponseStructure<AdminDto>> deleteAdmin(int adminId) {
		Admin dbAdmin=dao.deleteAdmin(adminId);
		if (dbAdmin!=null) {
			AdminDto dto=this.modelMapper.map(dbAdmin, AdminDto.class);
			ResponseStructure<AdminDto> structure=new ResponseStructure<>();
			structure.setMessage("Admin data deleted succesfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dto);
			
			return new ResponseEntity<ResponseStructure<AdminDto>> (structure,HttpStatus.FOUND);
		}else {
			throw new AdminIdNotFoundExecption("sorry failed to delete the data");
		}
	}
	
	
}