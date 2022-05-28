package web.project.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sertifika_image")
public class SertifikaImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sertifika_image_id")
	private int sertifikaImageId;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "public_image")
	private String publicImage;
	
	@OneToOne()
    @JoinColumn(name = "sertifika_id")
    private Sertifika sertifika;
	
	@JsonIgnore
    @OneToOne(mappedBy = "sertifikaImage")
    private Etkinlik etkinlik;
}
