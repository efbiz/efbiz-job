package com.xxl.job.admin.dao;

import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.xxl.job.admin.core.model.XxlJobInfo;

/**
 * job info
 * @author xuxueli 2016-1-12 18:03:45
 */
@Repository
public class XxlJobInfoDao{
	
	@Resource
	public SqlSessionTemplate sqlSessionTemplate;

	
	public List<XxlJobInfo> pageList(int offset, int pagesize, int jobGroup, String executorHandler) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("offset", offset);
		params.put("pagesize", pagesize);
		params.put("jobGroup", jobGroup);
		params.put("executorHandler", executorHandler);
		
		return sqlSessionTemplate.selectList("XxlJobInfoMapper.pageList", params);
	}

	
	public int pageListCount(int offset, int pagesize, int jobGroup, String executorHandler) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("offset", offset);
		params.put("pagesize", pagesize);
		params.put("jobGroup", jobGroup);
		params.put("executorHandler", executorHandler);
		
		return sqlSessionTemplate.selectOne("XxlJobInfoMapper.pageListCount", params);
	}

	
	public int save(XxlJobInfo info) {
		return sqlSessionTemplate.insert("XxlJobInfoMapper.save", info);
	}

	
	public XxlJobInfo loadById(int id) {
		return sqlSessionTemplate.selectOne("XxlJobInfoMapper.loadById", id);
	}

	
	public int update(XxlJobInfo item) {
		return sqlSessionTemplate.update("XxlJobInfoMapper.update", item);
	}

	
	public int delete(int id) {
		return sqlSessionTemplate.update("XxlJobInfoMapper.delete", id);
	}

	
	public List<XxlJobInfo> getJobsByGroup(String jobGroup) {
		return sqlSessionTemplate.selectList("XxlJobInfoMapper.getJobsByGroup", jobGroup);
	}

	
	public int findAllCount() {
		return sqlSessionTemplate.selectOne("XxlJobInfoMapper.findAllCount");
	}

}
