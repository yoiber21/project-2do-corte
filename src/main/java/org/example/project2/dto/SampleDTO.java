package org.example.project2.dto;

import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * Sample DTO class.
 */
@Setter
@Getter
public class SampleDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 4981959003319466259L;

    /**
     * -- GETTER --
     *
     *
     * -- SETTER --
     *
     @return random number.
      * @param random a random number.
     *
     */
    private int random;

    /**
     * Creates a new instance.
     */
    public SampleDTO() { }

    /**
     * Creates a new instance, with provided random value.
     *
     * @param random a random number.
     */
    public SampleDTO(int random) {
        this.random = random;
    }

}
