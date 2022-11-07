package Kodlama.io.Devs.KodlamaIoDevs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.KodlamaIoDevs.business.abstracts.LanguageTechnologyService;
import Kodlama.io.Devs.KodlamaIoDevs.business.requests.languageTechnologyRequests.CreateLanguageTechnologyRequest;
import Kodlama.io.Devs.KodlamaIoDevs.business.requests.languageTechnologyRequests.DeleteLanguageTechnologyRequest;
import Kodlama.io.Devs.KodlamaIoDevs.business.requests.languageTechnologyRequests.UpdateLanguageTechnologyRequest;
import Kodlama.io.Devs.KodlamaIoDevs.business.responses.languageTechnologyResponses.GetAllLanguageTechnologiesResponse;
import Kodlama.io.Devs.KodlamaIoDevs.dataAccess.abstracts.LanguageTechnologyRepository;
import Kodlama.io.Devs.KodlamaIoDevs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.KodlamaIoDevs.entities.concretes.LanguageTechnology;
import Kodlama.io.Devs.KodlamaIoDevs.entities.concretes.ProgrammingLanguage;

@Service
public class LanguageTechnologyManager implements LanguageTechnologyService {

	private LanguageTechnologyRepository languageTechnologyRepository;
	private ProgrammingLanguageRepository programmingLanguageRepository;

	@Autowired
	public LanguageTechnologyManager(LanguageTechnologyRepository languageTechnologyRepository,ProgrammingLanguageRepository programmingLanguageRepository) {
		this.languageTechnologyRepository = languageTechnologyRepository;
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<GetAllLanguageTechnologiesResponse> getAll() {
		List<LanguageTechnology> languageTechnologies = languageTechnologyRepository.findAll();
		List<GetAllLanguageTechnologiesResponse> languageTechnologyResponses = new ArrayList<GetAllLanguageTechnologiesResponse>();
		for (LanguageTechnology languageTechnology : languageTechnologies) {
			GetAllLanguageTechnologiesResponse responseItem = new GetAllLanguageTechnologiesResponse();
			responseItem.setId(languageTechnology.getId());
			responseItem.setName(languageTechnology.getName());
			responseItem.setProgrammingLanguage(languageTechnology.getProgrammingLanguage().getName());
			languageTechnologyResponses.add(responseItem);
		}
		return languageTechnologyResponses;
	}

	@Override
	public void add(CreateLanguageTechnologyRequest createLanguageTechnologyRequest) throws Exception {
		LanguageTechnology languageTechnology = new LanguageTechnology();
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(createLanguageTechnologyRequest.getLanguageId()).get();
		languageTechnology.setName(createLanguageTechnologyRequest.getName());
		languageTechnology.setProgrammingLanguage(programmingLanguage);
		if (isEmpty(languageTechnology)) {
			throw new Exception("Programlama ismi boş geçilemez");
		}
		if (languageControl(languageTechnology)) {
			throw new Exception("Bu programlama dili mevcuttur.");
		}
		this.languageTechnologyRepository.save(languageTechnology);

	}

	@Override
	public void update(UpdateLanguageTechnologyRequest updateLanguageTechnologyRequest, int id) throws Exception {
		LanguageTechnology languageTechnology = languageTechnologyRepository.findById(id).get();
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(updateLanguageTechnologyRequest.getLanguageId()).get();
		languageTechnology.setName(updateLanguageTechnologyRequest.getName());
		languageTechnology.setProgrammingLanguage(programmingLanguage);
		if (isEmpty(languageTechnology)) {
			throw new Exception("Programlama ismi boş geçilemez");
		}
		/*if (languageControl(languageTechnology)) {
			throw new Exception("Bu programlama dili mevcuttur.");
		}*/
		languageTechnologyRepository.save(languageTechnology);
	}

	@Override
	public void delete(DeleteLanguageTechnologyRequest deleteLanguageTechnologyRequest) throws Exception {
		if (!idExists(deleteLanguageTechnologyRequest.getId())) {
			throw new Exception("Id bulunamadı");
		}
		languageTechnologyRepository.deleteById(deleteLanguageTechnologyRequest.getId());

	}

	public boolean languageControl(LanguageTechnology languageTechnology) {
		for (GetAllLanguageTechnologiesResponse languageTechnology1 : getAll()) {
			if (languageTechnology.getName().equals(languageTechnology1.getName())) {
				return true;
			}
		}
		return false;
	}

	public boolean isEmpty(LanguageTechnology languageTechnology) {
		if (languageTechnology.getName().isBlank()) {
			return true;
		}
		return false;
	}

	public boolean idExists(int id) {
		for (GetAllLanguageTechnologiesResponse languageTechnology : getAll()) {
			if (languageTechnology.getId() == id) {
				return true;
			}
		}
		return false;

	}

}
