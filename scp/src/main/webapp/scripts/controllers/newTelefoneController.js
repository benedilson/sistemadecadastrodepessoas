
angular.module('scp').controller('NewTelefoneController', function ($scope, $location, locationParser, flash, TelefoneResource , OperadorResource, PessoaResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.telefone = $scope.telefone || {};
    
    $scope.loginOperadorList = OperadorResource.queryAll(function(items){
        $scope.loginOperadorSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.id
            });
        });
    });
    $scope.$watch("loginOperadorSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.telefone.loginOperador = {};
            $scope.telefone.loginOperador.id = selection.value;
        }
    });
    
    $scope.idPessoaList = PessoaResource.queryAll(function(items){
        $scope.idPessoaSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.id
            });
        });
    });
    $scope.$watch("idPessoaSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.telefone.idPessoa = {};
            $scope.telefone.idPessoa.id = selection.value;
        }
    });
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The telefone was created successfully.'});
            $location.path('/Telefones');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        TelefoneResource.save($scope.telefone, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Telefones");
    };
});