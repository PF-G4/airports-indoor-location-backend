package afinal.proyecto.cuatro.grupo.dao;

import afinal.proyecto.cuatro.grupo.entities.Promotion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DaoPromotion extends CrudRepository<Promotion, Long> {

    @Query("select p from Promotion p where p.beacon=:beaconId")
    Promotion findPromotionByBeaconId(@Param("beaconId") String beaconId);
}
