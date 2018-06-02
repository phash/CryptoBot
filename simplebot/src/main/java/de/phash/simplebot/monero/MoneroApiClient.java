package de.phash.simplebot.monero;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class MoneroApiClient {

	private static final String APIENDPOINT = "https://moneroblocks.info/api/get_block_header/";

	private Client client = ClientBuilder.newClient();

	private final static MoneroApiClient instance = new MoneroApiClient();

	private MoneroApiClient() {
		super();
	}

	public BlockHeader_ getHeader(int height) {
			return client.target(APIENDPOINT + height ).request(MediaType.APPLICATION_JSON)
					.get(BlockHeader_.class);
	}


	public static MoneroApiClient getInstance() {
		return instance;
	}

	
}
