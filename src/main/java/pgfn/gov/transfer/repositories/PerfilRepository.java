package pgfn.gov.transfer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pgfn.gov.transfer.entities.PerfilEntity;

import java.util.UUID;

@Repository
public interface PerfilRepository extends JpaRepository<PerfilEntity, UUID> {

	UUID deleteByUsuarioId(UUID usuarioId);
  }
