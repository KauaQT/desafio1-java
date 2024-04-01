package desafio.viviane.api.repository;

import desafio.viviane.api.domain.Classification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassificationRepository extends JpaRepository<Classification, Integer> {
}
