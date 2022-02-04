package com.coart.doura.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "task")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Task {
    @Transient
    public static final String SEQUENCE_NAME_UIID = "task_sequence_uiid";

    @Id
    private String id;

    @Indexed(unique = true)
    private long uiid;

    private String title;

    private String logo;

    private double reward;

    private String description;

    private String shortDescription;

    private String verificationInfo;

    @JsonIgnore
    private boolean removed;
}
