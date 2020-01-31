package com.pintailconsultingllc.microservices.profile.repositories;

import com.pintailconsultingllc.microservices.profile.entities.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, UUID> {
}
