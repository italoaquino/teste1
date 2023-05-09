package pgfn.gov.transfer.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import pgfn.gov.transfer.enums.Perfil;

@Entity
@Table(name = "tb_perfil")
public class PerfilEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@JsonProperty(access = Access.WRITE_ONLY)
	private UUID perfilId;

	@ManyToOne
	@JoinColumn(name = "token_id", nullable = true)
	@JsonProperty(access = Access.WRITE_ONLY)
	private TokenEntity token;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true)
	@JsonProperty(access = Access.WRITE_ONLY)
	private UsuarioEntity usuario;

	@Enumerated(EnumType.ORDINAL)
	private Perfil perfil;

	public PerfilEntity(Perfil perfil) {
		this.perfil = perfil;
	}

	public PerfilEntity() {
	}

	public PerfilEntity(TokenEntity token, Perfil perfil) {
		this.token = token;
		this.perfil = perfil;
	}

	public PerfilEntity(UsuarioEntity usuario, Perfil perfil) {
		this.usuario = usuario;
		this.perfil = perfil;
	}

	public UUID getPerfilId() {
		return perfilId;
	}

	public void setPerfilId(UUID perfilId) {
		this.perfilId = perfilId;
	}

	public TokenEntity getToken() {
		return token;
	}

	public void setToken(TokenEntity token) {
		this.token = token;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}


	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(perfil, perfilId, token);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PerfilEntity other = (PerfilEntity) obj;
		return perfil == other.perfil && Objects.equals(perfilId, other.perfilId) && Objects.equals(token, other.token);
	}

	@Override
	public String toString() {
		return "PerfilEntity [perfilId=" + perfilId + ", token=" + token + ", perfil=" + perfil + "]";
	}


}
