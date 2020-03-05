package com.neofect.gts.core.config;

/**
 * Created by guava on 5/26/16.
 */
public class Constants {
    private Constants() {
    }

    public static final String SPRING_PROFILE_DEVELOPMENT = "dev";
    public static final String SPRING_PROFILE_EXTERNAL = "external";
    public static final String SPRING_PROFILE_LOCAL = "local";
    public static final String SPRING_PROFILE_PRODUCTION = "prod";

    public static final String SKIP_PAGING = "SKIP_PAGING";

    public static final String CONDITION_PARAM_KEY = "q.";

    public static final String CURRENT_PAGE = "currentPage";

    public static final String DATA_PER_PAGE = "dataPerPage";

    public static final String LINK_PER_PAGE = "linkPerPage";

    public static final String ORDER_KEY = "orderKey";

    public static final String ORDER_VALUE = "orderValue";

    public static final Integer DEFAULT_DATA_PER_PAGE = 10;

    public static final Integer DEFAULT_PAGE_LINK_COUNT = 10;

    public static final String PAGER_TOOL = "pager";

    public static final String SESSION_AUTHENTICATION_FAILURE_COUNT = "sessionAuthenticationFailureCount";
}
