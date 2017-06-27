package com.xxl.job.admin.dao;

import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.xxl.job.admin.core.model.XxlJobLogGlue;

/**
 * job log for glue
 * @author xuxueli 2016-5-19 18:17:52
 */
@Repository
public class XxlJobLogGlueDao{

    @Resource
    public SqlSessionTemplate sqlSessionTemplate;
    
    
    public int save(XxlJobLogGlue xxlJobLogGlue) {
        return sqlSessionTemplate.insert("XxlJobLogGlueMapper.save", xxlJobLogGlue);
    }

    
    public List<XxlJobLogGlue> findByJobId(int jobId) {
        return sqlSessionTemplate.selectList("XxlJobLogGlueMapper.findByJobId", jobId);
    }

    
    public int removeOld(int jobId, int limit) {
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("jobId", jobId);
        params.put("limit", limit);
        return sqlSessionTemplate.delete("XxlJobLogGlueMapper.removeOld", params);
    }

    
    public int deleteByJobId(int jobId) {
        return sqlSessionTemplate.delete("XxlJobLogGlueMapper.deleteByJobId", jobId);
    }
    
}
