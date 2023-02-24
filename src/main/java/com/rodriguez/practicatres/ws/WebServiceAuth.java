
package com.rodriguez.practicatres.ws;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.rodriguez.practicatres.repository.ClienteRepository;
import com.rodriguez.practicatres.repository.CompaniaRepository;
import com.rodriguez.practicatres.repository.CompaniaSeguroRepository;
import com.rodriguez.practicatres.repository.PeritoRepository;
import com.rodriguez.practicatres.repository.SeguroRepository;
import com.rodriguez.practicatres.repository.SiniestroRepository;
import com.rodriguez.practicatres.repository.UserLoginRepository;
import com.rodriguez.practicatres.service.ServicioFuncionProcedimiento;
import com.rodriguez.practicatres.wsint.IWebServiceAuth;

@Component
public class WebServiceAuth implements IWebServiceAuth {
	
	private static final Log LOG = LogFactory.getLog(WebServiceAuth.class);
	
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
	
	@Autowired
	ServicioFuncionProcedimiento sfp;
	
	private static final ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Cliente getCliente(String clienteId) {
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		if( cliente.isPresent() ) {
			return cliente.get();
		}
		StringBuilder sb = new StringBuilder("NO existe cliente con id: ");
		sb.append( clienteId );
		LOG.warn( sb );
		return null;
	}
	
	@Override
	public List<Cliente> getClientes() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente postCliente( ClienteDto clienteDto) {
		return clienteRepository.save(modelMapper.map(clienteDto, Cliente.class));
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
		
		List<CompaniaSeguro> cs = companiaSeguroRepository.findAll();
		cs.forEach( css -> {
			
			if(css.getNombreCompania().equals( companiaId)   ) {
				companiaSeguroRepository.deleteById( css.getId() );
				seguroRepository.deleteById( css.getNumeroPoliza() );
			}
			
		});
		companiaRepository.deleteById(companiaId);
	}

	@Override
	public Compania postCompania(CompaniaDto companiaDto) {
		return companiaRepository.save(modelMapper.map(companiaDto, Compania.class));
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
		return peritoRepository.save(modelMapper.map(peritoDto, Perito.class));
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
		
		List<CompaniaSeguro> cs = companiaSeguroRepository.findAll();
		cs.forEach( css -> {
			
			if(Objects.equals(css.getNumeroPoliza(), seguroId) ) {
				companiaSeguroRepository.deleteById( css.getId() );
				companiaRepository.deleteById( css.getNombreCompania() );
			}
			
		});
		seguroRepository.deleteById(seguroId);
	}

	@Override
	public Seguro postSeguro(SeguroDto seguroDto) {
		return seguroRepository.save(modelMapper.map(seguroDto, Seguro.class));
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
		return companiaSeguroRepository.save(modelMapper.map(companiaSeguroDto, CompaniaSeguro.class));
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
	public List<Seguro> getSegurosPorFechaVencimientoAntesDe(String fechavencimiento) {
		Date fecha = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fecha = simpleDateFormat.parse(fechavencimiento);
		} catch (ParseException e) {
			LOG.warn(e);
		}
		return seguroRepository.findByFechaVencimientoBefore(fecha);
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



	
	
	
	
	
	@Override
	public FuncionDto ejecutarFuncion(String texto, int numero) {
		return sfp.funcionDb(texto, numero);
	}

	@Override
	public Funcion2Dto ejecutarFuncion2(BigDecimal numA, BigDecimal numB) {
		return sfp.funcionDb2(numA, numB);
	}
	
	@Override
	public ProcedimientoDto ejectuarProcedimiento(BigDecimal numA, BigDecimal numB) {
		return sfp.procedimientoDb( numA, numB );
	}
	
	
	
}
