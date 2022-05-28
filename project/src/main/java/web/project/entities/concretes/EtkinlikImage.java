package web.project.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "etkinlik_image")
public class EtkinlikImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "etkinlik_image_id")
	private int etkinlikImageId;
	
	@Column(name = "afis_resmi")
	private String afis_resmi;
	
	@Column(name = "afis_image")
	private String afisImage;
	
	@OneToOne()
    @JoinColumn(name = "etkinlik_id")
    private Etkinlik etkinlik;
}
