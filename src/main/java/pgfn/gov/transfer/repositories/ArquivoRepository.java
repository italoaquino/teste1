package pgfn.gov.transfer.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pgfn.gov.transfer.entities.ArquivoEntity;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ArquivoRepository extends JpaRepository<ArquivoEntity, UUID> {

    public Optional<ArquivoEntity> findByName(String name);
    

    public Page<ArquivoEntity> findAllByCreatedAtBetween(LocalDateTime uploadsStart,
                                                         LocalDateTime uploadsEnd,
                                                         Pageable pageable);


}
