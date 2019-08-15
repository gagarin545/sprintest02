package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.entity.IncidentEntity;

import java.sql.Timestamp;
import java.util.List;

public interface IncidentEntityRepository extends JpaRepository<IncidentEntity, Long> {
    @Query("select b from IncidentEntity b where b.n_incident = :n_incident")
    IncidentEntity findByNumer(@Param("n_incident") long n_incident);
    @Query(value="select * from incident b where timeclose + time'00:20' > (select max(timeclose) from incident) and iddivision in :iddivision", nativeQuery = true)
    List<IncidentEntity> findByallontime(@Param("iddivision") int[] iddivision );
    @Query(value="select * from incident b where timeclose > current_date -1 and iddivision in :iddivision and (controltermtask ~ 'СКВ' OR controlterm ~ 'СКВ' OR controltermsla ~ 'СКВ')", nativeQuery = true)
    List<IncidentEntity> findByallOverdue(@Param("iddivision") int[] iddivision );

}
