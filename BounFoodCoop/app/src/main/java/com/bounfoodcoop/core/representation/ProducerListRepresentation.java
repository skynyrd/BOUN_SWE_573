package com.bounfoodcoop.core.representation;


import com.bounfoodcoop.core.domain.Producer;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

public class ProducerListRepresentation {
    public @Getter @Setter List<ProducerRepresentation> producerRepresentations;

    public ProducerListRepresentation(List<Producer> producerList) {
        producerRepresentations = producerList.stream()
                .map(p -> new ProducerRepresentation(p)).collect(Collectors.toList());
    }
}
