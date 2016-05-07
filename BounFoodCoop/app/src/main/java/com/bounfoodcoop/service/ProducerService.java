package com.bounfoodcoop.service;

import com.bounfoodcoop.repository.IProducerRepository;
import domain.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
