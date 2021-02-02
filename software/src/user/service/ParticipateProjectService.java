package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.dao.ParticipateProjectDao;
import user.entity.ParticipateProject;

import java.util.List;

@Service
public class ParticipateProjectService {

    @Autowired
    private ParticipateProjectDao participateProjectDao;

    /**
     * 通过主键查询
     */
    public ParticipateProject getById(String id) {
        return participateProjectDao.queryById(id);
    }

    /**
     * 分页查询
     */
    public List<ParticipateProject> getByPage(Integer page, Integer limit) {
        return participateProjectDao.queryAllByLimit((page - 1) * limit, limit);
    }

    /**
     * 获取总数量
     */
    public Integer getTotalNum() {
        return participateProjectDao.queryNumber();
    }

    /**
     * 添加
     */
    public void add(ParticipateProject participateProject) {
        participateProjectDao.insert(participateProject);
    }

}
