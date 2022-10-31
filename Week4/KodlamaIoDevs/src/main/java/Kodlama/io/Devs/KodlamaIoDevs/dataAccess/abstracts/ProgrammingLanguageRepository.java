package Kodlama.io.Devs.KodlamaIoDevs.dataAccess.abstracts;

import java.util.List;

import Kodlama.io.Devs.KodlamaIoDevs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository {

	List<ProgrammingLanguage> getAll(); // Lısteleme

	ProgrammingLanguage getById(int id);

	void add(ProgrammingLanguage programmingLanguage);

	void update(ProgrammingLanguage programmingLanguage, int id);

	void delete(int id);
}
