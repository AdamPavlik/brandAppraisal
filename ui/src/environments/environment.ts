// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.

export const environment = {
    production          : false,
    API_URL             : 'http://localhost:8080/api',
    NO_AUTH_PREFIX      : 'http://localhost:8080/api/public',
    LOGIN_PAGE          : '/login',
    OAUTH2_BASIC        : 'Basic YWRtaW46YWRtaW4=',
    TOKEN_NAME          : 'market_security_token',
    hostName            : 'localhost:4200',
    current_user_key    : 'currentUser'
};
