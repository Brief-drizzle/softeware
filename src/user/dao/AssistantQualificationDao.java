package user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import user.entity.AssistantQualification;

import java.util.List;

/**
 * (AssistantQualification)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-25 10:27:44
 */
@Mapper
public interface AssistantQualificationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param assistantQualificationId 主键
     * @return 实例对象
     */
    AssistantQualification queryById(String assistantQualificationId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AssistantQualification> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param assistantQualification 实例对象
     * @return 对象列表
     */
    List<AssistantQualification> queryAll(AssistantQualification assistantQualification);

    /**
     * 新增数据
     *
     * @param assistantQualification 实例对象
     * @return 影响行数
     */
    int insert(AssistantQualification assistantQualification);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<AssistantQualification> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<AssistantQualification> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<AssistantQualification> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<AssistantQualification> entities);

    /**
     * 修改数据
     *
     * @param assistantQualification 实例对象
     * @return 影响行数
     */
    int update(AssistantQualification assistantQualification);

    /**
     * 通过主键删除数据
     *
     * @param assistantQualificationId 主键
     * @return 影响行数
     */
    int deleteById(String assistantQualificationId);

}