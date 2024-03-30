package org.example.project2.beans;

import java.util.concurrent.ThreadLocalRandom;
import org.example.project2.dto.SampleDTO;
import org.springframework.stereotype.Component;


/**
 * Sample Bean class.
 */
@Component
public class RandomSampleBean {

    /**
     * @return new instance of SampleDTO.
     */
    public SampleDTO random() {
        return new SampleDTO(ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE));
    }
}
