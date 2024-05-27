package in.litu.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import in.litu.dao.MedcalStoreDao;
import in.litu.dao.MedicineDao;
import in.litu.dto.MedicineDto;
import in.litu.entity.MedicalStore;
import in.litu.entity.Medicine;

import in.litu.execption.MedicalidNotFoundException;
import in.litu.execption.MedicineIdNotFoundException;
import in.litu.execption.MedicinenameNotFoundException;
import in.litu.util.ResponseStructure;

@Service
public class MedicineService {

	@Autowired
	private MedicineDao dao;
	
	@Autowired
	private MedcalStoreDao storeDao;
	
	@Autowired
	private ModelMapper mapper;

	public ResponseEntity<ResponseStructure<MedicineDto>> saveMedicine(int storeId, Medicine medicine) {
		MedicalStore store=storeDao.findMedicalStore(storeId);
		if (store!=null) {
			medicine.setMedicalStore(store);
			Medicine dbMedicine=dao.saveMedicine(medicine);
			MedicineDto dto=this.mapper.map(dbMedicine,MedicineDto.class);
			ResponseStructure<MedicineDto> structure=new ResponseStructure<>();
			structure.setMessage("medicine saved succesfully");
			structure.setHttpStatus(HttpStatus.CREATED.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<MedicineDto>>(structure,HttpStatus.CREATED);
		}else {
			throw new MedicalidNotFoundException("sorry failed to save the medicine");
		}
	}

	public ResponseEntity<ResponseStructure<MedicineDto>> updateMedicine(int medicineId, Medicine medicine) {
		Medicine dbMedicine=dao.updateMedicine(medicineId,medicine);
		if (dbMedicine!=null) {
			MedicineDto dto=this.mapper.map(dbMedicine,MedicineDto.class);
			ResponseStructure<MedicineDto> structure=new ResponseStructure<>();
			structure.setMessage("medicine updated succesfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<MedicineDto>>(structure,HttpStatus.OK);
		}else {
			throw new MedicineIdNotFoundException("sorry failed to update medicine");
		}
	}

	public ResponseEntity<ResponseStructure<MedicineDto>> findMedicine(int medicineId) {
		Medicine dbMedicine=dao.findMedicine(medicineId);
		if (dbMedicine!=null) {
			MedicineDto dto=this.mapper.map(dbMedicine,MedicineDto.class);
			ResponseStructure<MedicineDto> structure=new ResponseStructure<>();
			structure.setMessage("medicine fetch succesfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<MedicineDto>>(structure,HttpStatus.FOUND);
		}else {
			throw new MedicineIdNotFoundException("sorry failed to fetch the medicine");
		}
	}

	public ResponseEntity<ResponseStructure<MedicineDto>> deleteMedicine(int medicineId) {
			Medicine dbMedicine=dao.deleteMedicine(medicineId);
			if (dbMedicine!=null) {
				MedicineDto dto=this.mapper.map(dbMedicine,MedicineDto.class);
				ResponseStructure<MedicineDto> structure=new ResponseStructure<>();
				structure.setMessage("medicine deleted succesfully");
				structure.setHttpStatus(HttpStatus.FOUND.value());
				structure.setData(dto);
				return new ResponseEntity<ResponseStructure<MedicineDto>>(structure,HttpStatus.FOUND);
			}
			else {
				throw new MedicineIdNotFoundException("sorry failed to delete medicine");
			}
	}

	public ResponseEntity<ResponseStructure<MedicineDto>> findMedicineByName(String medicineName) {
		Medicine dbMedicine=dao.findMedicineByName(medicineName);
		if (dbMedicine!=null) {
			MedicineDto dto=this.mapper.map(dbMedicine,MedicineDto.class);
			ResponseStructure<MedicineDto> structure=new ResponseStructure<>();
			structure.setMessage("medicine fetched succesfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<MedicineDto>>(structure,HttpStatus.FOUND);
		}else {
		
			throw new MedicinenameNotFoundException("sorry failed to find medicine by name");
		
		}
	}
}

