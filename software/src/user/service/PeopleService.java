package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.dao.PeopleDao;
import user.entity.People;

@Service
public class PeopleService {

    @Autowired
    private PeopleDao peopleDao;

    public People login(String id, String pwd) {
        People people = peopleDao.queryById(id);
        if (!people.getPassword().equals(pwd)) {
            return null;
        }
        return people;
    }

}
