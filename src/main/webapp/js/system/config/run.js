wildcart.run(['$rootScope', 'sessionService', '$location', '$http','countcarritoService',
    function ($rootScope, oSessionService, $location, $http,countcarritoService) {
        $rootScope.$on("$routeChangeStart", function (event, next, current) {

            var nextUrl = next.$$route.originalPath;

            $http({
                method: 'GET',
                url: '/json?ob=usuario&op=check'
            }).then(function (response) {
                if (response.data.status === 200) {
                    oSessionService.setSessionActive();
                    oSessionService.setUserName(response.data.message.nombre + " " + response.data.message.ape1);
                    oSessionService.setId(response.data.message.id);
                } else {
                    oSessionService.setSessionInactive;
                    if (nextUrl !== "/" && nextUrl !== "/home" && nextUrl !== "/usuario/login") {
                        $location.path("/home");
                    }
                }
            }, function (response) {
                oSessionService.setSessionInactive;
                if (nextUrl !== '/' && nextUrl !== '/home' && nextUrl !== '/usuario/login') {
                    $location.path("/home");
                }

            });

            countcarritoService.updateCarrito();



        });


    }]);