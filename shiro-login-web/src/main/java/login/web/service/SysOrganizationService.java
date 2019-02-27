package login.web.service;

import login.web.model.SysOrganization;

import java.util.List;

/**
 * desc : SysOrganization
 * Created by weichen on  2018/09/18.
 */
public interface SysOrganizationService {

	SysOrganization createOrganization(SysOrganization organization);

	SysOrganization updateOrganization(SysOrganization organization);

	void deleteOrganization(Long organizationId);

	SysOrganization findOne(Long organizationId);

	List<SysOrganization> findAll();

	Object findAllWithExclude(SysOrganization excludeOraganization);

	void move(SysOrganization source, SysOrganization target);
}