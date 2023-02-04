package com.insurance.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.entity.KidDetails;

public interface KidDetailsRepo extends JpaRepository<KidDetails, Serializable> {

}
