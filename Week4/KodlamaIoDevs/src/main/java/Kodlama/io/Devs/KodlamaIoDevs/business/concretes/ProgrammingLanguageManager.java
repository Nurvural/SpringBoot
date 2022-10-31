package Kodlama.io.Devs.KodlamaIoDevs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.KodlamaIoDevs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.KodlamaIoDevs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.KodlamaIoDevs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		// is kuralları
		return programmingLanguageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage getById(int id) {

		return programmingLanguageRepository.getById(id);
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		if (languageControl(programmingLanguage)) {
			throw new Exception("Bu programlama dili mevcuttur.");
		}
		if (isEmpty(programmingLanguage)) {
			throw new Exception("Programlama ismi boş geçilemez");
		}
		if (isEmptyId(programmingLanguage.getId())) {
			throw new Exception("Böyle bir ID Bulunmaktadır.");
		}
		programmingLanguageRepository.add(programmingLanguage);

	}

	public boolean languageControl(ProgrammingLanguage programmingLanguage) {
		for (ProgrammingLanguage programmingLanguage2 : this.programmingLanguageRepository.getAll()) {
			if (programmingLanguage.getName().equals(programmingLanguage2.getName())) {
				return true;
			}
		}
		return false;
	}

	public boolean isEmpty(ProgrammingLanguage programmingLanguage) {
		if (programmingLanguage.getName().isBlank()) {
			return true;
		}
		return false;
	}

	public boolean isEmptyId(int id) {
		for (ProgrammingLanguage programmingLanguage2 : programmingLanguageRepository.getAll()) {
			if (programmingLanguage2.getId() == id) {
				return true;
			}
		}
		return false;

	}

	@Override
	public void delete(int id) throws Exception {
		if (!isEmptyId(id)) {
			throw new Exception("Böyle bir ID Bulunmamaktadır.");
		}
		programmingLanguageRepository.delete(id);

	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage, int id) throws Exception {
		if (languageControl(programmingLanguage)) {
			throw new Exception("Bu programlama dili mevcuttur.");
		}
		if (isEmpty(programmingLanguage)) {
			throw new Exception("Programlama ismi boş geçilemez");
		}
		if (!isEmptyId(id)) {
			throw new Exception("Böyle bir ID Bulunmamaktadır.");
		}
//	     for (ProgrammingLanguage programmingLanguage3 : getAll()){
//	            if (programmingLanguage3.getName()==programmingLanguage.getName()){
//	                throw new Exception("Name cannot be repeated");
//	            }
//	        }
		programmingLanguageRepository.getById(id);
		programmingLanguageRepository.update(programmingLanguage, id);
	}

}
