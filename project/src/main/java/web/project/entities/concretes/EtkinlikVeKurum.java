package web.project.entities.concretes;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "etkinlik_kurum")
public class EtkinlikVeKurum {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "etkinlik_kurum_id")
	private int etkinlik_kurum_id;
		
	@ManyToOne()
    @JoinColumn(name = "etkinlik_id")
    private Etkinlik etkinlik;
	
	@ManyToOne()
    @JoinColumn(name = "kurum_id")
    private Kurum kurum;
}
