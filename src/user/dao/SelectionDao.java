package user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import user.entity.Selection;

import java.util.List;

/**
 * (Selection)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-25 10:27:38
 */
@Mapper
public interface SelectionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param selectionId 主键
     * @return 实例对象
     */
    Selection queryById(String selectionId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Selection> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param selection 实例对象
     * @return 对象列表
     */
    List<Selection> queryAll(Selection selection);

    /**
     * 新增数据
     *
     * @param selection 实例对象
     * @return 影响行数
     */
    int insert(Selection selection);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Selection> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Selection> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Selection> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Selection> entities);

    /**
     * 修改数据
     *
     * @param selection 实例对象
     * @return 影响行数
     */
    int update(Selection selection);

    /**
     * 通过主键删除数据
     *
     * @param selectionId 主键
     * @return 影响行数
     */
    int deleteById(String selectionId);

}