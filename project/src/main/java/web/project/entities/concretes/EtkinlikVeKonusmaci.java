package web.project.entities.concretes;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "etkinlik_konusmaci")
public class EtkinlikVeKonusmaci {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "etkinlik_konusmaci_id")
	private int etkinlikKonusmaciId;
		
	@ManyToOne()
    @JoinColumn(name = "etkinlik_id")
    private Etkinlik etkinlik;
		
	@ManyToOne()
    @JoinColumn(name = "konusmaci_id")
    private Konusmaci konusmaci;
}
