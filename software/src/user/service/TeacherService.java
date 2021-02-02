package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.dao.TeacherDao;
import user.entity.Teacher;

@Service
public class TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    /**
     * 通过逐渐查询
     */
    public Teacher queryById(String teacherId) {
        return teacherDao.queryById(teacherId);
    }

}
