package com.bounfoodcoop.service;

import com.bounfoodcoop.repository.IProducerRepository;
import com.bounfoodcoop.core.domain.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProducerService {

    private IProducerRepository producerRepository;

    @Autowired
    public ProducerService(IProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    public Producer getByName(String name){
        Producer producer = new Producer();
        producer.Load(producerRepository.findByName(name));
        return producer;
    }

    public List<Producer> getAll(){
        return producerRepository.findAllByOrderByCreatedAtDesc().stream().map(pd -> {
            Producer producer = new Producer();
            producer.Load(pd);
            return producer;
        }).collect(Collectors.toList());
    }
}
