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
	private int sertifika_id;
	
	@Column(name = "sertifika_ad")
	private String sertifika_ad;
	
	@Column(name = "sertifika_metni")
	private String sertifika_metni;
	
	@JsonIgnore
    @OneToOne(mappedBy = "sertifika")
    private Etkinlik etkinlik;
	
	@JsonIgnore
    @OneToOne(mappedBy = "sertifika")
    private SertifikaImage sertifikaImage;
}
