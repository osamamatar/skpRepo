package com.osama.skp.dao;

import com.osama.skp.domain.EmailSubscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailSubscriberRepository extends JpaRepository<EmailSubscriber,Long> {
}
