package de.phash.simplebot;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import de.phash.simplebot.stocks.Result;
import de.phash.simplebot.stocks.Trades;

public class StocksAPIClient {
	private static final long WAITING = 1000l;

	private static final String TRADES = "https://stocks.exchange/api2/trades?pair=";

	private Client client = ClientBuilder.newClient();

	private StocksAPIClient() {
		super();
	}

	private final static StocksAPIClient instance = new StocksAPIClient();

	public Trades getTrades(String currency1, String currency2) {
			return client.target(TRADES + currency1 + "_" + currency2).request(MediaType.APPLICATION_JSON)
					.get(Trades.class);
	}

	public boolean lastTimeTooFast(Date now, Date last) {
		return now.getTime() - last.getTime() < WAITING;
	}

	public static StocksAPIClient getInstance() {
		return instance;
	}

	public Optional<Result> getLastSale(String currency1, String currency2, String type) {
		Trades trades = getTrades(currency1, currency2);
		Long latest = trades.getResult().stream().filter(f -> f.getType().equals(type)).mapToLong(v -> v.getTimestamp())
				.max().orElseThrow(NoSuchElementException::new);
		return trades.getResult().stream().filter(r -> r.getTimestamp().equals(latest)).findFirst();
	}

}
