package Kodlama.io.Devs.KodlamaIoDevs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.KodlamaIoDevs.business.requests.programmingLanguageRequests.CreateProgrammingLanguageRequest;
import Kodlama.io.Devs.KodlamaIoDevs.business.requests.programmingLanguageRequests.DeleteProgrammingLanguageRequest;
import Kodlama.io.Devs.KodlamaIoDevs.business.requests.programmingLanguageRequests.UpdateProgrammingLanguageRequest;
import Kodlama.io.Devs.KodlamaIoDevs.business.responses.programmingLanguageResponses.GetAllProgrammingLanguagesResponse;

public interface ProgrammingLanguageService {
	// is kuralları
	List<GetAllProgrammingLanguagesResponse> getAll();

	GetAllProgrammingLanguagesResponse getById(int id) throws Exception;

	void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;

	void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) throws Exception;

	void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest, int id) throws Exception;
}
