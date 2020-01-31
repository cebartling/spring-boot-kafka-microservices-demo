package com.pintailconsultingllc.microservices.profile.repositories;

import com.pintailconsultingllc.microservices.profile.entities.ProfilePreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfilePreferenceRepository extends JpaRepository<ProfilePreference, UUID> {
}
