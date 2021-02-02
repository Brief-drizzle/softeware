package user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import user.entity.Director;

import java.util.List;

/**
 * (Director)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-25 10:27:48
 */
@Mapper
public interface DirectorDao {

    /**
     * 通过ID查询单条数据
     *
     * @param directorId 主键
     * @return 实例对象
     */
    Director queryById(String directorId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Director> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param director 实例对象
     * @return 对象列表
     */
    List<Director> queryAll(Director director);

    /**
     * 新增数据
     *
     * @param director 实例对象
     * @return 影响行数
     */
    int insert(Director director);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Director> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Director> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Director> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Director> entities);

    /**
     * 修改数据
     *
     * @param director 实例对象
     * @return 影响行数
     */
    int update(Director director);

    /**
     * 通过主键删除数据
     *
     * @param directorId 主键
     * @return 影响行数
     */
    int deleteById(String directorId);

}