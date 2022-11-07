package Kodlama.io.Devs.KodlamaIoDevs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.KodlamaIoDevs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.KodlamaIoDevs.business.requests.programmingLanguageRequests.CreateProgrammingLanguageRequest;
import Kodlama.io.Devs.KodlamaIoDevs.business.requests.programmingLanguageRequests.DeleteProgrammingLanguageRequest;
import Kodlama.io.Devs.KodlamaIoDevs.business.requests.programmingLanguageRequests.UpdateProgrammingLanguageRequest;
import Kodlama.io.Devs.KodlamaIoDevs.business.responses.programmingLanguageResponses.GetAllProgrammingLanguagesResponse;

@RestController
@RequestMapping("/api/languages")
public class ProgrammingLanguagesController {
	private ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {

		this.programmingLanguageService = programmingLanguageService;
	}

	@GetMapping("/getall")
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		return programmingLanguageService.getAll();
	}

	@GetMapping("/getById/{id}")
	public GetAllProgrammingLanguagesResponse getById(@PathVariable int id) throws Exception {
		return programmingLanguageService.getById(id);
	}

	@PostMapping("/add")
	public void add(@RequestBody() CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		programmingLanguageService.add(createProgrammingLanguageRequest);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) throws Exception {
		programmingLanguageService.delete(deleteProgrammingLanguageRequest);
	}

	@PutMapping("/update/")
	public void update(@RequestBody UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest, int id) throws Exception {
		programmingLanguageService.update(updateProgrammingLanguageRequest, id);
	}

}
