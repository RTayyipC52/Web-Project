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
@Table(name = "konusmaci")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Konusmaci {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "konusmaci_id")
	private int konusmaci_id;
	
	@Column(name = "konusmaci_ad")
	private String konusmaci_ad;
	
	@Column(name = "konusmaci_soyad")
	private String konusmaci_soyad;
	
	@JsonIgnore
    @OneToMany(mappedBy = "konusmaci")
	private List<EtkinlikVeKonusmaci> etkinlikvekonusmaci;
}
