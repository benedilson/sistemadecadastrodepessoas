angular.module('scp').factory('OperadorResource', function($resource){
    var resource = $resource('rest/operadors/:OperadorId',{OperadorId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});