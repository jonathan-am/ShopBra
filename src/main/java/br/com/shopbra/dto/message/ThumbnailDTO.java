package br.com.shopbra.dto.message;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThumbnailDTO implements Serializable{
	
	private static final long serialVersionUID = 6937213325635083423L;
	private String url;
	
}
