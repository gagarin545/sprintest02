package ru.service;

import ru.entity.IncidentEntity;

import java.util.List;

public interface IncidentService {
    List<IncidentEntity> getAllonTime();
}
