'use strict';

moduleUsuario.controller('usuarioEditController', ['$scope', '$http', '$location', 'toolService', '$routeParams', '$uibModal',
    function ($scope, $http, $location, toolService, $routeParams, $uibModal) {
        $scope.id = $routeParams.id;
        $scope.ob = "usuario";
        $http({
            method: 'GET',
            url: '/json?ob=' + $scope.ob + '&op=get&id=' + $scope.id
        }).then(function (response) {
            $scope.status = response.status;
            $scope.ajaxDatoUsuario = response.data.message;
        }, function (response) {
            $scope.ajaxDatoUsuario = response.data.message || 'Request failed';
            $scope.status = response.status;
        });


        $scope.guardar = function () {
            var json = {
                id: $scope.ajaxDatoUsuario.id,
                dni: $scope.ajaxDatoUsuario.dni,
                nombre: $scope.ajaxDatoUsuario.nombre,
                ape1: $scope.ajaxDatoUsuario.ape1,
                ape2: $scope.ajaxDatoUsuario.ape2,
                login: $scope.ajaxDatoUsuario.login,
                pass: forge_sha256($scope. jaxDatoUsuario.pass),
                id_tipoUsuario: $scope.ajaxDatoUsuario.obj_tipoUsuario.id
            }
            $http({
                method: 'GET',
                header: {
                    'Content-Type': 'application/json;charset=utf-8'
                },
                url: '/json?ob=' + $scope.ob + '&op=update',
                params: {json: JSON.stringify(json)}
            }).then(function (response) {
                $scope.status = response.status;
                $scope.mensaje = true;
            }, function (response) {
                $scope.ajaxDataUsuario = response.data.message || 'Request failed';
                $scope.status = response.status;
            });
        };
        $scope.isActive = toolService.isActive;

        $scope.openModal = function (size) {
            $uibModal.open({
                animation: true,
                ariaLabelledBy: 'modal-title',
                ariaDescribedBy: 'modal-body',
                templateUrl: '/trolleyes-client/public_html/js/app/tipousuario/selection.html',
                controller: 'tipousuarioSelectionController',
                size: size
//                resolve: {
//                    ajaxDatoUsuario.obj_tipoUsuario.id = id;             
//                }               
            })};
    }]);
