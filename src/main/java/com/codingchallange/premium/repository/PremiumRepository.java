package com.codingchallange.premium.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingchallange.premium.model.Premium;

@Repository
public interface PremiumRepository extends JpaRepository<Premium, Long>
{

}
