package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.dao.InstructorDao;
import user.entity.Instructor;

@Service
public class InstructorService {
    @Autowired
    InstructorDao instructorDao;
    //是否是授课教师
    public Instructor getStatus(String id){
        Instructor instructor=instructorDao.queryByteaId(id);
        return instructor;
    }
}
