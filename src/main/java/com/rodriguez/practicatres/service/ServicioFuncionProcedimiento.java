
package com.rodriguez.practicatres.service;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import com.rodriguez.practicatres.dto.Funcion2Dto;
import com.rodriguez.practicatres.dto.FuncionDto;
import com.rodriguez.practicatres.dto.ProcedimientoDto;

@Service
public class ServicioFuncionProcedimiento {
	
	private static final String SCHEMANAME = "seguni";
	private static final String CATALOGNAME = "mipack";

	private static final String KEY_TEXTO = "texto";
	private static final String KEY_NUMERO = "numero";
	private static final String KEY_SALIDA = "salida";
	private static final String KEY_RETORNO = "retorno";

	private static final String KEY_NUMA = "numA";
	private static final String KEY_NUMB = "numB";
	private static final String KEY_ESTATUS = "estatus";

	@Autowired
	NamedParameterJdbcTemplate npjt;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public ProcedimientoDto procedimientoDb(BigDecimal numA, BigDecimal numB) {
		
		ProcedimientoDto sfd = new ProcedimientoDto();
		SimpleJdbcCall sjc = new SimpleJdbcCall(jdbcTemplate);

		sjc.withSchemaName(SCHEMANAME)
		.withCatalogName(CATALOGNAME)
		.withProcedureName("procedimientoy")
		.withoutProcedureColumnMetaDataAccess()
		.declareParameters(
				new SqlInOutParameter(KEY_NUMA, Types.NUMERIC ),
				new SqlParameter(KEY_NUMB, Types.NUMERIC),
				new SqlOutParameter(KEY_ESTATUS, Types.VARCHAR)
		);
		

		SqlParameterSource sps = new MapSqlParameterSource()
				.addValue(KEY_NUMA, numA)
				.addValue(KEY_NUMB, numB);

		Map<String, Object> out = sjc.execute(sps);

		if (out.containsKey(KEY_NUMA)) {
			sfd.setNumA( (BigDecimal) out.get(KEY_NUMA) );
		}

		if (out.containsKey(KEY_ESTATUS)) {
			sfd.setEstatus((String) out.get(KEY_ESTATUS));
		}
		
		return sfd;
	}
	
	
	public Funcion2Dto funcionDb2(BigDecimal numA, BigDecimal numB) {

		Funcion2Dto sfd = new Funcion2Dto();

		SimpleJdbcCall sjc = new SimpleJdbcCall(jdbcTemplate);

		sjc.withSchemaName(SCHEMANAME)
		.withCatalogName(CATALOGNAME)
		.withFunctionName("funciony")
		.withoutProcedureColumnMetaDataAccess()
		.declareParameters(
				new SqlOutParameter(KEY_RETORNO, Types.DATE),
				new SqlInOutParameter(KEY_NUMA, Types.NUMERIC),
				new SqlParameter(KEY_NUMB, Types.NUMERIC),
				new SqlOutParameter(KEY_ESTATUS, Types.VARCHAR)
		);

		SqlParameterSource sps = new MapSqlParameterSource()
				.addValue(KEY_NUMA, numA)
				.addValue(KEY_NUMB, numB);

		Map<String, Object> out = sjc.execute(sps);

		if (out.containsKey(KEY_RETORNO)) {

			sfd.setRetorno((Date) out.get(KEY_RETORNO));

		}

		if (out.containsKey(KEY_NUMA)) {

			sfd.setInoutNumber((BigDecimal) out.get(KEY_NUMA));

		}

		if (out.containsKey(KEY_ESTATUS)) {

			sfd.setOutEstatus((String) out.get(KEY_ESTATUS));

		}

		return sfd;
	}
	
	
	public List<Map<String, Object>> buscarPorNombre(String nombre) {
		String query = "select * from Cliente where NOMBRE_CL = :nom";
		SqlParameterSource sps = new MapSqlParameterSource().addValue("nom", nombre);
		return npjt.queryForList(query, sps);
	}

	public FuncionDto funcionDb(String texto, int numero) {

		FuncionDto sfd = new FuncionDto();

		SimpleJdbcCall sjc = new SimpleJdbcCall(jdbcTemplate);

		sjc.withSchemaName(SCHEMANAME)
		.withCatalogName("paquete")
		.withFunctionName("funcionx")
		.withoutProcedureColumnMetaDataAccess()
		.declareParameters(
				new SqlOutParameter(KEY_RETORNO, Types.DATE),
				new SqlInOutParameter(KEY_TEXTO, Types.VARCHAR),
				new SqlParameter(KEY_NUMERO, Types.NUMERIC),
				new SqlOutParameter(KEY_SALIDA, Types.VARCHAR)
		);

		SqlParameterSource sps = new MapSqlParameterSource()
				.addValue(KEY_TEXTO, texto)
				.addValue(KEY_NUMERO, numero);

		Map<String, Object> out = sjc.execute(sps);

		if (out.containsKey(KEY_RETORNO)) {
			sfd.setRetorno((Date) out.get(KEY_RETORNO));
		}

		if (out.containsKey(KEY_TEXTO)) {
			sfd.setTexto((String) out.get(KEY_TEXTO));
		}

		if (out.containsKey(KEY_SALIDA)) {
			sfd.setSalida((String) out.get(KEY_SALIDA));
		}

		return sfd;
	}





}
