package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.dao.ProjectDao;
import user.entity.Project;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectDao projectDao;

    /**
     * 通过主键查询
     */
    public Project queryById(String projectId) {
        return projectDao.queryById(projectId);
    }

    public List<Project> queryAll() {
        return projectDao.queryAll(null);
    }

}
