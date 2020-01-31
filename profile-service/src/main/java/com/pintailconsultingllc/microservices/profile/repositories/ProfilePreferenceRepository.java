package com.pintailconsultingllc.microservices.profile.repositories;

import com.pintailconsultingllc.microservices.profile.entities.ProfilePreference;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfilePreferenceRepository extends CrudRepository<ProfilePreference, UUID> {
}
