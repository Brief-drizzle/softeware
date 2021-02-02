package user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import user.entity.Teach;

import java.util.List;

/**
 * (Teach)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-25 10:27:40
 */
@Mapper
public interface TeachDao {

    /**
     * 通过ID查询单条数据
     *
     * @param instructorId 主键
     * @return 实例对象
     */
    List<Teach> queryById(String instructorId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Teach> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param teach 实例对象
     * @return 对象列表
     */
    List<Teach> queryAll(Teach teach);

    /**
     * 新增数据
     *
     * @param teach 实例对象
     * @return 影响行数
     */
    int insert(Teach teach);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Teach> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Teach> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Teach> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Teach> entities);

    /**
     * 修改数据
     *
     * @param teach 实例对象
     * @return 影响行数
     */
    int update(Teach teach);

    /**
     * 通过主键删除数据
     *
     * @param instructorId 主键
     * @return 影响行数
     */
    int deleteById(String instructorId);

}