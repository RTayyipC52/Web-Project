package web.project.entities.concretes;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sertifika")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Sertifika {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sertifika_id")
	private int sertifikaId;
	
	@Column(name = "sertifika_ad")
	private String sertifikaAd;
	
	@Column(name = "sertifika_metni")
	private String sertifikaMetni;
	
	/*@JsonIgnore
    @OneToOne(mappedBy = "sertifika")
    private Etkinlik etkinlik;*/
	
	@JsonIgnore
    @OneToOne(mappedBy = "sertifika")
    private SertifikaImage sertifikaImage;
}
