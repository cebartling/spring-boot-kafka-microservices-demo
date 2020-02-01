package com.pintailconsultingllc.microservices.profile.controllers;

import com.pintailconsultingllc.microservices.profile.entities.Preference;
import com.pintailconsultingllc.microservices.profile.repositories.PreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/preferences")
public class PreferenceController {

    private final PreferenceRepository preferenceRepository;

    @Autowired
    public PreferenceController(final PreferenceRepository preferenceRepository) {
        this.preferenceRepository = preferenceRepository;
    }

    @GetMapping()
    public ResponseEntity<Iterable<Preference>> getAll() {
        Iterable<Preference> preferences = preferenceRepository.findAll();
        return ResponseEntity.ok(preferences);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Preference> getById(@PathVariable(value = "id") UUID id) {
        Optional<Preference> preference = preferenceRepository.findById(id);
        return ResponseEntity.ok(preference.get());
    }

//    @PostMapping("/preferences")
//    public Preference createPreference(@Valid @RequestBody Preference preference) {
//        return postRepository.findById(postId).map(post -> {
//            Preference.setPost(post);
//            return preferenceRepository.save(Preference);
//        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
//    }
//
//    @PutMapping("/posts/{postId}/Preferences/{PreferenceId}")
//    public Preference updatePreference(@PathVariable (value = "postId") Long postId,
//                                 @PathVariable (value = "PreferenceId") Long PreferenceId,
//                                 @Valid @RequestBody Preference PreferenceRequest) {
//        if(!postRepository.existsById(postId)) {
//            throw new ResourceNotFoundException("PostId " + postId + " not found");
//        }
//
//        return preferenceRepository.findById(PreferenceId).map(Preference -> {
//            Preference.setText(PreferenceRequest.getText());
//            return preferenceRepository.save(Preference);
//        }).orElseThrow(() -> new ResourceNotFoundException("PreferenceId " + PreferenceId + "not found"));
//    }
//
//    @DeleteMapping("/posts/{postId}/Preferences/{PreferenceId}")
//    public ResponseEntity<?> deletePreference(@PathVariable (value = "postId") Long postId,
//                                           @PathVariable(value = "PreferenceId") Long PreferenceId) {
//        return preferenceRepository.findByIdAndPostId(PreferenceId, postId).map(Preference -> {
//            preferenceRepository.delete(Preference);
//            return ResponseEntity.ok().build();
//        }).orElseThrow(() -> new ResourceNotFoundException("Preference not found with id " + PreferenceId + " and postId " + postId));
//    }
}
