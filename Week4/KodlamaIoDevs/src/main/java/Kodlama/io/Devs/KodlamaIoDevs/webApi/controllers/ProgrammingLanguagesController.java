package Kodlama.io.Devs.KodlamaIoDevs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.KodlamaIoDevs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.KodlamaIoDevs.entities.concretes.ProgrammingLanguage;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/languages")
public class ProgrammingLanguagesController {
	private ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {

		this.programmingLanguageService = programmingLanguageService;
	}

	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageService.getAll();
	}

	@GetMapping("/getById/{id}")
	public ProgrammingLanguage getById(@PathVariable int id) {
		return programmingLanguageService.getById(id);
	}

	@PostMapping("/add")
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		programmingLanguageService.add(programmingLanguage);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id) throws Exception {
		programmingLanguageService.delete(id);
	}

	@PutMapping("/update/{id}")
	public void update(@PathVariable int id, @RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
		programmingLanguageService.update(programmingLanguage, id);
	}
}
