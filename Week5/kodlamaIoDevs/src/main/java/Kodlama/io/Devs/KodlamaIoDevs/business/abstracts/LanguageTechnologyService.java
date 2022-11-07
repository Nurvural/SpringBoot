package Kodlama.io.Devs.KodlamaIoDevs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.KodlamaIoDevs.business.requests.languageTechnologyRequests.CreateLanguageTechnologyRequest;
import Kodlama.io.Devs.KodlamaIoDevs.business.requests.languageTechnologyRequests.DeleteLanguageTechnologyRequest;
import Kodlama.io.Devs.KodlamaIoDevs.business.requests.languageTechnologyRequests.UpdateLanguageTechnologyRequest;
import Kodlama.io.Devs.KodlamaIoDevs.business.responses.languageTechnologyResponses.GetAllLanguageTechnologiesResponse;

public interface LanguageTechnologyService {

	List<GetAllLanguageTechnologiesResponse> getAll();

	void add(CreateLanguageTechnologyRequest createLanguageTechnologyRequest) throws Exception;

	void delete(DeleteLanguageTechnologyRequest deleteLanguageTechnologyRequest) throws Exception;

	void update(UpdateLanguageTechnologyRequest updateLanguageTechnologyRequest, int id) throws Exception;
}
