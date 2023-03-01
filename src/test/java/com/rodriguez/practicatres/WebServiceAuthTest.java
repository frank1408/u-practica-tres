
package com.rodriguez.practicatres;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.rodriguez.practicatres.dto.ClienteDto;
import com.rodriguez.practicatres.dto.CompaniaDto;
import com.rodriguez.practicatres.dto.PeritoDto;
import com.rodriguez.practicatres.dto.SeguroDto;
import com.rodriguez.practicatres.dto.SiniestroDto;
import com.rodriguez.practicatres.entity.Cliente;
import com.rodriguez.practicatres.entity.Compania;
import com.rodriguez.practicatres.entity.Perito;
import com.rodriguez.practicatres.entity.Seguro;
import com.rodriguez.practicatres.entity.Siniestro;
import com.rodriguez.practicatres.ws.WebServiceAuth;

@SpringBootTest
class WebServiceAuthTest {

	private static final Log LOG = LogFactory.getLog(WebServiceAuthTest.class);

	@Autowired
	WebServiceAuth webServiceAuth;

	@Test
	void getClientesTest() {
		List<Cliente> clientes = webServiceAuth.getClientes();
		assertNotNull(clientes, "los clientes no existen");
	}

	@Test
	void postClienteTest() {
		try {
			ClienteDto clienteDto = new ClienteDto();
			clienteDto.setDniCl("1");
			clienteDto.setNombreCl("Jimena");
			clienteDto.setApellido1("Gomez");
			Cliente cliente = webServiceAuth.postCliente(clienteDto);
			assertNotNull(cliente);
			webServiceAuth.deleteCliente(clienteDto.getDniCl());
		} catch (Exception exception) {
			LOG.error(exception);
			fail("no se pudo guardar un Cliente");
		}
	}

	@Test
	void getCompaniasTest() {
		List<Compania> companias = webServiceAuth.getCompanias();
		assertNotNull(companias, "las companias no existen");
	}

	@Test
	void postCompaniaTest() {
		try {
			CompaniaDto companiaDto = new CompaniaDto();
			companiaDto.setNombreCompania("susa");
			companiaDto.setTelefonoContratacion("11221122");
			Compania compania = webServiceAuth.postCompania(companiaDto);
			assertNotNull(compania);
			webServiceAuth.deleteCompania(companiaDto.getNombreCompania());
		} catch (Exception exception) {
			LOG.error(exception);
			fail("no se pudo guardar compania");
		}
	}

	@Test
	void getPeritosTest() {
		List<Perito> peritos = webServiceAuth.getPeritos();
		assertNotNull(peritos, "peritos no existen");
	}
	
	@Test
	void postPeritoTest() {
		try {
			PeritoDto peritoDto = new PeritoDto();
			peritoDto.setDniPerito("1");
			peritoDto.setNombrePerito("Juan");
			peritoDto.setApellidoPerito1("Perez");
			peritoDto.setApellidoPerito2("Gomez");
			peritoDto.setCalleVia("lactea");
			peritoDto.setCiudad("Guatemala");
			
			Perito perito = webServiceAuth.postPerito(peritoDto);
			assertNotNull(perito);
			webServiceAuth.deletePerito(peritoDto.getDniPerito());
		} catch (Exception exception) {
			LOG.error(exception);
			fail("no se pudo guardar perito");
		}
	}

	@Test
	void getSegurosTest() {
		List<Seguro> seguros = webServiceAuth.getSeguros();
		assertNotNull(seguros, "seguros no existen");
	}

	@Test
	void postSeguroTest() {
		try {
			SeguroDto seguroDto = new SeguroDto();
			seguroDto.setRamo("incendio");
			seguroDto.setCondicionesParticulares("pago quincenal cuota");
			seguroDto.setFechaInicio(new Date());
			Seguro seguro = webServiceAuth.postSeguro(seguroDto);
			assertNotNull(seguro);
			webServiceAuth.deleteSeguro(seguro.getNumeroPoliza());
		} catch (Exception exception) {
			LOG.error(exception);
			fail("no se pudo guardar Seguro");
		}
	}

	@Test
	void getSiniestrosTest() {
		List<Siniestro> siniestros = webServiceAuth.getSiniestros();
		assertNotNull(siniestros, "siniestros no existen");
	}

	@Test
	void postSiniestroTest() {
		try {
			SiniestroDto siniestroDto = new SiniestroDto();
			siniestroDto.setCausas("velas encendidas");

			PeritoDto peritoDto = new PeritoDto();
			peritoDto.setDniPerito("1");
			peritoDto.setNombrePerito("Juan");
			peritoDto.setApellidoPerito1("Perez");
			Perito perito = webServiceAuth.postPerito(peritoDto);
			siniestroDto.setPeritoDto(peritoDto);

			SeguroDto seguroDto = new SeguroDto();
			seguroDto.setRamo("incendio");
			seguroDto.setFechaInicio(new Date());
			Seguro seguro = webServiceAuth.postSeguro(seguroDto);
			seguroDto.setNumeroPoliza(seguro.getNumeroPoliza());
			siniestroDto.setSeguroDto(seguroDto);

			Siniestro siniestro = webServiceAuth.postSiniestro(siniestroDto);
			assertNotNull(siniestro);
			
			webServiceAuth.deleteSiniestro(siniestro.getIdSiniestro());
			webServiceAuth.deletePerito(perito.getDniPerito());
			webServiceAuth.deleteSeguro(seguro.getNumeroPoliza());
			

		} catch (Exception exception) {
			LOG.error(exception);
			fail("no se pudo guardar siniestro");
		}
	}

}
