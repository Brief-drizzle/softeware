package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.dao.TutorDao;
import user.entity.Tutor;

import java.util.List;

@Service
public class TurtorService {

    @Autowired
    private TutorDao tutorDao;

    /**
     * 是否是导师
     */
    public Tutor getStatus(String id) {
        return tutorDao.queryByTeaid(id);
    }

    /**
     * 通过主键查询
     */
    public Tutor queryById(String tutorId) {
        return tutorDao.queryById(tutorId);
    }

    /**
     * 查询全部
     */
    public List<Tutor> queryAll() {
        return tutorDao.queryAll(null);
    }

}
