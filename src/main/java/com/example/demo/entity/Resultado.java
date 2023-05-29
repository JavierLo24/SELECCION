package com.example.demo.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Resultado {

	@Id
	@SequenceGenerator(name="resultado_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="resultado_id_seq")
	private Integer id;
	@ManyToOne
	@JoinColumn(name="partido_id", nullable=true)
	private Partido partido_id;
	@ManyToOne
	@JoinColumn(name="seleccion_id", nullable=true)
	private Seleccion seleccion_id;
	private Integer goles;
	private Integer amarillas;
	private Integer rojas;
}
