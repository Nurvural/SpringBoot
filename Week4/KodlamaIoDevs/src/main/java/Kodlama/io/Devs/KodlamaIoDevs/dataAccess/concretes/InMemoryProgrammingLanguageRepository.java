package Kodlama.io.Devs.KodlamaIoDevs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.KodlamaIoDevs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.KodlamaIoDevs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {

	List<ProgrammingLanguage> languages;

	public InMemoryProgrammingLanguageRepository() {

		languages = new ArrayList<ProgrammingLanguage>();

		languages.add(new ProgrammingLanguage(0, "java"));
		languages.add(new ProgrammingLanguage(1, "C#"));
		languages.add(new ProgrammingLanguage(2, "php"));
		languages.add(new ProgrammingLanguage(3, "Python"));
	}

	@Override
	public List<ProgrammingLanguage> getAll() { // içinde ProgrammingLanguage bulunan listeler döndürcem demek

		return languages;
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		for (ProgrammingLanguage ProgrammingLanguage : languages) {
			if (ProgrammingLanguage.getId() == id) {
				return ProgrammingLanguage;
			}
		}
		return (ProgrammingLanguage) languages;
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		languages.add(programmingLanguage);

	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage, int id) {

		ProgrammingLanguage programmingLanguage2 = getById(id);
		programmingLanguage2.setName(programmingLanguage.getName());

	}

	@Override
	public void delete(int id) {
		ProgrammingLanguage deleteId = getById(id);
		if (deleteId != null) {
			languages.remove(id);

		}

	}

}
