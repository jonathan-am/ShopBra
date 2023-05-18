package br.com.shopbra.manager;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.EmbedType;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.MessageEmbed.AuthorInfo;
import net.dv8tion.jda.api.entities.MessageEmbed.Thumbnail;

@Component
@Log4j2
public class DiscordManager {
	
	@Autowired
	private JDA jda;
	
	public void sendTokenToUser(String userId, String token) {
		MessageEmbed message = new MessageEmbed(
				"https://www.google.com.br/",
				"Codigo de Segurança",
				"Você recebeu um codigo de segurança, para seguir com as alterações.\nNão compartilhe este código com ninguem.\nEle expira em 3 minutos, ou é deletado após o uso.",
				EmbedType.RICH,
				null,
				3964450,
				new Thumbnail("https://i0.statig.com.br/bancodeimagens/by/nu/8w/bynu8wj7239xajxe5y6cg952y.jpg", null, 40, 40),
				null,
				new AuthorInfo("Sistema", null, null, null),
				null,
				null,
				null,
				Arrays.asList(new MessageEmbed.Field("Token", token, true)));
		log.info("DiscordManager.sendTokenToUser - Sending message in discord - userId[{}], jda: [{}]", userId, jda.retrieveUserById("221336244011925506").complete().openPrivateChannel());
		jda.openPrivateChannelById(userId).flatMap(channel -> channel.sendMessageEmbeds(message)).queue();
	}

}
