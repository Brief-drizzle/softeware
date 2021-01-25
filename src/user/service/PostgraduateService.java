package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.dao.PostgraduateDao;
import user.entity.Postgraduate;

@Service
public class PostgraduateService {
    @Autowired
    PostgraduateDao postgraduateDao;

    public Postgraduate getPo(String id){
        return postgraduateDao.queryById(id);
    }
}
