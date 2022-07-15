package grp.meca.irpf.Models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity(name = "carteira")
public class Carteira implements Comparable<Carteira> {

	public Carteira() {}
	
	public Carteira(LocalDate data) {
		this.data = data;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private LocalDate data;
	
	@Transient
	private double custoTotal;
	
	@Transient
	private List<ItemCarteira> itens;

	public String toString() {
		return data + " " + (itens == null ? "null" : itens.size());
	}
	
	@Override
	public int compareTo(Carteira c) {
		return this.data.compareTo(c.getData());
	}
}
