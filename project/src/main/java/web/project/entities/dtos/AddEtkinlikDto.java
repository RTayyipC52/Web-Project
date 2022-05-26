package web.project.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEtkinlikDto {
	private String etkinlikAd;
	private String etkinlikAciklama;
	private Date tarih;
	private String yer;
    private int sertifikaImageId;
    private int kurumId;
}
