package nosmokepenalty;

import nosmokepenalty.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @Autowired
    EarnRepository EarnRepository;
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCheckOuted_CheckOut(@Payload CheckOuted checkOuted){

        if(checkOuted.isMe()){
            Earn earn = new Earn();
            earn.setCheckInId(checkOuted.getId());
            earn.setPoint(checkOuted.getPoint());
            //earn.setStatus(checkOuted.getStatus());

            EarnRepository.save(earn);
        }
    }
}
