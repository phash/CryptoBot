package de.phash.simplebot;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import de.phash.simplebot.stocks.Currencies;
import de.phash.simplebot.stocks.Result;
import de.phash.simplebot.stocks.Trades;

/**
 * Unit test for simple App.
 */

public class AppTest {

	@Test
	public void testAppResult() {
		Trades semBtc = StocksAPIClient.getInstance().getTrades(Currencies.SEM, Currencies.BTC);
		assertTrue("Result empty", semBtc.getResult() != null);
	}

	@Test
	public void testAppResultPrice() {
		Trades semBtc = StocksAPIClient.getInstance().getTrades(Currencies.SEM, Currencies.BTC);
		List<Result> results = semBtc.getResult();
		System.out.println(results.get(0).getPrice());
		assertTrue("Result empty", results.get(0).getPrice() != null);
	}

	@Test
	public void testSell() throws InterruptedException {
		Thread.sleep(1001l);
		Optional<Result> result = StocksAPIClient.getInstance().getLastSale(Currencies.SEM, Currencies.BTC, "SELL");
		assertTrue("Result empty", result.isPresent());
	}

	@Test
	public void testBuy() {
		Optional<Result> result = StocksAPIClient.getInstance().getLastSale(Currencies.SEM, Currencies.BTC, "BUY");
		assertTrue("Result empty", result.isPresent());
	}

	@Test
	public void notEnoughTime() {
		assertTrue("Nicht genug Zeit vergangen",
				StocksAPIClient.getInstance().lastTimeTooFast(new Date(10000001), new Date(10000000)));

	}

	@Test
	public void enoughTime() {
		assertFalse("Nicht genug Zeit vergangen",
				StocksAPIClient.getInstance().lastTimeTooFast(new Date(10001001), new Date(1000000)));

	}
}
