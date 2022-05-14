package web.project.entities.concretes;

import java.util.Date;
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
@Table(name = "etkinlik")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Etkinlik {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "etkinlik_id")
	private int etkinlikId;
	
	@Column(name = "etkinlik_ad")
	private String etkinlikAd;
	
	@Column(name = "etkinlik_aciklama")
	private String etkinlikAciklama;
	
	@Column(name = "tarih")
	private Date tarih;
	
	@Column(name = "yer")
	private String yer;
	
	@OneToOne()
    @JoinColumn(name = "sertifika_id")
    private Sertifika sertifika;
	
	@JsonIgnore
	@OneToMany(mappedBy = "etkinlik")
	private List<EtkinlikVeKatilimci> etkinlikvekatilimci;
	
	@JsonIgnore
    @OneToMany(mappedBy = "etkinlik")
	private List<EtkinlikVeKonusmaci> etkinlikvekonusmaci;
	
	@JsonIgnore
    @OneToMany(mappedBy = "etkinlik")
	private List<EtkinlikVeKurum> etkinlikvekurum;
	
	@JsonIgnore
    @OneToOne(mappedBy = "etkinlik")
    private EtkinlikImage etkinlikImage;
}
