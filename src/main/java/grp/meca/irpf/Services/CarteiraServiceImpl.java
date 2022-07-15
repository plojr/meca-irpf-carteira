package grp.meca.irpf.Services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grp.meca.irpf.Models.Carteira;
import grp.meca.irpf.Models.ItemCarteira;
import grp.meca.irpf.Models.NotaDeCorretagem;
import grp.meca.irpf.Models.Ordem;
import grp.meca.irpf.Models.Ticker;
import grp.meca.irpf.Repository.NotaDeCorretagemRepository;
import grp.meca.irpf.Repository.OrdemRepository;
import grp.meca.irpf.Repository.TickerRepository;

@Service
public class CarteiraServiceImpl implements CarteiraService {
	
	@Autowired
	private SwingTradeService stService;
	
	@Autowired
	private NotaDeCorretagemRepository corretagemRepository;
	
	@Autowired
	private OrdemRepository ordemRepository;
	
	@Autowired
	private TickerRepository tickerRepository;

	@Override
	public List<Carteira> getCarteiras() {
		Map<Ticker, ItemCarteira> mapTickerItem = new TreeMap<>();
		List<NotaDeCorretagem> corretagens = corretagemRepository.findAllByOrderByDataAsc();
		List<Carteira> carteiras = new ArrayList<>();
		LocalDate dataAnterior = null;
		for(NotaDeCorretagem corretagem: corretagens) {
			corretagem.setOrdens(ordemRepository.findByNotaDeCorretagem(corretagem));
			if(corretagem.getData().equals(dataAnterior)) {
				stService.getOrdensSwingTrade(corretagem).forEach(ordem -> {
					movimentarItemNaCarteira(mapTickerItem, carteiras.get(carteiras.size()-1), ordem, corretagem.getTaxaDaOrdem(ordem));
				});
			}
			else {
				Carteira carteira = new Carteira(corretagem.getData());
				stService.getOrdensSwingTrade(corretagem).forEach(ordem -> {
					movimentarItemNaCarteira(mapTickerItem, carteira, ordem, corretagem.getTaxaDaOrdem(ordem));
				});
				carteira.setItens(new ArrayList<>());
				for(Entry<Ticker, ItemCarteira> entry: mapTickerItem.entrySet())
					carteira.getItens().add(new ItemCarteira(entry.getValue(), carteira));
				carteiras.add(carteira);
			}
			dataAnterior = corretagem.getData();
		}
		return carteiras;
	}

	private void movimentarItemNaCarteira(Map<Ticker, ItemCarteira> mapTickerItem, Carteira carteira, Ordem ordem, double taxasDaOrdem) {
		Ticker ticker = tickerRepository.findByCodigo(ordem.getTicker().getCodigo());
		if(ticker == null) ticker = tickerRepository.save(new Ticker(ordem.getTicker().getCodigo()));
		if(ordem.getTipo() == 'v') {
			double novoCusto = mapTickerItem.get(ticker).getCustoTotal() - 
							   ordem.getQuantidade()*(mapTickerItem.get(ticker).getCustoTotal()/mapTickerItem.get(ticker).getQuantidade()) + taxasDaOrdem;
			int novaQuantidade = mapTickerItem.get(ticker).getQuantidade() - ordem.getQuantidade();
			ItemCarteira item = mapTickerItem.get(ticker);
			item.setCustoTotal(novoCusto);
			item.setQuantidade(novaQuantidade);
		}
		else {
			if(mapTickerItem.containsKey(ticker)) { // Já existe o ticker no map
				double novoCusto = mapTickerItem.get(ticker).getCustoTotal() + 
						ordem.getQuantidade()*ordem.getPreco() + taxasDaOrdem;
				int novaQuantidade = mapTickerItem.get(ticker).getQuantidade() + ordem.getQuantidade();
				ItemCarteira item = mapTickerItem.get(ticker);
				item.setCustoTotal(novoCusto);
				item.setQuantidade(novaQuantidade);
			}
			else { // Ainda não existe o ticker na carteira
				ItemCarteira item = new ItemCarteira(ordem.getQuantidade(), ticker, taxasDaOrdem + ordem.getPreco()*ordem.getQuantidade(), carteira);
				mapTickerItem.put(ticker, item);
			}
		}
	}
	
}
