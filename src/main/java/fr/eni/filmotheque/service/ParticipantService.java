package fr.eni.filmotheque.service;

import fr.eni.filmotheque.bo.Participant;

import java.util.List;

public interface ParticipantService {
    List<Participant> getAllParticipants();
    Participant getParticipantById(int id);
}
