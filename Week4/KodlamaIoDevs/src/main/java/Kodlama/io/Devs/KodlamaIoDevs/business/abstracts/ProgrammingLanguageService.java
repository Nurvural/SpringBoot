package Kodlama.io.Devs.KodlamaIoDevs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.KodlamaIoDevs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	// is kuralları
	List<ProgrammingLanguage> getAll();

	ProgrammingLanguage getById(int id);

	void add(ProgrammingLanguage programmingLanguage) throws Exception;

	void delete(int id) throws Exception;

	void update(ProgrammingLanguage programmingLanguage, int id) throws Exception;
}
