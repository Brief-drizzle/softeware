package user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import user.entity.AssistantAssessment;

import java.util.List;

/**
 * (AssistantAssessment)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-25 10:27:39
 */
@Mapper
public interface AssistantAssessmentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param assessmentId 主键
     * @return 实例对象
     */
    AssistantAssessment queryById(String assessmentId);
    AssistantAssessment queryByCoursePost(@Param("courseId") String courseId,@Param("postId") String postId);
    AssistantAssessment getMax();
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AssistantAssessment> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);
    List<AssistantAssessment> listAllByPost(String id);
    List<AssistantAssessment> listAll();
    List<AssistantAssessment> listAllByCourse(String courseid);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param assistantAssessment 实例对象
     * @return 对象列表
     */
    List<AssistantAssessment> queryAll(AssistantAssessment assistantAssessment);

    /**
     * 新增数据
     *
     * @param assistantAssessment 实例对象
     * @return 影响行数
     */
    int insert(AssistantAssessment assistantAssessment);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<AssistantAssessment> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<AssistantAssessment> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<AssistantAssessment> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<AssistantAssessment> entities);

    /**
     * 修改数据
     *
     * @param assistantAssessment 实例对象
     * @return 影响行数
     */
    int update(AssistantAssessment assistantAssessment);

    /**
     * 通过主键删除数据
     *
     * @param assessmentId 主键
     * @return 影响行数
     */
    int deleteById(String assessmentId);

}