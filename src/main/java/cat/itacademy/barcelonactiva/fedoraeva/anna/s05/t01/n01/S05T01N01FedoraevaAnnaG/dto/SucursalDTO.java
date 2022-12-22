package cat.itacademy.barcelonactiva.fedoraeva.anna.s05.t01.n01.S05T01N01FedoraevaAnnaG.dto;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cat.itacademy.barcelonactiva.fedoraeva.anna.s05.t01.n01.S05T01N01FedoraevaAnnaG.sucursal.Sucursal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor

public class SucursalDTO  {

	private Integer pk_SucursalID;
	private String nomSucursal;
	private String paisSucursal;
	private String tipusSucursal;
	static private List<String> paises = new ArrayList<String>(Arrays.asList("austria", "belgium", "bulgaria",
			"croatia", "republic of Cyprus", "czech republic", "denmark", "estonia", "finland", "france", "germany",
			"greece", "hungary", "ireland", "italy", "latvia", "lithuania", "luxembourg", "malta", "netherlands",
			"poland", "portugal", "romania", "slovakia", "slovenia", "spain", "sweden"));

	public SucursalDTO(String nomSucursal, String paisSucursal, Integer pk_SucursalID) {
		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSucursal;
		this.pk_SucursalID = pk_SucursalID;
		String mensaje;
		if (paises.contains(paisSucursal.toLowerCase())) {
			mensaje = "EU";
		} else {
			mensaje = "No es pais de EU";
		}
		setTipusSucursal(mensaje);
	}

	public SucursalDTO (Sucursal sucursal) {
		this.nomSucursal = sucursal.getNomSucursal();
		this.paisSucursal = sucursal.getPaisSucursal();
		this.pk_SucursalID = sucursal.getPk_SucursalID();
		String mensaje;
		if (paises.contains(paisSucursal.toLowerCase())) {
			mensaje = "EU";
		} else {
			mensaje = "No es pais de EU";
		}
		setTipusSucursal(mensaje);
	}
	}

