package grp.meca.irpf.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import grp.meca.irpf.Models.Carteira;

@Service
public interface CarteiraService {
	public List<Carteira> getCarteiras();
}
