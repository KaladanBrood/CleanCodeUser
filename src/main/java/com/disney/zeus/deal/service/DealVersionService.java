package com.disney.zeus.deal.service;

import com.disney.zeus.deal.dao.DealVersionCompositeDAO;
import com.disney.zeus.web.dto.deal.DealVersionDTO;
import org.springframework.stereotype.Service;


import java.util.List;

@Service("DealVersionService")
public class DealVersionService {


    private DealVersionCompositeDAO dealVersionCompositeDAO;


    public List<DealVersionDTO> getApolloDealVersions(Long dealId){
        return dealVersionCompositeDAO.viewDealVersions(dealId);
    }

    public List<DealVersionDTO> getVersionCreatedUserRole(Long dealId){
        return dealVersionCompositeDAO.dealVersionCreator(dealId);
    }


    public DealVersionCompositeDAO getDealVersionCompositeDAO() {
        return dealVersionCompositeDAO;
    }

    public void setDealVersionCompositeDAO(DealVersionCompositeDAO dealVersionCompositeDAO) {
        this.dealVersionCompositeDAO = dealVersionCompositeDAO;
    }


}
