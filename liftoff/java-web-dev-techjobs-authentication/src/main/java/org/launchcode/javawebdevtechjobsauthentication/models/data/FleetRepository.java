package org.launchcode.javawebdevtechjobsauthentication.models.data;

import org.launchcode.javawebdevtechjobsauthentication.models.Car;
import org.launchcode.javawebdevtechjobsauthentication.models.Fleet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface FleetRepository extends CrudRepository<Fleet, Integer> {
}

