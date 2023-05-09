package pgfn.gov.transfer.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import pgfn.gov.transfer.enums.Perfil;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_user")
public class UsuarioEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private UUID id;
	private String nome;

	@Column(unique = true)
	private String email;

	@Column(unique=true)
	private String cpf;

	private Boolean ativo;

	@JsonIgnore
	private String senha;

	private String lotacaoCodigo;

	private String lotacaoDesc;

    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", locale = "pt-BR", timezone = "Brazil/East")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", locale = "pt-BR", timezone = "Brazil/East")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Transient
    private Set<Perfil> permissoes = new HashSet<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<PerfilEntity> perfis = new HashSet<>();
    
	public UsuarioEntity() {
	}

	public UsuarioEntity(UUID id, String nome, String email, String cpf, Boolean ativo, String senha, String lotacao, Set<PerfilEntity> perfis) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.ativo = ativo;
		this.senha = senha;
		this.setLotacaoCodigo(lotacao);
		this.perfis = perfis;
	}

	public Set<PerfilEntity> getPerfis() {
		return perfis;
	}


	public Set<Perfil> getPermissoes() {
		return permissoes;
	}

	public void setPerfis(Set<PerfilEntity> perfis) {
		this.perfis = perfis;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCpf() {
		return cpf;
	}

	public String getLotacaoDesc() {
        return lotacaoDesc;
    }

    public void setLotacaoDesc(String lotacaoDesc) {
        this.lotacaoDesc = lotacaoDesc;
    }

    public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

    public String getLotacaoCodigo() {
		return lotacaoCodigo;
	}

	public void setLotacaoCodigo(String lotacaoCodigo) {
		this.lotacaoCodigo = lotacaoCodigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioEntity other = (UsuarioEntity) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", ativo=" + ativo + "]";
	}

}
