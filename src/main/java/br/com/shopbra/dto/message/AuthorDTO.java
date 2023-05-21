package br.com.shopbra.dto.message;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO implements Serializable{
	
	private static final long serialVersionUID = 6762440726334658375L;
	private String name;

}
