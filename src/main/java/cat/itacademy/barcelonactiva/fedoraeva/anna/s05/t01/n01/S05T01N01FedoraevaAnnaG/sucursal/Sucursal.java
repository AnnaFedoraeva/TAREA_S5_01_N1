package cat.itacademy.barcelonactiva.fedoraeva.anna.s05.t01.n01.S05T01N01FedoraevaAnnaG.sucursal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name = "sucursal")

public class Sucursal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pk_SucursalID;
	
	@Column (name= "nombre de sucursal", nullable = false, length = 50, unique = true)
	private String nomSucursal;
	
	@Column (name= "pais", nullable = false, length = 50)
	private String paisSucursal;
	
	public Sucursal () {
	}

	public Sucursal(String nomSucursal, String paisSucursal) {
		super();
		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSucursal;
	}

	public Integer getPk_SucursalID() {
		return pk_SucursalID;
	}

	public void setPk_SucursalID(Integer pk_SucursalID) {
		this.pk_SucursalID = pk_SucursalID;
	}

	public String getNomSucursal() {
		return nomSucursal;
	}

	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}

	public String getPaisSucursal() {
		return paisSucursal;
	}

	public void setPaisSucursal(String paisSucursal) {
		this.paisSucursal = paisSucursal;
	}

	@Override
	public String toString() {
		return "Sucursal [pk_SucursalID=" + pk_SucursalID + ", nomSucursal=" + nomSucursal + ", paisSucursal="
				+ paisSucursal + "]";
	}
	
	
	
}
