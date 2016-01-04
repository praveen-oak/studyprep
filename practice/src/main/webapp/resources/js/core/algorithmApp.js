var app = angular.module('algorithmApp', []);

app.filter('prettyJSON', function () {
    function prettyPrintJson(json) {

        console.log("Pretty printing JSON");
        return JSON ? JSON.stringify(json, null, '  ') : 'your browser doesnt support JSON so cant pretty print';
    }
    return prettyPrintJson;
});

app.controller('algorithmController', function ($scope, $http) {

    $scope.showAnimation = false;
    $scope.showResults = false;
    $scope.showValidationError = false;

    $scope.algorithmTypeOptions = [];
    $scope.algorithmConfig = {};
    $scope.algorithmResponse = {};

    $scope.selectedAlgorithmTypeOption = '';
    $scope.selectedAlgorithmOption = '';
    $scope.validationError = '';

    $scope.loadConfig = function() {

        request = $http({
            method: 'GET',
            url: "load-algorithm-config"
        });

        request.success(function(data){

            $scope.algorithmConfig = data
            $scope.algorithmTypeOptions = data.algorithmTypes;
            console.log(data);

        });
    }

    $scope.triggerAlgorithm = function() {


        if ($scope.validateRequest()) {

            $scope.showValidationError = true;
            return
        }

        $scope.showAnimation = true;
        var triggerUrl = "invoke-algorithm/" + $scope.selectedAlgorithmTypeOption + "/" + $scope.selectedAlgorithmOption

        request = $http({
            method: 'GET',
            url: triggerUrl
        });

        request.success(function(data){

            console.log(data);
            $scope.algorithmResponse = data;
            $scope.showAnimation = false;
            $scope.showResults = true;

        });

    }

    $scope.loadAlgorithmList = function() {

        if ($scope.selectedAlgorithmTypeOption != '') {

            var jsonList = angular.fromJson($scope.algorithmConfig.algorithmList);
            var selectedOption = $scope.selectedAlgorithmTypeOption;

            return jsonList[selectedOption];
        }

        return [];
    }

    $scope.closeResults = function() {

        $scope.algorithmResponse = {};
        $scope.selectedAlgorithmOption = '';
        $scope.showResults = false;

    }

    $scope.validateRequest = function() {

        var isValid = true;

        if ($scope.selectedAlgorithmTypeOption == '') {

            $scope.validationError = 'Please select algorithm type.';

        } else if ($scope.selectedAlgorithmOption == '') {

            $scope.validationError = 'Please select algorithm.';

        } else {

            $scope.validationError = '';
            $scope.showValidationError = false;
            isValid = false;

        }

        return isValid;
    }

    $scope.loadConfig();
})
