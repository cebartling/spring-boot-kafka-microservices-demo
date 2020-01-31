package com.pintailconsultingllc.microservices.profile.repositories;

import com.pintailconsultingllc.microservices.profile.entities.Preference;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PreferenceRepository extends CrudRepository<Preference, UUID> {
}
