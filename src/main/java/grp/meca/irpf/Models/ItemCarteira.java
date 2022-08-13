package grp.meca.irpf.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity(name = "item_carteira")
public class ItemCarteira {
	
	public ItemCarteira() {}
	
	public ItemCarteira(ItemCarteira item, Carteira carteira) {
		this(item.getQuantidade(), item.getTicker(), item.getCustoTotal(), carteira);
	}
	
	public ItemCarteira(int quantidade, Ticker ticker, double custoTotal, Carteira carteira) {
		this.quantidade = quantidade;
		this.ticker = ticker;
		this.custoTotal = custoTotal;
		this.carteira = carteira;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private int quantidade;
	
	@OneToOne
	@JoinColumn(name = "ticker_id", nullable = false)
	private Ticker ticker;
	
	@Column(nullable = false)
	private double custoTotal;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "carteira_id", nullable = false)
	@JsonIgnore
	private Carteira carteira;
}
