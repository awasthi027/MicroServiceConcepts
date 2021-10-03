package com.ashi.learning.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashi.learning.model.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

  public Coupon findByCode(String code);

}
