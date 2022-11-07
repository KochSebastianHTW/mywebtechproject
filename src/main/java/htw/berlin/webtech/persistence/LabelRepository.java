package htw.berlin.webtech.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelRepository extends JpaRepository<LabelEntity, Long> {

    List<LabelEntity> findByNameContainsIgnoreCase(String str);
}
