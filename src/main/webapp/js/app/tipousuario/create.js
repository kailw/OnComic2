'use strict';

moduleTipousuario.controller('tipousuarioCreateController', ['$scope', '$http', '$location', 'toolService', '$routeParams', 'sessionService',
    function ($scope, $http, $location, toolService, $routeParams, sessionService) {
        $scope.id = $routeParams.id;
        $scope.ob = "tipousuario";


        $scope.guardar = function () {
            var json = {
                id: null,
                desc: $scope.desc
            }
            $http({
                method: 'GET',
                withCredentials: true,
                url: '/json?ob=' + $scope.ob + '&op=create',
                params: {json: JSON.stringify(json)}
            }).then(function (response) {
                $scope.status = response.status;
                $scope.idCreado = response.data.message.id;
                $scope.mensaje = true;
            }, function (response) {               
                $scope.status = response.status;
            });
        };
        $scope.isActive = toolService.isActive;

    }]);