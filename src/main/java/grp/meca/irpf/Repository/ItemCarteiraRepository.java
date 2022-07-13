package grp.meca.irpf.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import grp.meca.irpf.Models.Carteira;
import grp.meca.irpf.Models.ItemCarteira;

@Repository
public interface ItemCarteiraRepository extends JpaRepository<ItemCarteira, Integer> {
	
	public List<ItemCarteira> findByCarteira(Carteira carteira);
}
