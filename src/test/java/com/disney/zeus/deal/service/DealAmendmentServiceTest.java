package com.disney.zeus.deal.service;

import com.disney.zeus.deal.entity.DealAmendmentMemo;
import com.disney.zeus.web.dto.deal.DealVersionDTO;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static io.github.benas.randombeans.api.EnhancedRandom.random;

import static org.assertj.core.api.Assertions.*;

import static org.mockito.Mockito.when;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class DealAmendmentServiceTest {

    @Test
    public void getRoleOfUserWhoCreatedVersion() {

        DealVersionService dealVersionServiceMock = Mockito.mock(DealVersionService.class);


        List<DealVersionDTO> dealVersionsBVI = new ArrayList<DealVersionDTO>();

        DealVersionDTO dto1 = random(DealVersionDTO.class);
        String role = "BVI_USER";
        dto1.setUser( role );
        dealVersionsBVI.add(dto1);

        List<DealVersionDTO> dealVersionsNoRoles = new ArrayList<DealVersionDTO>();



        when(dealVersionServiceMock.getVersionCreatedUserRole(1L)).thenReturn(dealVersionsBVI);
        when(dealVersionServiceMock.getVersionCreatedUserRole(2L)).thenReturn(dealVersionsNoRoles);

        DealAmendmentService dealAmendmentService = new DealAmendmentService();
        dealAmendmentService.setDealVersionService(dealVersionServiceMock);

        String role1 = dealAmendmentService.getRoleOfUserWhoCreatedVersion(1L );
        assertThat(role1).isEqualTo(role);

        String noRoles = dealAmendmentService.getRoleOfUserWhoCreatedVersion(2L );
        assertThat(noRoles).isEqualTo("");


    }

    @Test
    public void updateExistingDeal() {

        DealVersionService dealVersionServiceMock = Mockito.mock(DealVersionService.class);

        List<DealVersionDTO> dealVersions1 = new ArrayList<DealVersionDTO>();
        DealVersionDTO dto1 = random(DealVersionDTO.class);
        DealVersionDTO dto2 = random(DealVersionDTO.class);
        Faker versionNumberFaker = new Faker();

        int originalVersionNumber = versionNumberFaker.number().numberBetween(1,10);
        int newVersionNumber = originalVersionNumber + 1;

        Faker nameFaker = new Faker();
        String originalUsername = nameFaker.name().fullName();
        String newUsername = nameFaker.name().fullName();

        dto1.setUser( originalUsername );
        dto1.setVersionNumber(new Integer(originalVersionNumber).toString());

        dto2.setUser( newUsername );
        dto2.setVersionNumber(new Integer(newVersionNumber).toString());

        dealVersions1.add(dto1);
        dealVersions1.add(dto2);


        when(dealVersionServiceMock.getApolloDealVersions(1L)).thenReturn(dealVersions1);

        DealAmendmentService dealAmendmentService = new DealAmendmentService();
        dealAmendmentService.setDealVersionService( dealVersionServiceMock );

        DealAmendmentMemo memo = dealAmendmentService.updateExistingDeal();

        assertThat( memo.getUser() )

    }
}