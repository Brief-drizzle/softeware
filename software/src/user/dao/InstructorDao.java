package user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import user.entity.Instructor;

import java.util.List;

/**
 * (Instructor)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-25 10:27:41
 */
@Mapper
public interface InstructorDao {

    /**
     * 通过ID查询单条数据
     *
     * @param instructorId 主键
     * @return 实例对象
     */
    Instructor queryById(String instructorId);
    Instructor queryByteaId(String teaId);
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Instructor> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param instructor 实例对象
     * @return 对象列表
     */
    List<Instructor> queryAll(Instructor instructor);

    /**
     * 新增数据
     *
     * @param instructor 实例对象
     * @return 影响行数
     */
    int insert(Instructor instructor);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Instructor> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Instructor> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Instructor> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Instructor> entities);

    /**
     * 修改数据
     *
     * @param instructor 实例对象
     * @return 影响行数
     */
    int update(Instructor instructor);

    /**
     * 通过主键删除数据
     *
     * @param instructorId 主键
     * @return 影响行数
     */
    int deleteById(String instructorId);

}