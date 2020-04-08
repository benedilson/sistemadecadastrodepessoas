package br.com.backend.seguranca;

import java.util.Calendar;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.DatatypeConverter;

import com.google.gson.Gson;

import br.com.backend.entidades.Operador;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Path("/login")
public class LoginService {

	private static final String FRASE_SEGREDO = "segredo";

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response fazerLogin(String credenciaisJson) {

		try {
			Gson gson = new Gson();
			Operador operador = gson.fromJson(credenciaisJson, Operador.class);
			validarCrendenciais(operador);

			String token = gerarToken(operador.getLoginOperador(), 2);
			return Response.ok(token).build();

		} catch (Exception e) {

			e.printStackTrace();

			return Response.status(Status.UNAUTHORIZED).build();

		}

	}

	private void validarCrendenciais(Operador crendencial) throws Exception {

		try {
			if (!crendencial.getLoginOperador().equals("adminstrador")
					|| !crendencial.getSenhaOperador().equals("administrador"))
				throw new Exception("Crendencias não válidas!");

		} catch (Exception e) {
			throw e;
		}
	}

	private String gerarToken(String login, Integer expiraEmDias) {

		SignatureAlgorithm algoritimoAssinatura = SignatureAlgorithm.HS512;

		Date agora = new Date();

		Calendar expira = Calendar.getInstance();
		expira.add(Calendar.DAY_OF_MONTH, expiraEmDias);

		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(FRASE_SEGREDO);

		SecretKeySpec key = new SecretKeySpec(apiKeySecretBytes, algoritimoAssinatura.getJcaName());

		JwtBuilder construtor = Jwts.builder()

				.setIssuedAt(agora).setIssuer(login).signWith(algoritimoAssinatura, key)
				.setExpiration(expira.getTime());

		return construtor.compact();

	}

	public Claims validaToken(String token) {

		try {

			Claims claims = Jwts.parser()

					.setSigningKey(DatatypeConverter.parseBase64Binary(FRASE_SEGREDO))

					.parseClaimsJws(token).getBody();

			System.out.println(claims.getIssuer());
			return claims;

		} catch (Exception ex) {
			throw ex;
		}
	}
}