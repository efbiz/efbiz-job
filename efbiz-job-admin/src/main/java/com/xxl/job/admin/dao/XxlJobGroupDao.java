package com.xxl.job.admin.dao;

import java.util.List;
import javax.annotation.Resource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.xxl.job.admin.core.model.XxlJobGroup;

/**
 * Created by xuxueli on 16/9/30.
 */
@Repository
public class XxlJobGroupDao   {

    @Resource
    public SqlSessionTemplate sqlSessionTemplate;

    public List<XxlJobGroup> findAll() {
        return sqlSessionTemplate.selectList("XxlJobGroupMapper.findAll");
    }

    public int save(XxlJobGroup xxlJobGroup) {
        return sqlSessionTemplate.update("XxlJobGroupMapper.save", xxlJobGroup);
    }

    public int update(XxlJobGroup xxlJobGroup) {
        return sqlSessionTemplate.update("XxlJobGroupMapper.update", xxlJobGroup);
    }

    public int remove(int id) {
        return sqlSessionTemplate.delete("XxlJobGroupMapper.remove", id);
    }

    public XxlJobGroup load(int id) {
        return sqlSessionTemplate.selectOne("XxlJobGroupMapper.load", id);
    }


}
