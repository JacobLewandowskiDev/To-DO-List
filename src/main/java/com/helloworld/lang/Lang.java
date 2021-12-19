package com.helloworld.lang;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "alllanguages")
public class Lang {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name="inc", strategy = "increment")
    private Integer id;
    private String welcomeMessage;
    private String code;

    /**
     * Hibernate (JPA) needs it.
     */
    @SuppressWarnings("unused")
    Lang() {
    }

    public Lang(Integer id, String welcomeMessage, String code) {
        this.id = id;
        this.welcomeMessage = welcomeMessage;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public String getCode() {
        return code;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
