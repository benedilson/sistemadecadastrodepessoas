

angular.module('scp').controller('EditPessoaController', function($scope, $routeParams, $location, flash, PessoaResource , PessoaResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.pessoa = new PessoaResource(self.original);
            PessoaResource.queryAll(function(items) {
                $scope.loginOperadorSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.id
                    };
                    if($scope.pessoa.loginOperador && item.id == $scope.pessoa.loginOperador.id) {
                        $scope.loginOperadorSelection = labelObject;
                        $scope.pessoa.loginOperador = wrappedObject;
                        self.original.loginOperador = $scope.pessoa.loginOperador;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The pessoa could not be found.'});
            $location.path("/Pessoas");
        };
        PessoaResource.get({PessoaId:$routeParams.PessoaId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.pessoa);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The pessoa was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.pessoa.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Pessoas");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The pessoa was deleted.'});
            $location.path("/Pessoas");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.pessoa.$remove(successCallback, errorCallback);
    };
    
    $scope.$watch("loginOperadorSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.pessoa.loginOperador = {};
            $scope.pessoa.loginOperador.id = selection.value;
        }
    });
    
    $scope.get();
});