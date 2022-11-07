package Kodlama.io.Devs.KodlamaIoDevs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.KodlamaIoDevs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.KodlamaIoDevs.business.requests.programmingLanguageRequests.CreateProgrammingLanguageRequest;
import Kodlama.io.Devs.KodlamaIoDevs.business.requests.programmingLanguageRequests.DeleteProgrammingLanguageRequest;
import Kodlama.io.Devs.KodlamaIoDevs.business.requests.programmingLanguageRequests.UpdateProgrammingLanguageRequest;
import Kodlama.io.Devs.KodlamaIoDevs.business.responses.programmingLanguageResponses.GetAllProgrammingLanguagesResponse;
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
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		// is kuralları
		List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
		List<GetAllProgrammingLanguagesResponse> languagesResponse = new ArrayList<GetAllProgrammingLanguagesResponse>();
		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			GetAllProgrammingLanguagesResponse responseItem = new GetAllProgrammingLanguagesResponse();
			responseItem.setId(programmingLanguage.getId());
			responseItem.setName(programmingLanguage.getName());
			languagesResponse.add(responseItem);
		}
		return languagesResponse;
	}

	@Override
	public GetAllProgrammingLanguagesResponse getById(int id) throws Exception {

		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.getReferenceById(id);
		GetAllProgrammingLanguagesResponse languagesResponse = new GetAllProgrammingLanguagesResponse();
		if (!idExists(programmingLanguage.getId())) {
			throw new Exception("Id bulunamadı");
		}
		languagesResponse.setId(programmingLanguage.getId());
		languagesResponse.setName(programmingLanguage.getName());
		return languagesResponse;

	}

	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setName(createProgrammingLanguageRequest.getName());
		if (isEmpty(programmingLanguage)) {
			throw new Exception("Programlama ismi boş geçilemez");
		}
		if (languageControl(programmingLanguage)) {
			throw new Exception("Bu programlama dili mevcuttur.");
		}

		this.programmingLanguageRepository.save(programmingLanguage);

	}

	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest, int id) throws Exception {
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(id).get();//db'ye gider objeyi getirir.
		programmingLanguage.setName(updateProgrammingLanguageRequest.getName());
		if (isEmpty(programmingLanguage)) {
			throw new Exception("Programlama ismi boş geçilemez");
		}
		/*if (languageControl(programmingLanguage)) {
			throw new Exception("Bu programlama dili mevcuttur.");
		}*/
		programmingLanguageRepository.save(programmingLanguage);
	}

	@Override
	public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) throws Exception {
		if (!idExists(deleteProgrammingLanguageRequest.getId())) {
			throw new Exception("Id bulunamadı");
		}
		programmingLanguageRepository.deleteById(deleteProgrammingLanguageRequest.getId());

	}

	public boolean languageControl(ProgrammingLanguage programmingLanguage) {
		for (GetAllProgrammingLanguagesResponse language : getAll()) {
			if (programmingLanguage.getName().equals(language.getName())) {
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

	public boolean idExists(int id) {
		for (GetAllProgrammingLanguagesResponse language : getAll()) {
			if (language.getId() == id) {
				return true;
			}
		}
		return false;

	}
}
