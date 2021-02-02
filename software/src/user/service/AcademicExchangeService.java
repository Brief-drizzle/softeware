package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.dao.AcademicExchangeDao;
import user.entity.AcademicExchange;

import java.util.List;

@Service
public class AcademicExchangeService {

    @Autowired
    private AcademicExchangeDao academicExchangeDao;

    public List<AcademicExchange> getByPage(Integer page, Integer limit, String self) {
        return academicExchangeDao.queryAllByLimit((page - 1) * limit, limit, self);
    }

    public Integer getTotalNum() {
        return academicExchangeDao.queryNumber();
    }

    public AcademicExchange getById(String id) {
        return academicExchangeDao.queryById(id);
    }

    public void add(AcademicExchange academicExchange) {
        academicExchangeDao.insert(academicExchange);
    }

    public void approval(String id) {
        academicExchangeDao.approval(id);
    }

    public void approvalFromDirector(String id) {
        academicExchangeDao.approvalFromDirector(id);
    }

}
