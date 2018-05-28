package com.disney.zeus.deal.rowmapper;

import com.disney.zeus.web.dto.deal.DealVersionDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DealVersionRowMapper implements RowMapper<DealVersionDTO> {


    public DealVersionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

        DealVersionDTO dealVersionDTO = new DealVersionDTO();
        dealVersionDTO.setVersionNumber(rs.getString(1));
        dealVersionDTO.setDate(rs.getDate(2));
        dealVersionDTO.setUser(rs.getString(3));

        return dealVersionDTO;
    }

}
