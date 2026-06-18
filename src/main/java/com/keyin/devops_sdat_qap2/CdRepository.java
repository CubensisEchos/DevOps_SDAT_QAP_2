package com.keyin.devops_sdat_qap2;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CdRepository extends JpaRepository<Cd,Long>
{

}
