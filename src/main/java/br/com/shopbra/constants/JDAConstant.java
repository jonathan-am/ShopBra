package br.com.shopbra.constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dv8tion.jda.api.JDA;

@Component
public class JDAConstant {
	
	@Autowired
	public static JDA jda;

}
