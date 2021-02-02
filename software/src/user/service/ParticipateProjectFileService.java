package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.dao.ParticipateProjectFileDao;
import user.entity.ParticipateProjectFile;

@Service
public class ParticipateProjectFileService {

    @Autowired
    private ParticipateProjectFileDao participateProjectFileDao;

    /**
     * 通过逐渐查询
     */
    public ParticipateProjectFile queryById(String participateProjectId) {
        return participateProjectFileDao.queryById(participateProjectId);
    }

    public void add(ParticipateProjectFile participateProjectFile) {
        participateProjectFileDao.insert(participateProjectFile);
    }

}
