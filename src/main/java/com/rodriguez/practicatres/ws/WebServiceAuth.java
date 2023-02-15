
package com.rodriguez.practicatres.ws;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import com.rodriguez.practicatres.dto.ClienteDto;
import com.rodriguez.practicatres.dto.CompaniaDto;
import com.rodriguez.practicatres.dto.CompaniaSeguroDto;
import com.rodriguez.practicatres.dto.PeritoDto;
import com.rodriguez.practicatres.dto.SeguroDto;
import com.rodriguez.practicatres.dto.SiniestroDto;
import com.rodriguez.practicatres.entity.Cliente;
import com.rodriguez.practicatres.entity.Compania;
import com.rodriguez.practicatres.entity.CompaniaSeguro;
import com.rodriguez.practicatres.entity.Perito;
import com.rodriguez.practicatres.entity.Seguro;
import com.rodriguez.practicatres.entity.Siniestro;
import com.rodriguez.practicatres.repository.ClienteRepository;
import com.rodriguez.practicatres.repository.CompaniaRepository;
import com.rodriguez.practicatres.repository.CompaniaSeguroRepository;
import com.rodriguez.practicatres.repository.PeritoRepository;
import com.rodriguez.practicatres.repository.SeguroRepository;
import com.rodriguez.practicatres.repository.SiniestroRepository;
import com.rodriguez.practicatres.repository.UserLoginRepository;
import com.rodriguez.practicatres.wsint.IWebServiceAuth;

@Component
public class WebServiceAuth implements IWebServiceAuth {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	CompaniaRepository companiaRepository;
	
	@Autowired
	CompaniaSeguroRepository companiaSeguroRepository;
	
	@Autowired
	PeritoRepository peritoRepository;
	
	@Autowired
	SeguroRepository seguroRepository;
	
	@Autowired
	SiniestroRepository siniestroRepository;
	
	@Autowired
	UserLoginRepository userLoginRepository;
	
	
	
	@Override
	public Cliente getCliente(String clienteId) {
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		if( cliente.isPresent() ) {
			return cliente.get();
		}
		return null;
	}
	
	@Override
	public List<Cliente> getClientes() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente postCliente( ClienteDto clienteDto) {
		Cliente clienteDb = new Cliente();
		clienteDb.setApellido1(clienteDto.getApellido1());
		clienteDb.setApellido2(clienteDto.getApellido2());
		clienteDb.setCiudad(clienteDto.getCiudad());
		clienteDb.setClaseVia(clienteDto.getClaseVia());
		clienteDb.setCodigoPostal(clienteDto.getCodigoPostal());
		clienteDb.setDniCl(clienteDto.getDniCl());
		clienteDb.setNombreCl(clienteDto.getNombreCl());
		clienteDb.setNombreVia(clienteDto.getNombreVia());
		clienteDb.setNumeroVia(clienteDto.getNumeroVia());
		clienteDb.setOberservaciones(clienteDto.getOberservaciones());
		clienteDb.setTelefono(clienteDto.getTelefono());
		return clienteRepository.save(clienteDb);
	}

	@Override
	public void deleteCliente(String clienteId) {
		clienteRepository.deleteById(clienteId);
	}

	@Override
	public Compania getCompania(String companiaId) {
		Optional<Compania> compania = companiaRepository.findById(companiaId);
		if( compania.isPresent() ) {
			return compania.get();
		}
		return null;
	}

	@Override
	public void deleteCompania(String companiaId) {
		companiaRepository.deleteById(companiaId);
	}

	@Override
	public Compania postCompania(CompaniaDto companiaDto) {
		Compania compania = new Compania();
		compania.setClaseVia(companiaDto.getClaseVia());
		compania.setCodigoPostal(companiaDto.getCodigoPostal());
		compania.setNombreCompania(companiaDto.getNombreCompania());
		compania.setNombreVia(companiaDto.getNombreVia());
		compania.setNotas(companiaDto.getNotas());
		compania.setNumeroVia(companiaDto.getNumeroVia());
		compania.setTelefonoContratacion(companiaDto.getTelefonoContratacion());
		compania.setTelefonoSiniestro(companiaDto.getTelefonoSiniestro());
		return companiaRepository.save(compania);
	}

	@Override
	public List<Compania> getCompanias() {
		return companiaRepository.findAll();
	}

	@Override
	public Perito getPerito(String peritoId) {
		Optional<Perito> perito = peritoRepository.findById(peritoId);
		if( perito.isPresent() ) {
			return perito.get();
		}
		return null;
	}

	@Override
	public void deletePerito(String peritoId) {
		peritoRepository.deleteById(peritoId);
	}

	@Override
	public Perito postPerito(PeritoDto peritoDto) {
		Perito perito = new Perito();
		perito.setApellidoPerito1( peritoDto.getApellidoPerito1() );
		perito.setApellidoPerito2( peritoDto.getApellidoPerito2() );
		perito.setCalleVia( peritoDto.getCalleVia() );
		perito.setCiudad(  peritoDto.getCiudad() );
		perito.setCodigoPostal(  peritoDto.getCodigoPostal() );
		perito.setDniPerito(  peritoDto.getDniPerito() );
		perito.setNombrePerito(  peritoDto.getNombrePerito() );
		perito.setNombreVia( peritoDto.getNombreVia());
		perito.setNumeroVia( peritoDto.getNumeroVia());
		perito.setTelefonoContacto( peritoDto.getTelefonoContacto());
		perito.setTelefonoOficina( peritoDto.getTelefonoOficina());
		return peritoRepository.save(perito);
	}

	@Override
	public List<Perito> getPeritos() {
		return peritoRepository.findAll();
	}

	@Override
	public Seguro getSeguro(Long seguroId) {
		Optional<Seguro> seguro = seguroRepository.findById(seguroId);
		if( seguro.isPresent() ) {
			return seguro.get();
		}
		return null;
	}

	@Override
	public void deleteSeguro(Long seguroId) {
		seguroRepository.deleteById(seguroId);
	}

	@Override
	public Seguro postSeguro(SeguroDto seguroDto) {
		Seguro seguro = new Seguro();
		seguro.setCondicionesParticulares(seguroDto.getCondicionesParticulares());
		seguro.setDniCl(seguroDto.getDniCl());
		seguro.setFechaInicio(seguroDto.getFechaInicio());
		seguro.setFechaVencimiento(seguroDto.getFechaVencimiento());
		seguro.setNumeroPoliza(seguroDto.getNumeroPoliza());
		seguro.setObservaciones(seguroDto.getObservaciones());
		seguro.setRamo(seguroDto.getRamo());
		return seguroRepository.save(seguro);
	}

	@Override
	public List<Seguro> getSeguros() {
		return seguroRepository.findAll();
	}

	@Override
	public Siniestro getSiniestro(Long siniestroId) {
		Optional<Siniestro> siniestro = siniestroRepository.findById(siniestroId);
		if( siniestro.isPresent() ) {
			return siniestro.get();
		}
		return null;
	}

	@Override
	public void deleteSiniestro(Long siniestroId) {
		siniestroRepository.deleteById(siniestroId);
	}

	@Override
	public Siniestro postSiniestro(SiniestroDto siniestroDto) {
		Siniestro siniestro = new Siniestro();
		siniestro.setAceptado( siniestroDto.getAceptado() );
		siniestro.setCausas( siniestroDto.getCausas());
		siniestro.setFechaSiniestro( siniestroDto.getFechaSiniestro());
		siniestro.setIdSiniestro( siniestroDto.getIdSiniestro() );
		siniestro.setIndemnizacion( siniestroDto.getIndemnizacion() );
		
		Perito perito = new Perito();
		perito.setDniPerito( siniestroDto.getPeritoDto().getDniPerito() );
		siniestro.setPerito( perito );
		
		Seguro seguro = new Seguro();
		seguro.setNumeroPoliza( siniestroDto.getSeguroDto().getNumeroPoliza() );
		seguro.setDniCl( siniestroDto.getSeguroDto().getDniCl() );
		
		siniestro.setSeguro( seguro );
		
		return siniestroRepository.save(siniestro);
	}

	@Override
	public List<Siniestro> getSiniestros() {
		return siniestroRepository.findAll();
	}

	

	
	
	
	
	
	@Override
	public CompaniaSeguro getCompaniaSeguro(Long companiaSeguroId) {
		Optional<CompaniaSeguro> companiaSeguro = companiaSeguroRepository.findById(companiaSeguroId);
		if( companiaSeguro.isPresent() ) {
			return companiaSeguro.get();
		}
		return null;
	}
	
	@Override
	public void deleteCompaniaSeguro(Long companiaSeguroId) {
		companiaSeguroRepository.deleteById(companiaSeguroId);
	}
	
	@Override
	public CompaniaSeguro postCompaniaSeguro(CompaniaSeguroDto companiaSeguroDto) {
		
		CompaniaSeguro companiaSeguro = new CompaniaSeguro();
		
		if( companiaSeguroDto.getId() != null ) {
			companiaSeguro.setId( companiaSeguroDto.getId() );
		}
		
		Compania compania = new Compania();
		compania.setNombreCompania( companiaSeguroDto.getCompaniaDto().getNombreCompania() );
		companiaSeguro.setCompania( compania );
		
		Seguro seguro = new Seguro();
		seguro.setNumeroPoliza( companiaSeguroDto.getSeguroDto().getNumeroPoliza() );
		seguro.setDniCl(companiaSeguroDto.getSeguroDto().getDniCl() );
		companiaSeguro.setSeguro( seguro );
		
		return companiaSeguroRepository.save(companiaSeguro);
	}
	
	@Override
	public List<CompaniaSeguro> getCompaniaSeguros() {
		return companiaSeguroRepository.findAll();
	}

	@Override
	public List<Cliente> getClientesPorNombre(String nombreCliente) {
		return clienteRepository.findByNombreClContaining(nombreCliente);
	}

	@Override
	public List<Cliente> getClientesPorApellido(String apellidoCliente) {
		return clienteRepository.findByApellido1IgnoreCase(apellidoCliente);
	}

	@Override
	public List<Cliente> getClientesPorCiudad(String ciudadCliente) {
		return clienteRepository.findByCiudadNot(ciudadCliente);
	}
	
	

	@Override
	public List<Perito> getPeritosPorCiudad(String ciudadPerito) {
		return peritoRepository.findByCiudadLike(ciudadPerito);
	}

	@Override
	public List<Perito> getPeritosPorCodigoPostal(String codigoPostalPerito) {
		return peritoRepository.findByCodigoPostalEquals(codigoPostalPerito);
	}
	
	

	@Override
	public List<Seguro> getSegurosPorFechaVencimientoQueComiencePor(String fechavencimiento) {
		return seguroRepository.findByFechaVencimientoStartingWith(fechavencimiento);
	}

	@Override
	public List<Seguro> getSegurosPorCondicionesParticulares(String condiciones) {
		return seguroRepository.findByCondicionesParticulares(condiciones);
	}

	@Override
	public List<Seguro> getSegurosPorObservacionesQueContengan(String observaciones) {
		return seguroRepository.findByObservacionesContaining(observaciones);
	}
	
	

	@Override
	public List<Siniestro> getSiniestrosPorFecha(String fecha) {
		return siniestroRepository.findByFechaSiniestroStartingWith(fecha);
	}

	@Override
	public List<Siniestro> getSiniestrosPorCausa(String causa) {
		return siniestroRepository.findByCausasEquals(causa);
	}

	@Override
	public List<Siniestro> getSiniestrosPorIndemnizacion( Double indemnizacion) {
		return siniestroRepository.findByIndemnizacionLessThanEqual( indemnizacion );
	}
	
	@Override
	public Page<Seguro> getSegurosPorPagina( @PathVariable int pagina, @PathVariable int cantidad ){
		Pageable paginador = PageRequest.of( pagina, cantidad );
		return seguroRepository.traerPorPagina(paginador);
	}
	
	@Override
	public Page<Siniestro> getSiniestrosPorPagina( @PathVariable int pagina, @PathVariable int cantidad ){
		Pageable paginador = PageRequest.of( pagina, cantidad );
		return siniestroRepository.traerPorPagina(paginador);
	}
	@Override
	public Page<Perito> getPeritosPorPagina( @PathVariable int pagina, @PathVariable int cantidad ){
		Pageable paginador = PageRequest.of( pagina, cantidad );
		return peritoRepository.findAll( paginador );
	}

	@Override
	public Page<Cliente> getClientesPorPagina(int pagina, int cantidad) {
		Pageable paginador = PageRequest.of( pagina, cantidad );
		return clienteRepository.findAll( paginador );
	}

	
}
