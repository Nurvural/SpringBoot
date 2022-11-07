package Kodlama.io.Devs.KodlamaIoDevs.business.requests.languageTechnologyRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLanguageTechnologyRequest {
	private String name;
	private int languageId;
}
