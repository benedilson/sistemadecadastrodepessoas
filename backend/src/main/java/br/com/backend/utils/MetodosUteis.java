package br.com.backend.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MetodosUteis {
	
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
	
	public static String AjustaLocalDate(LocalDate localDate) {
		return localDate.format(formatter);
	}

}
