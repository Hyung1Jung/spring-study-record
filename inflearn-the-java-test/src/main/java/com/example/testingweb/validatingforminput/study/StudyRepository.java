package com.example.testingweb.validatingforminput.study;

import com.example.testingweb.validatingforminput.domain.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study, Long> {

}