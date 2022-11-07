package Kodlama.io.Devs.KodlamaIoDevs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.KodlamaIoDevs.business.abstracts.LanguageTechnologyService;
import Kodlama.io.Devs.KodlamaIoDevs.business.requests.languageTechnologyRequests.CreateLanguageTechnologyRequest;
import Kodlama.io.Devs.KodlamaIoDevs.business.requests.languageTechnologyRequests.DeleteLanguageTechnologyRequest;
import Kodlama.io.Devs.KodlamaIoDevs.business.requests.languageTechnologyRequests.UpdateLanguageTechnologyRequest;
import Kodlama.io.Devs.KodlamaIoDevs.business.responses.languageTechnologyResponses.GetAllLanguageTechnologiesResponse;

@RestController
@RequestMapping("/api/technologies")
public class LanguageTechnologyController {
	private LanguageTechnologyService languageTechnologyService;

	@Autowired
	public LanguageTechnologyController(LanguageTechnologyService languageTechnologyService) {
		super();
		this.languageTechnologyService = languageTechnologyService;
	}

	@GetMapping("/getallTechnologies")
	public List<GetAllLanguageTechnologiesResponse> getAll() {
		return languageTechnologyService.getAll();

	}

	@PostMapping("/addTechnology")
	void add(@RequestBody() CreateLanguageTechnologyRequest createLanguageTechnologyRequest) throws Exception {
		languageTechnologyService.add(createLanguageTechnologyRequest);
	}

	@DeleteMapping("/deleteTechnology")
	void delete(DeleteLanguageTechnologyRequest deleteLanguageTechnologyRequest) throws Exception {
		languageTechnologyService.delete(deleteLanguageTechnologyRequest);
	}

	@PutMapping("/update/")
	public void update(@RequestBody UpdateLanguageTechnologyRequest updateLanguageTechnologyRequest, int id) throws Exception {
		languageTechnologyService.update(updateLanguageTechnologyRequest, id);
	}
}
