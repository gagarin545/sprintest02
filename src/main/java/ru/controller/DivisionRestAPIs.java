package ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.entity.DivisionEntity;
import ru.entity.IncidentEntity;
import ru.entity.WorkersEntity;
import ru.repository.DivisionEntityRepository;
import ru.repository.IncidentEntityRepository;
import ru.repository.WorkersEntityRepository;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DivisionRestAPIs {
    @Autowired
    private DivisionEntityRepository divisionEntityRepository;
    @Autowired
    private WorkersEntityRepository workersEntityRepository;
    @Autowired
    private IncidentEntityRepository incidentEntityRepository;

    @PostMapping(value="/Devision", produces = "application/json")
    public DivisionEntity postDevision(@RequestBody DivisionEntity devisionEntity) {
        System.out.println("--->" + devisionEntity.getIddevision());
        return divisionEntityRepository.save( devisionEntity);
    }
    @GetMapping(value="/Division", produces = "application/json")
    public List<DivisionEntity> getAllDevision() {
        List<DivisionEntity> devision =  divisionEntityRepository.findAll();
        devision.forEach(s ->
                System.out.println( "->" + s.getIddevision() + ' ' + s.getNamedevision() + ' ' + s.getIdcity()));
                System.out.println( "--------------------------->" );
        return devision;
    }
    @GetMapping(value="/Workers/imei={imei}", produces = "application/json")
    public WorkersEntity registration(@PathVariable String imei) {
        return workersEntityRepository.findByimei( imei);
    }
    @GetMapping(value="/Incident/id={iddivision}", produces = "application/json")
    public List<IncidentEntity> getAllIncidentForWorker(@PathVariable int[] iddivision) {
        List<IncidentEntity> incidentEntity = null;
        incidentEntity = incidentEntityRepository.findByallontime(iddivision);
        System.out.println("Итого: " + incidentEntity.size());
        return incidentEntity;
    }
    @GetMapping(value="/Incident/n={n_incident}", produces = "application/json")
    public IncidentEntity getIncident(@PathVariable long n_incident) {
        IncidentEntity incidentEntity = null;
        incidentEntity = incidentEntityRepository.findByNumer(n_incident);
        return incidentEntity;
    }
    @GetMapping(value="/Incident/overdue={iddivision}", produces = "application/json")
    public List<IncidentEntity> getIncidentOverdue(@PathVariable int[] iddivision) {
        List<IncidentEntity> incidentEntity = null;
        incidentEntity = incidentEntityRepository.findByallOverdue(iddivision);
        return incidentEntity;
    }
}
