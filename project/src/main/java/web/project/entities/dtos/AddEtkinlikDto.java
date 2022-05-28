package web.project.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEtkinlikDto {
	private String etkinlikAd;
	private String etkinlikAciklama;
	private LocalDate tarih;
	private String yer;
    private int sertifikaImageId;
    private int kurumId;
}
