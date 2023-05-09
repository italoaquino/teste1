package pgfn.gov.transfer.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "tb_token")
public class TokenEntity implements Serializable {
    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String nameInstitution;

    @Column(columnDefinition="TEXT")
    private String description;

    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", locale = "pt-BR", timezone = "Brazil/East")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", locale = "pt-BR", timezone = "Brazil/East")
    private LocalDateTime dateTokenValidate;

    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", locale = "pt-BR", timezone = "Brazil/East")
    private LocalDateTime usageToken;
    

    @OneToMany(mappedBy = "token", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<PerfilEntity> perfil = new HashSet<>();
    
	public TokenEntity() {
	}
	
	public TokenEntity(UUID id, String nameInstitution, String description, LocalDateTime createdAt,
                       LocalDateTime dateTokenValidate, LocalDateTime usageToken, Set<PerfilEntity> perfil) {
		this.id = id;
		this.nameInstitution = nameInstitution;
		this.description = description;
		this.createdAt = createdAt;
		this.dateTokenValidate = dateTokenValidate;
		this.usageToken = usageToken;
		this.perfil = perfil;
	}


	public Set<PerfilEntity> getPerfil() {
		return perfil;
	}

	public void setPerfil(Set<PerfilEntity> perfil) {
		this.perfil = perfil;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getId() {
        return id;
    }

    public String getNameInstitution() {
        return nameInstitution;
    }

	public void setNameInstitution(String nameInstitution) {
        this.nameInstitution = nameInstitution;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getDateTokenValidate() {
        return dateTokenValidate;
    }

    public void setDateTokenValidate(LocalDateTime dateTokenValidate) {
        this.dateTokenValidate = dateTokenValidate;
    }

    public LocalDateTime getUsageToken() {
        return usageToken;
    }

    public void setUsageToken(LocalDateTime usageToken) {
        this.usageToken = usageToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TokenEntity token = (TokenEntity) o;
        return id.equals(token.id) && nameInstitution.equals(token.nameInstitution) && description.equals(token.description) && createdAt.equals(token.createdAt) && dateTokenValidate.equals(token.dateTokenValidate) && usageToken.equals(token.usageToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameInstitution, description, createdAt, dateTokenValidate, usageToken);
    }

	@Override
	public String toString() {
		return "TokenEntity [id=" + id + ", nameInstitution=" + nameInstitution + ", description=" + description
				+ ", createdAt=" + createdAt + ", dateTokenValidate=" + dateTokenValidate + ", usageToken=" + usageToken+ "]";
	}
    
    
    
}


