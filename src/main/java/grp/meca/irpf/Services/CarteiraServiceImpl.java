package grp.meca.irpf.Services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grp.meca.irpf.Models.Carteira;
import grp.meca.irpf.Models.NotaDeCorretagem;
import grp.meca.irpf.Models.Ordem;
import grp.meca.irpf.Models.Ticker;
import grp.meca.irpf.Repository.CarteiraRepository;
import grp.meca.irpf.Repository.NotaDeCorretagemRepository;
import grp.meca.irpf.Repository.OrdemRepository;

@Service
public class CarteiraServiceImpl implements CarteiraService {

	@Autowired
	private CarteiraRepository carteiraRepository;
	
	@Autowired
	private NotaDeCorretagemRepository corretagemRepository;
	
	@Autowired
	private OrdemRepository ordemRepository;
	
	public List<Carteira> getCarteiras() {
		List<Carteira> carteiras = new ArrayList<>();
		List<NotaDeCorretagem> corretagens = corretagemRepository.findAllByOrderByDataAsc();
		corretagens.forEach(nc -> nc.setOrdens(ordemRepository.findByNotaDeCorretagem(nc)));
		for(NotaDeCorretagem corretagem: corretagens) {
			LocalDate data = corretagem.getData();
			Carteira carteira = carteiraRepository.save(new Carteira(data));
			for(Ordem ordem: corretagem.getOrdens()) {
				Ticker ticker = ordem.getTicker();
				int quantidade = ordem.getQuantidade();
				double custoTotal = quantidade*ordem.getPreco() + corretagem.getTaxaDaOrdem(ordem);
			}
		}
		return carteiras;
	}
}
