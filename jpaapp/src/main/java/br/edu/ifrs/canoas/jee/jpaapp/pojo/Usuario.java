package br.edu.ifrs.canoas.jee.jpaapp.pojo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String email;
	private String senha;
	private String Endereco;
	
	public Usuario() {
		super();
	}
			
	public Usuario(String email, String senha, String endereco) {
		
		this.email = email;
		this.senha = senha;
		Endereco = endereco;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getEndereco() {
		return Endereco;
	}


	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

   
}
