package br.com.dogsteps;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class App {

	private static final int porta = 8080;
	private static final String BASE_URI = "http://localhost:" + porta + "/dogsteps";

	public static void main(String[] args) throws IOException {
		final HttpServer server = startServer();

		System.out.println(String.format(
				"Aplicação de está iniciada na porta " + porta + "\nPressione enter para terminar...", BASE_URI));

		System.in.read();

		server.shutdownNow();
	}

	public static HttpServer startServer() {
		final ResourceConfig rc = new ResourceConfig().packages("br.com.dogsteps");
		return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
	}

}
