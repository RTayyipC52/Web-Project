package web.project.entities.concretes;

import java.util.List;

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
@Table(name = "kurum")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Kurum {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "kurum_id")
	private int kurumId;
	
	@Column(name = "kurum_ad")
	private String kurumAd;
	
	@Column(name = "kurum_aciklama")
	private String kurumAciklama;
	
	@Column(name = "adres")
	private String adres;
	
	@Column(name = "yetkili_ad")
	private String yetkiliAd;
	
	@Column(name = "yetkili_soyad")
	private String yetkiliSoyad;
	
	@Column(name = "yetkili_tel")
	private String yetkiliTel;
	
	@JsonIgnore
    @OneToMany(mappedBy = "kurum")
	private List<EtkinlikVeKurum> etkinlikvekurum;
}
