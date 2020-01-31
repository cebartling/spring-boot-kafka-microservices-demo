package com.pintailconsultingllc.microservices.profile.controllers;

import com.pintailconsultingllc.microservices.profile.entities.Profile;
import com.pintailconsultingllc.microservices.profile.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/profiles")
public class ProfileController {
    
    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileController(final ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @GetMapping()
    public ResponseEntity<Iterable<Profile>> getAll() {
        Iterable<Profile> profiles = profileRepository.findAll();
        return ResponseEntity.ok(profiles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getById(@PathVariable(value = "id") UUID id) {
        Optional<Profile> profile = profileRepository.findById(id);
        return ResponseEntity.ok(profile.get());
    }

//    @PostMapping("/profiles")
//    public Profile createProfile(@Valid @RequestBody Profile profile) {
//        return postRepository.findById(postId).map(post -> {
//            Profile.setPost(post);
//            return profileRepository.save(Profile);
//        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
//    }
//
//    @PutMapping("/posts/{postId}/Profiles/{ProfileId}")
//    public Profile updateProfile(@PathVariable (value = "postId") Long postId,
//                                 @PathVariable (value = "ProfileId") Long ProfileId,
//                                 @Valid @RequestBody Profile ProfileRequest) {
//        if(!postRepository.existsById(postId)) {
//            throw new ResourceNotFoundException("PostId " + postId + " not found");
//        }
//
//        return profileRepository.findById(ProfileId).map(Profile -> {
//            Profile.setText(ProfileRequest.getText());
//            return profileRepository.save(Profile);
//        }).orElseThrow(() -> new ResourceNotFoundException("ProfileId " + ProfileId + "not found"));
//    }
//
//    @DeleteMapping("/posts/{postId}/Profiles/{ProfileId}")
//    public ResponseEntity<?> deleteProfile(@PathVariable (value = "postId") Long postId,
//                                           @PathVariable(value = "ProfileId") Long ProfileId) {
//        return profileRepository.findByIdAndPostId(ProfileId, postId).map(Profile -> {
//            profileRepository.delete(Profile);
//            return ResponseEntity.ok().build();
//        }).orElseThrow(() -> new ResourceNotFoundException("Profile not found with id " + ProfileId + " and postId " + postId));
//    }
}
