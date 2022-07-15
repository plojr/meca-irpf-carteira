package grp.meca.irpf.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import grp.meca.irpf.Models.Carteira;
import grp.meca.irpf.Models.ItemCarteira;
import grp.meca.irpf.Repository.CarteiraRepository;
import grp.meca.irpf.Repository.ItemCarteiraRepository;
import grp.meca.irpf.Services.CarteiraServiceImpl;

@Controller
public class CarteiraController {

	@Autowired
	private CarteiraRepository carteiraRepository;

	@Autowired
	private ItemCarteiraRepository itemCarteiraRepository;
	
	@Autowired
	private CarteiraServiceImpl carteiraService;
	
	@GetMapping("carteira")
	public String carteiraGet(Model model) {
		List<Carteira> carteiras = carteiraRepository.findAllByOrderByDataAsc();
		carteiras.forEach(carteira -> {
			List<ItemCarteira> itens = itemCarteiraRepository.findByCarteira(carteira);
			carteira.setItens(itens.stream().filter(item -> item.getQuantidade() != 0).toList());
			carteira.setCustoTotal(0);
			carteira.getItens().forEach(item -> {
				carteira.setCustoTotal(carteira.getCustoTotal() + item.getCustoTotal());
			});
		});
		model.addAttribute("carteiras", carteiras);
		return "carteira";
	}
	
	@PostMapping("carteira")
	public String carteiraPost() {
		carteiraRepository.deleteAll();
		List<Carteira> carteiras = carteiraService.getCarteiras();
		for(Carteira carteira: carteiras) {
			carteira = carteiraRepository.save(carteira);
			List<ItemCarteira> itens = carteira.getItens();
			for(ItemCarteira item: itens) {
				item.setCarteira(carteira);
				itemCarteiraRepository.save(item);
			}
		}
		return "redirect:/carteira";
	}
}
