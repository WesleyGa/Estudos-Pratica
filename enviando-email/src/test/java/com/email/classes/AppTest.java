package com.email.classes;

import org.junit.Test;

public class AppTest {

	
	@Test
	public void testeEmail() throws Exception {

	  	/* Chamando o construtor da classe App.java  */
		App enviandoEmail = new App("", /* Lista de emails destinatarios */
				"", /* Nome do Remetente */
				"", /* Assunto do email */
				""); /* Tesxto do email */

		enviandoEmail.enviarEmail(); /* enviando o objeto email */

	}

}
