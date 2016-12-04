package com.iot.repositories.party;

import com.iot.domain.party.Party;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by lyerox on 16-10-18.
 */
@Repository
public interface PartyRepository extends JpaRepository<Party, Long>{
    Page<Party> findAll(Pageable pageable);

    List<Party> findByType(Integer typeId);
}
