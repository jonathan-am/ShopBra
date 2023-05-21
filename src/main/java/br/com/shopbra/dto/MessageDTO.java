package br.com.shopbra.dto;

import java.io.Serializable;
import java.util.List;

import br.com.shopbra.dto.message.AuthorDTO;
import br.com.shopbra.dto.message.ThumbnailDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.dv8tion.jda.api.entities.EmbedType;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.MessageEmbed.AuthorInfo;
import net.dv8tion.jda.api.entities.MessageEmbed.Field;
import net.dv8tion.jda.api.entities.MessageEmbed.Thumbnail;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO implements Serializable{

	private static final long serialVersionUID = -3759235716554358023L;
	
	private String title;
	private String description;
	private int color;
	private ThumbnailDTO thumbnail;
	private AuthorDTO author;
	
	public MessageEmbed toMessageEmbed(List<Field> fields) {
		return new MessageEmbed(null, title, description, EmbedType.RICH, null, color, new Thumbnail(thumbnail.getUrl(), null, 0, 0), null, new AuthorInfo(author.getName(), null, null, null), null, null, null, fields);
	}

}
