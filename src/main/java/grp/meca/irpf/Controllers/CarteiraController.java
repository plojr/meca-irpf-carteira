package grp.meca.irpf.Controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import grp.meca.irpf.Repository.CarteiraRepository;

@Controller
public class CarteiraController {
	
	@Autowired
	private CarteiraRepository carteiraRepository;
	
	@GetMapping("carteira")
	public String carteiraGet(Model model) {
		model.addAttribute("carteiras", carteiraRepository.findAllByOrderByDataAsc());
		return "carteira";
	}
	
	@PostMapping("carteira")
	public String carteiraPost(@RequestParam Map<String, String> parametros) {
		
		return "redirect:/carteira";
	}
}
