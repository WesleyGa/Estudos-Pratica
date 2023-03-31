package com.email.classes;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class App {
	private String userName = "";
	private String senha = "";

	/* que recebe a carta. */
	private String listaDeDestinatário = "";

	/* remetente é quem envia a carta */
	private String nomeRemetente = "";
    /*Assunto do email*/
	private String assunto = "";
	
    /*Testo do email*/
	private String texto = "";
	
	          /* Construtor  do Email*/
	public App(String listaDeDestinatário, String nomeRemetente, String assunto, String texto ) {
		
		/*Construcao do objeto */
		this.listaDeDestinatário = listaDeDestinatário;
		this.nomeRemetente = nomeRemetente;
		this.assunto = assunto;
		this.texto = texto;
	}

	public void enviarEmail() throws Exception {

		/* Propriedades de conexão com o servidor de email do gmail */
		Properties properties = new Properties();
		properties.put("mail.smtp.ssl.enable", "true"); /*Envio de um e-mail por meio do servidor SMTP do Gmail usando a conexão SSL.
							 */
		properties.put("mail.smtp.auth", "true"); /*é usado para envios de email do cliente SMTP, O SMTP AUTH dá suporte à autenticação*/
		properties.put("mail.smtp.starttls", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com"); /* servidor do gmail google */
		properties.put("mail.smtp.port", "465"); /* Porta do servidor */
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.SSLSocketFactory");

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(userName, senha);
			}
		});

		Address[] toUser = InternetAddress.parse(listaDeDestinatário);
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(userName, nomeRemetente));
		message.setRecipients(Message.RecipientType.TO, toUser);
		message.setSubject(assunto);
		message.setText(texto);

		Transport.send(message);

	}
}