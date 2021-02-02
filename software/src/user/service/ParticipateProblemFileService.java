package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.dao.ParticipateProblemFileDao;
import user.entity.ParticipateProblemFile;
import user.utils.IdUtils;

import java.util.List;

@Service
public class ParticipateProblemFileService {

    @Autowired
    private ParticipateProblemFileDao participateProblemFileDao;

    public List<ParticipateProblemFile> getByPage(Integer page, Integer limit, String id) {
        return participateProblemFileDao.queryByPage((page - 1) * limit, limit, id);
    }

    public Integer getTotalNum(String id) {
        return participateProblemFileDao.queryNumber(id);
    }

    public void add(ParticipateProblemFile participateProblemFile) {
        participateProblemFile.setProblemFileid(IdUtils.getPrimaryKey());
        participateProblemFileDao.insert(participateProblemFile);
    }

}
