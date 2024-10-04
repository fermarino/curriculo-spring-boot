package com.curriculoapi.service;

import com.curriculoapi.model.Resume;
import com.curriculoapi.model.Experience;
import com.curriculoapi.model.Education;
import com.curriculoapi.model.Stack;
import com.curriculoapi.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    public List<Resume> getAllResumes() {
        return resumeRepository.findAll();
    }

    public Optional<Resume> getResumeById(Long id) {
        return resumeRepository.findById(id);
    }

    public Resume createResume(Resume resume) {
        return resumeRepository.save(resume);
    }

    public Resume updateResume(Long id, Resume resumeDetails) {
        Resume resume = resumeRepository.findById(id).orElseThrow();
        resume.setName(resumeDetails.getName());
        resume.setEmail(resumeDetails.getEmail());
        resume.setPhone(resumeDetails.getPhone());
        resume.setAddress(resumeDetails.getAddress());
        resume.setExperiences(resumeDetails.getExperiences());
        resume.setEducations(resumeDetails.getEducations());
        resume.setStacks(resumeDetails.getStacks());
        return resumeRepository.save(resume);
    }

    public void deleteResume(Long id) {
        resumeRepository.deleteById(id);
    }

    public Experience addExperience(Long id, Experience experience) {
        Resume resume = resumeRepository.findById(id).orElseThrow();
        resume.getExperiences().add(experience);
        resumeRepository.save(resume);
        return experience;
    }

    public Education addEducation(Long id, Education education) {
        Resume resume = resumeRepository.findById(id).orElseThrow();
        resume.getEducations().add(education);
        resumeRepository.save(resume);
        return education;
    }

    public Stack addStack(Long id, Stack stack) {
        Resume resume = resumeRepository.findById(id).orElseThrow();
        resume.getStacks().add(stack);
        resumeRepository.save(resume);
        return stack;
    }
}
