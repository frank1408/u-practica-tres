
package com.rodriguez.practicatres.wsint;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rodriguez.practicatres.dto.ClienteDto;
import com.rodriguez.practicatres.dto.CompaniaDto;
import com.rodriguez.practicatres.dto.CompaniaSeguroDto;
import com.rodriguez.practicatres.dto.Funcion2Dto;
import com.rodriguez.practicatres.dto.FuncionDto;
import com.rodriguez.practicatres.dto.PeritoDto;
import com.rodriguez.practicatres.dto.ProcedimientoDto;
import com.rodriguez.practicatres.dto.SeguroDto;
import com.rodriguez.practicatres.dto.SiniestroDto;
import com.rodriguez.practicatres.entity.Cliente;
import com.rodriguez.practicatres.entity.Compania;
import com.rodriguez.practicatres.entity.CompaniaSeguro;
import com.rodriguez.practicatres.entity.Perito;
import com.rodriguez.practicatres.entity.Seguro;
import com.rodriguez.practicatres.entity.Siniestro;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public interface IWebServiceAuth {

	@GetMapping("/cliente/consultar/{clienteId}")
	public Cliente getCliente(@PathVariable String clienteId);

	@DeleteMapping("/cliente/eliminar/{clienteId}")
	public void deleteCliente(@PathVariable String clienteId);

	@PostMapping("/cliente/guardar")
	public Cliente postCliente(@RequestBody ClienteDto clienteDto);

	@GetMapping("/cliente/consultar")
	public List<Cliente> getClientes();

	@GetMapping("/compania/consultar/{companiaId}")
	public Compania getCompania(@PathVariable String companiaId);

	@DeleteMapping("/compania/eliminar/{companiaId}")
	public void deleteCompania(@PathVariable String companiaId);

	@PostMapping("/compania/guardar")
	public Compania postCompania(@RequestBody CompaniaDto companiaDto);

	@GetMapping("/compania/consultar")
	public List<Compania> getCompanias();

	@GetMapping("/perito/consultar/{peritoId}")
	public Perito getPerito(@PathVariable String peritoId);

	@DeleteMapping("/perito/eliminar/{peritoId}")
	public void deletePerito(@PathVariable String peritoId);

	@PostMapping("/perito/guardar")
	public Perito postPerito(@RequestBody PeritoDto peritoDto);

	@GetMapping("/perito/consultar")
	public List<Perito> getPeritos();

	@GetMapping("/seguro/consultar/{seguroId}")
	public Seguro getSeguro(@PathVariable Long seguroId);

	@DeleteMapping("/seguro/eliminar/{seguroId}")
	public void deleteSeguro(@PathVariable Long seguroId);

	@PostMapping("/seguro/guardar")
	public Seguro postSeguro(@RequestBody SeguroDto seguroDto);

	@GetMapping("/seguro/consultar")
	public List<Seguro> getSeguros();

	@GetMapping("/siniestro/consultar/{siniestroId}")
	public Siniestro getSiniestro(@PathVariable Long siniestroId);

	@DeleteMapping("/siniestro/eliminar/{siniestroId}")
	public void deleteSiniestro(@PathVariable Long siniestroId);

	@PostMapping("/siniestro/guardar")
	public Siniestro postSiniestro(@RequestBody SiniestroDto siniestroDto);

	@GetMapping("/siniestro/consultar")
	public List<Siniestro> getSiniestros();

	@GetMapping("/companiaseguro/consultar/{companiaseguroId}")
	public CompaniaSeguro getCompaniaSeguro(@PathVariable Long companiaseguroId);

	@DeleteMapping("/companiaseguro/eliminar/{companiaSeguroId}")
	public void deleteCompaniaSeguro(@PathVariable Long companiaSeguroId);

	@PostMapping("/companiaseguro/guardar")
	public CompaniaSeguro postCompaniaSeguro(@RequestBody CompaniaSeguroDto companiaseguroDto);

	@GetMapping("/companiaseguro/consultar")
	public List<CompaniaSeguro> getCompaniaSeguros();

	@GetMapping("/siniestro/consultar/pag/{pagina}/{cantidad}")
	public Page<Siniestro> getSiniestrosPorPagina(@PathVariable int pagina, @PathVariable int cantidad);

	@GetMapping("/seguro/consultar/pag/{pagina}/{cantidad}")
	public Page<Seguro> getSegurosPorPagina(@PathVariable int pagina, @PathVariable int cantidad);

	@GetMapping("/perito/consultar/pag/{pagina}/{cantidad}")
	public Page<Perito> getPeritosPorPagina(@PathVariable int pagina, @PathVariable int cantidad);

	@GetMapping("/cliente/consultar/pag/{pagina}/{cantidad}")
	public Page<Cliente> getClientesPorPagina(@PathVariable int pagina, @PathVariable int cantidad);

	@GetMapping("/siniestro/consultar/fecha/{fecha}")
	public List<Siniestro> getSiniestrosPorFecha(@PathVariable String fecha);

	@GetMapping("/siniestro/consultar/causa/{causa}")
	public List<Siniestro> getSiniestrosPorCausa(@PathVariable String causa);

	@GetMapping("/siniestro/consultar/indemnizacion/{indemnizacion}")
	public List<Siniestro> getSiniestrosPorIndemnizacion(@PathVariable Double indemnizacion);

	@GetMapping("/seguro/consultar/fechavencimiento/{fechavencimiento}")
	public List<Seguro> getSegurosPorFechaVencimientoAntesDe(@PathVariable String fechavencimiento);

	@GetMapping("/seguro/consultar/condicionesparticulares/{condiciones}")
	public List<Seguro> getSegurosPorCondicionesParticulares(@PathVariable String condiciones);

	@GetMapping("/seguro/consultar/observaciones/{observaciones}")
	public List<Seguro> getSegurosPorObservacionesQueContengan(@PathVariable String observaciones);

	@GetMapping("/cliente/consultar/nombre/{nombreCliente}")
	public List<Cliente> getClientesPorNombre(@PathVariable String nombreCliente);

	@GetMapping("/cliente/consultar/apellido/{apellidoCliente}")
	public List<Cliente> getClientesPorApellido(@PathVariable String apellidoCliente);

	@GetMapping("/cliente/consultar/ciudad/{ciudadCliente}")
	public List<Cliente> getClientesPorCiudad(@PathVariable String ciudadCliente);

	@GetMapping("/perito/consultar/ciudad/{ciudadPerito}")
	public List<Perito> getPeritosPorCiudad(@PathVariable String ciudadPerito);

	@GetMapping("/perito/consultar/codigopostal/{codigoPostalPerito}")
	public List<Perito> getPeritosPorCodigoPostal(@PathVariable String codigoPostalPerito);
	

	
	
	
	@GetMapping("/funcion/{texto}/{numero}")
	public FuncionDto ejecutarFuncion(@PathVariable String texto, @PathVariable int numero );

	@GetMapping("/funcion2/{numA}/{numB}")
	public Funcion2Dto ejecutarFuncion2(@PathVariable BigDecimal numA, @PathVariable BigDecimal numB );
	
	@GetMapping("/procedimiento/{numA}/{numB}")
	public ProcedimientoDto ejectuarProcedimiento(@PathVariable BigDecimal numA, @PathVariable BigDecimal numB );
	
	
}
