package com.disney.zeus.deal.service;

import com.disney.zeus.deal.entity.Deal;
import com.disney.zeus.deal.entity.DealAmendmentMemo;
import com.disney.zeus.web.dto.deal.DealVersionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DealAmendmentService")
public class DealAmendmentService {

    private static final String NO_ROLES= "";



    private DealVersionService dealVersionService;



    public String getRoleOfUserWhoCreatedVersion(Long dealId) {

        String lastVersionCreatedUser = null;
        List<DealVersionDTO> dealVersionDTO = dealVersionService.getVersionCreatedUserRole(dealId);

        if(dealVersionDTO.size()>0 && dealVersionDTO.get(0).getUser() != null ){
            lastVersionCreatedUser = dealVersionDTO.get(0).getUser();
        }
        else{
            lastVersionCreatedUser = NO_ROLES;
        }

        return lastVersionCreatedUser;
    }



    public DealAmendmentMemo updateExistingDeal(){

        Deal deal = new Deal();
        DealAmendmentMemo dealAmendmentMemo = new DealAmendmentMemo();
        Long dealId = deal.getDealId();


        List<DealVersionDTO> dealVersions = dealVersionService.getApolloDealVersions(dealId);
        if(dealVersions.size() >= 2){
            dealAmendmentMemo = createDealAmendmentMemo(deal, dealVersions);
        }


        return dealAmendmentMemo;

    }




    private DealAmendmentMemo createDealAmendmentMemo(Deal deal, List<DealVersionDTO> dealVersions) {

        DealAmendmentMemo dealAmendmentMemo = new DealAmendmentMemo();

        dealAmendmentMemo.setDeal(deal);

        dealAmendmentMemo.setNewVersion(dealVersions.get(0).getVersionNumber());
        dealAmendmentMemo.setOldVersion(dealVersions.get(1).getVersionNumber());

        dealAmendmentMemo.setUser(dealVersions.get(0).getUser());


        return dealAmendmentMemo;

    }

    public DealVersionService getDealVersionService() {
        return dealVersionService;
    }

    public void setDealVersionService(DealVersionService dealVersionService) {
        this.dealVersionService = dealVersionService;
    }

}
