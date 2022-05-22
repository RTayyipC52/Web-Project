package web.project.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KurumRegisterDto {
	private String email;
    private String password;
	private String kurumAd;
	private String kurumAciklama;
	private String adres;
	private String yetkiliAd;
	private String yetkiliSoyad;
	private String yetkiliTel;
}
