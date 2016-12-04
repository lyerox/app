package com.iot.repositories.account;

import com.iot.domain.account.User;
import com.iot.domain.party.Party;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Created by lyerox on 16-10-28.
 */
@Repository
public interface UserRepository extends  JpaRepository<User, Long>{

    Page<User> findAll(Pageable pageable);

    List<User> findAll();

    Page<User> findByParty(Party party, Pageable pageable);
    List<User> findByParty(Party party);

    User findByName(String name);

    User findById(Long id);
}
