
angular.module('scp').controller('NewOperadorController', function ($scope, $location, locationParser, flash, OperadorResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.operador = $scope.operador || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The operador was created successfully.'});
            $location.path('/Operadors');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        OperadorResource.save($scope.operador, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Operadors");
    };
});