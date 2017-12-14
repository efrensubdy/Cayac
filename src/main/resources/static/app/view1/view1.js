'use strict';

angular.module('myApp.view1', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view1', {
    templateUrl: 'view1/view1.html',
    controller: 'View1Ctrl'
  });
}])

.controller('View1Ctrl', ['$mdDialog','$location', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','$window','example','exam',function($mdDialog,$location, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,$window,example,exam) {
//$scope.bandera1 = false;
//var a = new Example();
//a.id =1;
//a.name ="papu";
//example.save(a,function(){
  //  console.log("sirvio la marikada");
    //$window.alert("sirvio la marikada");
    //$scope.bandera1 = true;
   // document.getElementById('id01').style.display='block';






//},function(err){
  //  console.log("no sirve la marikada debido a  error : "+err);
   //  $window.alert("no sirve la marikada debido a  error : "+err);


//}
//);
// var entries = exam.query({idContratista:1,idContratante:2},function() {
  //},function(err){
  //  console.log("no sirve la marikada debido a  error : "+err);

  //}


  //);
  $scope.closeModel= function(){
        document.getElementById('id01').style.display='none';
  }

if ("undefined" === typeof $localStorage.userLogeado && "undefined" === typeof $localStorage.contratanteLogeado){
         $mdDialog.show(
                          $mdDialog.alert()
                            .parent(angular.element(document.querySelector('#popupContainer')))
                            .clickOutsideToClose(true)
                            .title('Error')
                            .textContent('Usted no ha iniciado sesión.')
                            .ariaLabel('Alert Dialog Demo')
                            .ok('ok!')
                            .targetEvent()
                    );
        $location.path("inicio");


}

function Example(){


}

}]);