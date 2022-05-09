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
	@Column(name = "id")
	private int id;
	
	@Column(name = "ad")
	private String ad;
	
	@Column(name = "aciklama")
	private String aciklama;
	
	@Column(name = "adres")
	private String adres;
	
	@Column(name = "yetkili_ad")
	private String yetkili_ad;
	
	@Column(name = "yetkili_soyad")
	private String yetkili_soyad;
	
	@Column(name = "yetkili_tel")
	private String yetkili_tel;
	
	@JsonIgnore
    @OneToMany(mappedBy = "kurum")
	private List<EtkinlikVeKurum> etkinlikvekurum;
}
