package com.disney.zeus.deal.constants;

public class DealVersionSQLConstants {

    public static final String DEAL_VERSION_CREATOR ="SELECT  max (VERSION_NUMBER) , VERSION_TS ,NAME "
            +"FROM DEAL_VERSION_MASTER DVM "
            +"JOIN DPS_USER DU ON DU.ID = DVM.USER_ID "
            +"JOIN DPS_USER_ROLES DUR ON DUR.USER_ID = DVM.USER_ID "
            +"JOIN DPS_ROLE DR ON  DR.ROLE_ID = DUR.ATG_ROLE "
            +"WHERE DEAL_ID = ? "
            +"group by VERSION_NUMBER ,VERSION_TS,NAME "
            +"order by VERSION_NUMBER desc ";

}
