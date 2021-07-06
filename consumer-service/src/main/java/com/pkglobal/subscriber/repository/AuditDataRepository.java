package com.pkglobal.subscriber.repository;

import org.springframework.data.repository.CrudRepository;

import com.pkglobal.subscriber.entity.Audit;

public interface AuditDataRepository extends CrudRepository<Audit, String> {

}
