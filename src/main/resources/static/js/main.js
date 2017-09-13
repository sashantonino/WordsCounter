var mainApp = angular.module("main", []);

mainApp.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs){
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;

            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);

mainApp.service('CountingService', ['$http', function($http) {
    this.sendFile = function (file, uploadUrl) {
        var fd = new FormData();
        fd.append('file', file);

        return $http.post(uploadUrl, fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
            .then(function (resp) {
                console.log("Response status for img uploading: " + resp.status);
                return resp.data;
            });
    };
}]);

mainApp.controller("WordCounterController", WordCounterController);

function WordCounterController(CountingService, $scope) {
    
    $scope.calculate = function () {
        var file = $scope.fileModel;
        var url =  "/countWords";
        CountingService.sendFile(file, url).then(function (res) {
            $scope.words = res;
        });
    };
}
