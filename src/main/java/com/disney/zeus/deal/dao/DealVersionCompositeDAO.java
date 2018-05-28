package com.disney.zeus.deal.dao;

import com.disney.zeus.deal.rowmapper.DealVersionRowMapper;
import com.disney.zeus.deal.constants.DealVersionConstants;
import com.disney.zeus.deal.constants.DealVersionSQLConstants;
import com.disney.zeus.web.dto.deal.DealVersionDTO;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


public class DealVersionCompositeDAO {

    private SimpleJdbcTemplate simpleJdbcTemplate;

    public List<DealVersionDTO> viewDealVersions(Long dealId) {

        return simpleJdbcTemplate.query(
                DealVersionConstants.VIEW_DEAL_VERSIONS.getConstantValue(),
                new DealVersionRowMapper(), dealId);
    }


    public List<DealVersionDTO> dealVersionCreator(Long dealId) {

        return simpleJdbcTemplate.query(DealVersionSQLConstants.DEAL_VERSION_CREATOR,
                new DealVersionRowMapper(), dealId);
    }

    public void setSimpleJdbcTemplate(SimpleJdbcTemplate simpleJdbcTemplate) {
        this.simpleJdbcTemplate = simpleJdbcTemplate;
    }

}
