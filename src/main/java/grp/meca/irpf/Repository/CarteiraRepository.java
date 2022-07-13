package grp.meca.irpf.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import grp.meca.irpf.Models.Carteira;

@Repository
public interface CarteiraRepository extends JpaRepository<Carteira, Integer> {
	public List<Carteira> findAllByOrderByDataAsc();
}
