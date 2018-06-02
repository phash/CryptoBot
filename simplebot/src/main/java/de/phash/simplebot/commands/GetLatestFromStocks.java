package de.phash.simplebot.commands;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import de.phash.simplebot.StocksAPIClient;
import de.phash.simplebot.stocks.Result;

public class GetLatestFromStocks implements MessageCreateListener {
	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy - hh:mm:ss");

	@Override
	public void onMessageCreate(MessageCreateEvent event) {
		String[] message = event.getMessage().getContent().split(" ");
		if (message[0].equalsIgnoreCase("!stocks")) {
			if (StringUtils.isBlank(message[1]) || StringUtils.isBlank(message[2])) {
				event.getChannel()
						.sendMessage("Command incomplete! use !stocks currency1 currency2 e.g. !stocks sem btc");
			}
			String currency1 = message[1].toUpperCase();
			String currency2 = message[2].toUpperCase();

			Optional<Result> buyTrades = StocksAPIClient.getInstance().getLastSale(currency1, currency2, "BUY");
			Optional<Result> sellTrades = StocksAPIClient.getInstance().getLastSale(currency1, currency2, "SELL");

			EmbedBuilder embed = new EmbedBuilder().setTitle(String.format("Stocks %s_%s", currency1, currency2));
			if (!buyTrades.isPresent() && !sellTrades.isPresent()) {

				event.getChannel()
						.sendMessage("Command incomplete! use !stocks currency1 currency2 e.g. !stocks sem btc");
			} else {

				if (buyTrades.isPresent())
					addTrades(buyTrades, "buy", embed);
				if (sellTrades.isPresent())
					addTrades(sellTrades, "sell", embed);
				event.getChannel().sendMessage(embed);
			}

		}

	}

	private void addTrades(Optional<Result> trade, String type, EmbedBuilder embed) {
		embed.addField("latest " + type + " price", trade.get().getPrice(), true)
				.addField("latest " + type, trade.get().getQuantity(), true)
				.addField("at", sdf.format(new Date(trade.get().getTimestamp())), true);
	}

}
