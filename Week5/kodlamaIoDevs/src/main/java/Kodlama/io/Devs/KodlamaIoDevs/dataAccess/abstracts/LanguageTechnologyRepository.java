package Kodlama.io.Devs.KodlamaIoDevs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.Devs.KodlamaIoDevs.entities.concretes.LanguageTechnology;

public interface LanguageTechnologyRepository extends JpaRepository<LanguageTechnology, Integer> {

}
