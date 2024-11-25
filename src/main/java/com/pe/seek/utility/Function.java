package com.pe.seek.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Function {

	public static final String getLocalDateStr(String formatDate) {
		return LocalDateTime.now()
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
	}
}
