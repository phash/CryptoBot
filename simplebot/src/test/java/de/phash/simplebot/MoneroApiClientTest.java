package de.phash.simplebot;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;

import de.phash.simplebot.monero.BlockHeader_;
import de.phash.simplebot.monero.MoneroApiClient;
@Ignore("not yet implemented")
public class MoneroApiClientTest {

	@Test
	public void test() {
		BlockHeader_ header = MoneroApiClient.getInstance().getHeader(1);
		assertNotNull(header);
	}

}
