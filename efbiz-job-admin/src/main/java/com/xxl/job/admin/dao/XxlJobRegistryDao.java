package com.xxl.job.admin.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.xxl.job.admin.core.model.XxlJobRegistry;

/**
 * Created by xuxueli on 16/9/30.
 */
@Repository
public class XxlJobRegistryDao  {

    @Resource
    public SqlSessionTemplate sqlSessionTemplate;

    
    public int removeDead(int timeout) {
        return sqlSessionTemplate.delete("XxlJobRegistryMapper.removeDead", timeout);
    }

    
    public List<XxlJobRegistry> findAll(int timeout) {
        return sqlSessionTemplate.selectList("XxlJobRegistryMapper.findAll", timeout);
    }

    
    public int registryUpdate(String registryGroup, String registryKey, String registryValue) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("registryGroup", registryGroup);
        params.put("registryKey", registryKey);
        params.put("registryValue", registryValue);

        return sqlSessionTemplate.update("XxlJobRegistryMapper.registryUpdate", params);
    }

    
    public int registrySave(String registryGroup, String registryKey, String registryValue) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("registryGroup", registryGroup);
        params.put("registryKey", registryKey);
        params.put("registryValue", registryValue);

        return sqlSessionTemplate.update("XxlJobRegistryMapper.registrySave", params);
    }

}
