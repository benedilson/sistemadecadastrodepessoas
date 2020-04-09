
angular.module('scp').controller('NewPessoaController', function ($scope, $location, locationParser, flash, PessoaResource , PessoaResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.pessoa = $scope.pessoa || {};
    
    $scope.loginOperadorList = PessoaResource.queryAll(function(items){
        $scope.loginOperadorSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.id
            });
        });
    });
    $scope.$watch("loginOperadorSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.pessoa.loginOperador = {};
            $scope.pessoa.loginOperador.id = selection.value;
        }
    });
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The pessoa was created successfully.'});
            $location.path('/Pessoas');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        PessoaResource.save($scope.pessoa, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Pessoas");
    };
});