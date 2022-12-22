package cat.itacademy.barcelonactiva.fedoraeva.anna.s05.t01.n01.S05T01N01FedoraevaAnnaG.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import cat.itacademy.barcelonactiva.fedoraeva.anna.s05.t01.n01.S05T01N01FedoraevaAnnaG.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.fedoraeva.anna.s05.t01.n01.S05T01N01FedoraevaAnnaG.respository.SucursalRespository;
import cat.itacademy.barcelonactiva.fedoraeva.anna.s05.t01.n01.S05T01N01FedoraevaAnnaG.service.SucursalService;
import cat.itacademy.barcelonactiva.fedoraeva.anna.s05.t01.n01.S05T01N01FedoraevaAnnaG.sucursal.Sucursal;

@Controller
//@RequestMapping ("/sucursal")

public class SucursalController {
	
	@Autowired
	private SucursalService sucursalService;
	@Autowired
	private SucursalRespository sucursalRepository;

//
//	@PostMapping("/add")
//	public ResponseEntity<Sucursal> add(@RequestBody Sucursal sucursal) {
//		try {
//			Sucursal sucursalNew = sucursalRepository.save(new Sucursal(sucursal.getNomSucursal(), sucursal.getPaisSucursal()));
//			return new ResponseEntity<>(sucursalNew, HttpStatus.CREATED);
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	
	@GetMapping({"/sucursal/add"})
	public String mostrarFormularioDeAñadirSucursal (Model modelo) {
		Sucursal sucursal = new Sucursal();
		modelo.addAttribute("sucursal", sucursal);
		return "nuevo_sucursal";
	}
	
	@PostMapping({"/sucursal/save"})
	public String saveSucursal (@ModelAttribute ("sucursal") Sucursal sucursal) {
		sucursalService.addSucursal(sucursal);
		return "redirect:/sucursal/getAll";
	}
	
	@GetMapping({"/sucursal/update/{id}"})
	public String mostrarFormularioEdicion(@PathVariable int id, Model model) {
		model.addAttribute("Sucursal", sucursalService.getSucursalById(id));
		return "update";

	}

	@PostMapping({"/sucursal/{id}"})
	public String actualizarSucursal(@PathVariable int id, @ModelAttribute("sucursal") Sucursal sucursal, Model model) {
		Sucursal sucursalE = sucursalService.getSucursalById(id);
		sucursalE.setPk_SucursalID(sucursal.getPk_SucursalID());
		sucursalE.setNomSucursal(sucursal.getNomSucursal());
		sucursalE.setPaisSucursal(sucursal.getPaisSucursal());
		sucursalService.addSucursal(sucursalE);
		return "redirect:/sucursal/getAll";

	}
	
	@GetMapping({"/sucursal/delete/{id}"})
	public String deleteSucursal(@PathVariable int id) {
		sucursalService.deleteSucursal(id);
		return "redirect:/sucursal/getAll";
	}
	
	
//	@PutMapping("/{id}")
//	public ResponseEntity<Sucursal> update(@PathVariable("id") int id, @RequestBody Sucursal sucursal) {
//		Optional<Sucursal> sucursalData = sucursalRepository.findById(id);
//
//		if (sucursalData.isPresent()) {
//			Sucursal sucUp = sucursalData.get();
//			sucUp.setNomSucursal(sucursal.getNomSucursal());
//			sucUp.setPaisSucursal(sucursal.getPaisSucursal());
//			return new ResponseEntity<>(sucursalRepository.save(sucUp), HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
//	@GetMapping("/getAll")
//    public ResponseEntity<List<Sucursal>> listaSucursales(){
//
//        List<Sucursal> sucursales = sucursalService.getAllSucursales();
//        return new ResponseEntity<List<Sucursal>>(sucursales, HttpStatus.OK);
//    }

	@GetMapping({"/sucursal/getAll"})
	public String listarSucursales(Model modelo) {
		List<Sucursal> sucursales = sucursalService.getAllSucursales();
		
		List <SucursalDTO> sucursalesDTO = new ArrayList <SucursalDTO>();
		for (Sucursal sucursal: sucursales) {
			sucursalesDTO.add(new SucursalDTO (sucursal));
		}
		modelo.addAttribute("listaSucursales", sucursalesDTO);
		return "index";
	}
	
	@GetMapping({"/sucursal/getOne/{id}"})
	public String getSucursal(@PathVariable int id, Model model) {
		model.addAttribute("Sucursal", sucursalService.getSucursalById(id));
		return "index";
	}
	
	

//	 @GetMapping("/getOne/{id}")
//	    public ResponseEntity<Sucursal> torreById(@PathVariable("id") int id){
//
//	        if (!sucursalService.existsByIdSucursal(id))
//	            return new ResponseEntity("No existe el sucursal", HttpStatus.NOT_FOUND);
//
//	        Sucursal sucursal = sucursalService.getSucursal (id).get();
//	        return new ResponseEntity(sucursal, HttpStatus.OK);
//	    }

//	 @DeleteMapping("/delete/{id}")
//		public ResponseEntity<HttpStatus> deleteSucursal (@PathVariable("id") int id) {
//			try {
//				sucursalRepository.deleteById(id);
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			} catch (Exception e) {
//				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//			}
//		}
}
