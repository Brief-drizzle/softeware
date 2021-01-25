package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.dao.TutorDao;
import user.entity.Tutor;

@Service
public class TurtorService {
    @Autowired
    TutorDao tutorDao;
    //是否是导师
    public Tutor getStatus(String id){
        Tutor tutor=tutorDao.queryByTeaid(id);
        return tutor;
    }
}
