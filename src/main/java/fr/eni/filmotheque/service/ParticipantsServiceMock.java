package fr.eni.filmotheque.service;

import fr.eni.filmotheque.bo.Participant;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParticipantsServiceMock implements ParticipantService {

    private List<Participant> participants;

    public ParticipantsServiceMock() {
        participants = new ArrayList<>();
        participants.add(new Participant(0,"Spielberg","Steven"));
        participants.add(new Participant(1,"Kubrick","Stanley"));
        participants.add(new Participant(2,"Tarantino","Quentin"));
        participants.add(new Participant(3,"Scorsese","Martin"));
        participants.add(new Participant(4,"Nolan","Christopher"));
        participants.add(new Participant(5,"Hitchcock","Alfred"));
        participants.add(new Participant(6,"Burton","Tim"));
        participants.add(new Participant(7,"Fincher","David"));
        participants.add(new Participant(8,"Pacino","Al"));
        participants.add(new Participant(9,"De Niro","Robert"));
        participants.add(new Participant(10,"DiCaprio","Leonardo"));
        participants.add(new Participant(11,"Eastwood","Clint"));
        participants.add(new Participant(12,"Freeman","Morgan"));
        participants.add(new Participant(13,"Depp","Johnny"));
        participants.add(new Participant(14,"Brando","Marlon"));
        participants.add(new Participant(15,"Pesci","Joe"));
        participants.add(new Participant(16,"Bergman","David"));
    }

    @Override
    public List<Participant> getAllParticipants() {
        return participants;
    }

    @Override
    public Participant getParticipantById(int id) {
        return participants.get(id);
    }
}
