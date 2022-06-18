package com.osama.skp.dao;

import com.osama.skp.domain.EmailSubscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface EmailSubscriberRepository extends JpaRepository<EmailSubscriber,Long> {
    void deleteAllByIdIn(Collection<Long> ids);

    Boolean existsByEmail(String customerMail);
}
