package br.com.shopbra.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.EmbedType;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.MessageEmbed.AuthorInfo;
import net.dv8tion.jda.api.entities.MessageEmbed.ImageInfo;
import net.dv8tion.jda.api.entities.MessageEmbed.Thumbnail;

@Service
@Log4j2
public class JDAService {
	
	@Autowired
	private JDA jda;
	
	
	public void teste() {
		log.info("teste - {}", jda.getCategories());
		log.info("channels - {}", jda.getCategoryById("1107705753738940566").getTextChannels());
		
		MessageEmbed message = new MessageEmbed(
				"https://www.google.com.br/",
				"Produto Ficticio",
				"Aut dolorem cupiditate id sunt odit sit officiis perferendis ab sunt laborum. Et dolorem corporis At aliquid assumenda id perferendis ipsam ex internos natus et repudiandae impedit qui sunt fugit!",
				EmbedType.RICH,
				null,
				3964450,
				new Thumbnail("https://i0.statig.com.br/bancodeimagens/by/nu/8w/bynu8wj7239xajxe5y6cg952y.jpg", null, 40, 40),
				null,
				new AuthorInfo("Loja 1", null, null, null),
				null,
				null,
				new ImageInfo("https://cdn.discordapp.com/attachments/525108157496950796/1107734441654227045/346407199_6548797375138881_7429115867377365358_n.jpg", null, 300, 400),
				Arrays.asList(new MessageEmbed.Field("Preço", "R$ 200.00", true)));
		
		jda.getTextChannelById("1107705774987296888").sendMessageEmbeds( message ).queue();
	}

}
