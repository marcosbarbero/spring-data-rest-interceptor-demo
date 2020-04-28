package com.marcosbarbero.data.repository;

import com.marcosbarbero.data.model.Exams;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "exams", path = "exams")
public interface ExamsRepository extends PagingAndSortingRepository<Exams, Integer> {

    List<Exams> findByCustomerId(Integer customerId);
}
