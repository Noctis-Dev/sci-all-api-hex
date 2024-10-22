package org.noctisdev.sciallhexvsg.payments.infraestructure.repository.jpa;

import org.noctisdev.sciallhexvsg.payments.infraestructure.entities.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentEntityRepository extends JpaRepository<PaymentEntity, Long> {

}