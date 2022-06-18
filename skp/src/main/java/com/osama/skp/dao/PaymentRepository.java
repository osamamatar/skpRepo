package com.osama.skp.dao;

import com.osama.skp.domain.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentModel,Long> {

    PaymentModel findByTransactionId(String paymentId);
}
