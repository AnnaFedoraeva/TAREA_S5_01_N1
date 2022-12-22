package cat.itacademy.barcelonactiva.fedoraeva.anna.s05.t01.n01.S05T01N01FedoraevaAnnaG.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.fedoraeva.anna.s05.t01.n01.S05T01N01FedoraevaAnnaG.sucursal.Sucursal;

@Repository
public interface SucursalRespository extends JpaRepository<Sucursal, Integer> {
	
	
	 
}
