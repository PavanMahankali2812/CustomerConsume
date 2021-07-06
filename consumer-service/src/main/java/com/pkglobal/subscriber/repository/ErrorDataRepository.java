package com.pkglobal.subscriber.repository;

import org.springframework.data.repository.CrudRepository;

import com.pkglobal.subscriber.entity.Error;

public interface ErrorDataRepository extends CrudRepository<Error, String> {

}
