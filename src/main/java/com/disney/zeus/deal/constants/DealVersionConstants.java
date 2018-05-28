package com.disney.zeus.deal.constants;

public enum DealVersionConstants {

    VIEW_DEAL_VERSIONS(
            "SELECT CONCAT(TRIM(CHAR(D.DEAL_MAJOR_VERSION)),CONCAT('.',TRIM(CHAR(D.DEAL_MINOR_VERSION)))), DVM.VERSION_TS, CONCAT(CONCAT(TRIM(DPS.FIRST_NAME),' '),DPS.LAST_NAME) FROM DEAL_VERSION_MASTER DVM "
                    + " JOIN DEAL_VER D ON DVM.DEAL_ID = D.DEAL_ID  AND DVM.DEAL_VERSION_MASTER_ID = D.DEAL_VERSION_MASTER_ID "
                    + " JOIN USER U ON DVM.USER_ID = U.USER_ID  "
                    + " JOIN DPS_USER DPS ON DPS.ID = U.USER_ID "
                    + " WHERE  DVM.DEAL_ID = ? ORDER BY DVM.VERSION_TS DESC ");

    private final String constantValue;

    private DealVersionConstants(String constantValue) {
        this.constantValue = constantValue;
    }

    public String getConstantValue() {
        return constantValue;
    }

}
