package br.com.shopbra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

@Component
public class JDAConfig {
	
	
	@Bean("jda")
	private JDA getJda() {
		JDABuilder jda = JDABuilder.createDefault("MTEwNzY4MTk0MTU1NTI1NzQ0NQ.GiXJHA.7QQBzPquyMr9FfOjmwNt-Ak5irqZroS5JaNZ_w");
		jda.setAutoReconnect(true);
		jda.setActivity(Activity.listening("Em Desenvolvimento"));
		return jda.build();
	}
	

}
