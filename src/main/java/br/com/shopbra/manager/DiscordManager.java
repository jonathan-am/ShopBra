package br.com.shopbra.manager;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.shopbra.dto.MessageDTO;
import br.com.shopbra.utils.JsonUtils;
import lombok.extern.log4j.Log4j2;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageEmbed;

@Component
@Log4j2
public class DiscordManager {
	
	@Autowired
	private JDA jda;
	
	public void sendTokenToUser(String userId, String token) {
		try {
			MessageDTO dto = (MessageDTO) JsonUtils.getObjectMapper().readValue(new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/messagesPayloads/sendTokenMessage.json"), "ISO-8859-1")), MessageDTO.class);
			MessageEmbed message = dto.toMessageEmbed(Arrays.asList(new MessageEmbed.Field("Token", token, true)));
			
			log.info("DiscordManager.sendTokenToUser - Sending message in discord - userId[{}], jda: [{}]", userId, jda.retrieveUserById("221336244011925506").complete().openPrivateChannel());
			
			jda.openPrivateChannelById(userId).flatMap(channel -> channel.sendMessageEmbeds(message)).queue();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
