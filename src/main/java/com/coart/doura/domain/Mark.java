package com.coart.doura.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.compress.utils.Lists;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "mark")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Mark {
    @Transient
    public static final String SEQUENCE_NAME_UIID = "mark_sequence_uiid";

    @Id
    private String id;

    @Indexed(unique = true)
    private long uiid;

    private String name;

    private List<String> coordinates = Lists.newArrayList();

    private Object data;


}
