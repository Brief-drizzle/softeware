package user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import user.entity.ParticipateProblemFile;

import java.util.List;

/**
 * (ParticipateProblemFile)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-25 10:27:50
 */
@Mapper
public interface ParticipateProblemFileDao {

    /**
     * 通过ID查询单条数据
     *
     * @param problemFileid 主键
     * @return 实例对象
     */
    ParticipateProblemFile queryById(String problemFileid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ParticipateProblemFile> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param participateProblemFile 实例对象
     * @return 对象列表
     */
    List<ParticipateProblemFile> queryAll(ParticipateProblemFile participateProblemFile);

    /**
     * 新增数据
     *
     * @param participateProblemFile 实例对象
     * @return 影响行数
     */
    int insert(ParticipateProblemFile participateProblemFile);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ParticipateProblemFile> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ParticipateProblemFile> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ParticipateProblemFile> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<ParticipateProblemFile> entities);

    /**
     * 修改数据
     *
     * @param participateProblemFile 实例对象
     * @return 影响行数
     */
    int update(ParticipateProblemFile participateProblemFile);

    /**
     * 通过主键删除数据
     *
     * @param problemFileid 主键
     * @return 影响行数
     */
    int deleteById(String problemFileid);

}