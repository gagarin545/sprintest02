package ru.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.config.TestDataBaseConfig;
import ru.entity.WorkersEntity;
import ru.repository.WorkersEntityRepository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Arrays;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class WorkersServiceTest {
    @Resource
    private EntityManagerFactory emf;
    private EntityManager em;

    @Resource
    private WorkersEntityRepository workersEntityRepository;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

    @Test
    public void testWorkersRead() throws Exception {
        String imei = "1234567890";
        WorkersEntity worker =  workersEntityRepository.findByimei( imei);
        if( worker.getIddivision().length > 0)
            System.out.println( "->" + worker.getName() + ' ' + worker.getImei());
        //worker.setIddivision(i);
        //workersService.addWorker(worker);
       // workersService.getAll().forEach(ss -> System.out.println( Arrays.toString(ss.getIddivision()) + ss.getIdworker() + ss.getImei() + ss.getName() ));
    }
}
