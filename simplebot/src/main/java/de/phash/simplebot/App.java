package de.phash.simplebot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import de.phash.simplebot.commands.GetLatestFromStocks;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	  if (args.length < 1) {
              System.err.println("Please provide a valid token as the first argument!");
              return;
          }

          // Enable debugging, if no slf4j logger was found

          // The token is the first argument of the program
          String token = args[0];

          // We login blocking, just because it is simpler and doesn't matter here
          DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

          // Print the invite url of the bot
          System.out.println("You can invite me by using the following url: " + api.createBotInvite());

          // Add listeners
          api.addMessageCreateListener(new GetLatestFromStocks());

          // Log a message, if the bot joined or left a server
          api.addServerJoinListener(event -> System.out.println("Joined server " + event.getServer().getName()));
          api.addServerLeaveListener(event -> System.out.println("Left server " + event.getServer().getName()));
       
    }
    
    
}
