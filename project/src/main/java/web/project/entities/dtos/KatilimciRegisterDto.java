package web.project.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KatilimciRegisterDto {
	private String email;
    private String password;
	private String katilimci_ad;
	private String katilimci_soyad;
	private String telefon;
	private String universite;
	private String bolum;
	private String sinif;
	private String ogrenimdurumu;
}
