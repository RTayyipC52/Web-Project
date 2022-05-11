package web.project.entities.concretes;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "etkinlik_katilimci")
public class EtkinlikVeKatilimci {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "etkinlik_katilimci_id")
	private int etkinlik_katilimci_id;
		
	@ManyToOne()
    @JoinColumn(name = "etkinlik_id")
    private Etkinlik etkinlik;
		
	@ManyToOne()
    @JoinColumn(name = "katilimci_id")
    private Katilimci katilimci;
}
