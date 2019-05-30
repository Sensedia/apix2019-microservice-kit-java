package com.sensedia.apix2019.kit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sensedia.apix2019.kit.entity.Kit;

public interface KitRepository extends JpaRepository<Kit, String> {

    List<Kit> findByPhone(String phone);

}
