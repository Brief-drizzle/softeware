package user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import user.entity.Tutor;

import java.util.List;

/**
 * (Tutor)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-25 10:27:57
 */
@Mapper
public interface TutorDao {

    /**
     * 通过ID查询单条数据
     *
     * @param tutorId 主键
     * @return 实例对象
     */
    Tutor queryById(String tutorId);
    Tutor queryByTeaid(String teaid);
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Tutor> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tutor 实例对象
     * @return 对象列表
     */
    List<Tutor> queryAll(Tutor tutor);

    /**
     * 新增数据
     *
     * @param tutor 实例对象
     * @return 影响行数
     */
    int insert(Tutor tutor);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Tutor> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Tutor> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Tutor> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Tutor> entities);

    /**
     * 修改数据
     *
     * @param tutor 实例对象
     * @return 影响行数
     */
    int update(Tutor tutor);

    /**
     * 通过主键删除数据
     *
     * @param tutorId 主键
     * @return 影响行数
     */
    int deleteById(String tutorId);

}