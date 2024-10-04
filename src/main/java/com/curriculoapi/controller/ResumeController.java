package com.curriculoapi.controller;

import com.curriculoapi.model.Resume;
import com.curriculoapi.model.Experience;
import com.curriculoapi.model.Education;
import com.curriculoapi.model.Stack;
import com.curriculoapi.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @GetMapping
    public List<Resume> listResumes() {
        return resumeService.getAllResumes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resume> getResumeById(@PathVariable Long id) {
        Optional<Resume> resume = resumeService.getResumeById(id);
        return resume.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Resume saveResume(@RequestBody Resume resume) {
        return resumeService.createResume(resume);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resume> updateResume(@PathVariable Long id, @RequestBody Resume resumeDetails) {
        Resume updatedResume = resumeService.updateResume(id, resumeDetails);
        return ResponseEntity.ok(updatedResume);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResume(@PathVariable Long id) {
        Optional<Resume> resume = resumeService.getResumeById(id);
        if (resume.isPresent()) {
            resumeService.deleteResume(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}/experiences")
    public ResponseEntity<Experience> addExperience(@PathVariable Long id, @RequestBody Experience experience) {
        Experience addedExperience = resumeService.addExperience(id, experience);
        return ResponseEntity.ok(addedExperience);
    }

    @PostMapping("/{id}/educations")
    public ResponseEntity<Education> addEducation(@PathVariable Long id, @RequestBody Education education) {
        Education addedEducation = resumeService.addEducation(id, education);
        return ResponseEntity.ok(addedEducation);
    }

    @PostMapping("/{id}/stacks")
    public ResponseEntity<Stack> addStack(@PathVariable Long id, @RequestBody Stack stack) {
        Stack addedStack = resumeService.addStack(id, stack);
        return ResponseEntity.ok(addedStack);
    }
}
