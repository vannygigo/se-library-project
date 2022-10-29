package edu.miu.cs.cs425.studentmgmt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs425.studentmgmt.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.repository.TranscriptRepository;
import edu.miu.cs.cs425.studentmgmt.service.TranscriptService;

@Service
public class TranscriptServiceImpl implements TranscriptService {
    @Autowired
    private TranscriptRepository transcriptRepository;

    @Override
    public Transcript saveTranscript(Transcript transcript) {
        return transcriptRepository.save(transcript);
    }

    @Override
    public Iterable<Transcript> getTranscripts() {
        return transcriptRepository.findAll();
    }

}
