package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.dao.DirectorDao;
import user.entity.Director;

@Service
public class DirectorService {

    @Autowired
    private DirectorDao directorDao;

    public Director queryById(String id) {
        return directorDao.queryById(id);
    }

}
