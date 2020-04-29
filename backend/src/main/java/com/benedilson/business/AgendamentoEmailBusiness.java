package com.benedilson.business;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class AgendamentoEmailBusiness {

	public List<String> listarAgendamentosEmail() {
		List<String> emails = new ArrayList<String>();
		emails.add("abc@def.com");
		emails.add("ghi@jkl.com");
		
		return emails;
	}
	
}
