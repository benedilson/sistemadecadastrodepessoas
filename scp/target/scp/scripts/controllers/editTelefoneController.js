

angular.module('scp').controller('EditTelefoneController', function($scope, $routeParams, $location, flash, TelefoneResource , OperadorResource, PessoaResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.telefone = new TelefoneResource(self.original);
            OperadorResource.queryAll(function(items) {
                $scope.loginOperadorSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.id
                    };
                    if($scope.telefone.loginOperador && item.id == $scope.telefone.loginOperador.id) {
                        $scope.loginOperadorSelection = labelObject;
                        $scope.telefone.loginOperador = wrappedObject;
                        self.original.loginOperador = $scope.telefone.loginOperador;
                    }
                    return labelObject;
                });
            });
            PessoaResource.queryAll(function(items) {
                $scope.idPessoaSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.id
                    };
                    if($scope.telefone.idPessoa && item.id == $scope.telefone.idPessoa.id) {
                        $scope.idPessoaSelection = labelObject;
                        $scope.telefone.idPessoa = wrappedObject;
                        self.original.idPessoa = $scope.telefone.idPessoa;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The telefone could not be found.'});
            $location.path("/Telefones");
        };
        TelefoneResource.get({TelefoneId:$routeParams.TelefoneId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.telefone);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The telefone was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.telefone.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Telefones");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The telefone was deleted.'});
            $location.path("/Telefones");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.telefone.$remove(successCallback, errorCallback);
    };
    
    $scope.$watch("loginOperadorSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.telefone.loginOperador = {};
            $scope.telefone.loginOperador.id = selection.value;
        }
    });
    $scope.$watch("idPessoaSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.telefone.idPessoa = {};
            $scope.telefone.idPessoa.id = selection.value;
        }
    });
    
    $scope.get();
});