package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.dao.PostgraduateDao;
import user.entity.Postgraduate;

import java.util.List;

@Service
public class PostgraduateService {

    @Autowired
    private PostgraduateDao postgraduateDao;

    public Postgraduate getPo(String id) {
        return postgraduateDao.queryById(id);
    }

    public List<Postgraduate> getByPage(Integer page, Integer limit, String teacherId) {
        return postgraduateDao.queryAllByLimit((page - 1) * limit, limit, teacherId);
    }

    public Integer getTotalNum(String teacherId) {
        return postgraduateDao.queryNumber(teacherId);
    }

}
