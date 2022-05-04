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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "katilimci")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Katilimci {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "ad")
	private String ad;
	
	@Column(name = "soyad")
	private String soyad;
	
	@Column(name = "telefon")
	private int telefon;
	
	@Column(name = "eposta")
	private String eposta;
	
	@Column(name = "universite")
	private String universite;
	
	@Column(name = "bolum")
	private String bolum;
	
	@Column(name = "sinif")
	private String sinif;
	
	@Column(name = "ogrenimdurumu")
	private String ogrenimdurumu;
	
	@JsonIgnore
    @OneToMany(mappedBy = "katilimci")
	private List<EtkinlikVeKatilimci> etkinlikvekatilimci;
}
