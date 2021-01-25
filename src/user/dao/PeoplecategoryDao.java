package user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import user.entity.Peoplecategory;

import java.util.List;

/**
 * (Peoplecategory)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-25 10:27:35
 */
@Mapper
public interface PeoplecategoryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param peoplecategoryId 主键
     * @return 实例对象
     */
    Peoplecategory queryById(String peoplecategoryId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Peoplecategory> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param peoplecategory 实例对象
     * @return 对象列表
     */
    List<Peoplecategory> queryAll(Peoplecategory peoplecategory);

    /**
     * 新增数据
     *
     * @param peoplecategory 实例对象
     * @return 影响行数
     */
    int insert(Peoplecategory peoplecategory);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Peoplecategory> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Peoplecategory> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Peoplecategory> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Peoplecategory> entities);

    /**
     * 修改数据
     *
     * @param peoplecategory 实例对象
     * @return 影响行数
     */
    int update(Peoplecategory peoplecategory);

    /**
     * 通过主键删除数据
     *
     * @param peoplecategoryId 主键
     * @return 影响行数
     */
    int deleteById(String peoplecategoryId);

}