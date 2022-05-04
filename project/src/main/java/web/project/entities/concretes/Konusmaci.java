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
	@Column(name = "id")
	private int id;
	
	@Column(name = "ad")
	private String ad;
	
	@Column(name = "soyad")
	private String soyad;
	
	@JsonIgnore
    @OneToMany(mappedBy = "konusmaci")
	private List<EtkinlikVeKonusmaci> etkinlikvekonusmaci;
}
