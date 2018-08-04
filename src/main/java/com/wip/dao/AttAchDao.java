/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/8/3 16:25
 **/
package com.wip.dao;

import com.wip.dto.AttAchDto;
import com.wip.model.AttAchDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 文件相关Dao接口
 */
@Mapper
public interface AttAchDao {

    /**
     * 添加单个附件文件
     * @param attAchDomain
     */
    void addAttAch(AttAchDomain attAchDomain);

    /**
     * 获取所有的附件信息
     * @return
     */
    List<AttAchDto> getAtts();
}
