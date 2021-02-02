package user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import user.entity.ParticipateProject;

import java.util.List;

/**
 * (ParticipateProject)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-25 10:27:51
 */
@Mapper
public interface ParticipateProjectDao {

    /**
     * 通过ID查询单条数据
     *
     * @param participateProjectId 主键
     * @return 实例对象
     */
    ParticipateProject queryById(String participateProjectId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ParticipateProject> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param participateProject 实例对象
     * @return 对象列表
     */
    List<ParticipateProject> queryAll(ParticipateProject participateProject);

    /**
     * 新增数据
     *
     * @param participateProject 实例对象
     * @return 影响行数
     */
    int insert(ParticipateProject participateProject);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ParticipateProject> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ParticipateProject> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ParticipateProject> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<ParticipateProject> entities);

    /**
     * 修改数据
     *
     * @param participateProject 实例对象
     * @return 影响行数
     */
    int update(ParticipateProject participateProject);

    /**
     * 通过主键删除数据
     *
     * @param participateProjectId 主键
     * @return 影响行数
     */
    int deleteById(String participateProjectId);

    /**
     * 查询总数量
     */
    int queryNumber();

}