package Kodlama.io.Devs.KodlamaIoDevs.business.responses.languageTechnologyResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLanguageTechnologiesResponse {

	private int id;
	private String name;
	private String programmingLanguage;
}
