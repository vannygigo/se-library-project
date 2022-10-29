package edu.miu.cs.cs425.studentmgmt.service;

import edu.miu.cs.cs425.studentmgmt.model.Transcript;

public interface TranscriptService {

    Transcript saveTranscript(Transcript transcript);

    Iterable<Transcript> getTranscripts();
}
