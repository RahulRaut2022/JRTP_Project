package com.insurance.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.entity.DataCollect;

public interface DataCollectRepo extends JpaRepository<DataCollect, Serializable> {

}
