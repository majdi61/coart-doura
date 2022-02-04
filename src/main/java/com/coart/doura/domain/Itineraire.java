package com.coart.doura.domain;

import com.coart.doura.service.dto.Geolocation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.geo.GeoJson;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "itineraire")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Itineraire {
    @Transient
    public static final String SEQUENCE_NAME_UIID = "itineraire_sequence_uiid";

    @Id
    private String id;

    @Indexed(unique = true)
    private long uiid;

    private String type;

    private String start;

    private String end;

    private Object geolocation;

    private String test;


}
