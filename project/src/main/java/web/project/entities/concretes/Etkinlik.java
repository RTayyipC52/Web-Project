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
	@Column(name = "id")
	private int id;
	
	@Column(name = "ad")
	private String ad;
	
	@Column(name = "aciklama")
	private String aciklama;
	
	@Column(name = "tarih")
	private Date tarih;
	
	@Column(name = "yer")
	private String yer;
	
	@Column(name = "afis_resmi")
	private String afis_resmi;
	
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
}
