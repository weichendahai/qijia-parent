package login.web.service.impl;


import login.web.dao.SysOrganizationDao;
import login.web.model.SysOrganization;
import login.web.service.SysOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * desc : SysOrganization
 * Created by weichen on  2018/09/18.
 */
@Service
public class SysOrganizationServiceImpl implements SysOrganizationService {

	@Autowired
	SysOrganizationDao organizationDao;

	public SysOrganization createOrganization(SysOrganization organization) {
		organizationDao.insert(organization);
		return organization;
	}

	public SysOrganization updateOrganization(SysOrganization organization) {
		organizationDao.updateById(organization);
		return organization;
	}

	public void deleteOrganization(Long organizationId) {
		organizationDao.deleteById(organizationId);
	}

	public SysOrganization findOne(Long organizationId) {
		SysOrganization sysOrganization = organizationDao.selectById(organizationId);
		return sysOrganization;
	}

	public List<SysOrganization> findAll() {
		List<SysOrganization> sysOrganizations = organizationDao.selectList(null);
		return sysOrganizations;
	}

	public Object findAllWithExclude(SysOrganization excludeOraganization) {
		return null;
	}

	public void move(SysOrganization source, SysOrganization target) {

	}
}
