package fr.eni.filmotheque.controller.converter;

import fr.eni.filmotheque.bo.Participant;
import fr.eni.filmotheque.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StringToParticipantsConverter implements Converter <String, Participant>{

    private List<Participant> participants;
    private ParticipantService participantService;

    public StringToParticipantsConverter(ParticipantService participantService) {
        this.participantService = participantService;
    }
    @Override
    public Participant convert(String idParticipant) {
        Participant participant = null;
        try {
            int id = Integer.parseInt(idParticipant);
            participant = participantService.getParticipantById(id);
        } catch (NumberFormatException e) {
        }
        return participant;
    }
}
