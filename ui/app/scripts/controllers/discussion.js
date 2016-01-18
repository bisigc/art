'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:DiscussionCtrl
 * @description
 * # DiscussionCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('DiscussionCtrl', ['DiscussionService', 'CommentService', 'ReplyErrorHandler', '$stateParams', 'notifications','$scope', function(DiscussionService, CommentService, ReplyErrorHandler, $stateParams, notifications, $scope) {
    $scope.init = function () {
        $scope.newcomment = {};
        $scope.newcomment.comment = '';
    };
    $scope.init();
    
    //$scope.discussion_id = $scope.$parent.dicussion_id;
    $scope.discussion = {};
    
    $scope.$watch('discussionid', function() {
        if($scope.discussionid !== null) {
            DiscussionService.id.get({id: $scope.discussionid}, function(data) { //, status, headers, config
                $scope.discussion = data;
            }, ReplyErrorHandler);
        }
    });
    
    $scope.updateComment = function (discussionid, comment) {
        CommentService.noid.update(comment, function() { //data, status, headers, config
            notifications.showSuccess('Comment has been updated.');
        }, ReplyErrorHandler); 
    };

    $scope.addComment = function (discussionid) {
        $scope.newcomment.discussion = { 'id': discussionid };
        CommentService.noid.create($scope.newcomment, function(data) { //, status, headers, config
            $scope.discussion.comments.unshift(data);
            $scope.init();
            notifications.showSuccess('Comment has been added.');
        }, ReplyErrorHandler);
    };

    $scope.like = function(comment) {
        CommentService.like.like({id: comment.id},function() { //data, status, headers, config
            notifications.showSuccess('Comment has been liked.');
            comment.likeCount++;
        }, ReplyErrorHandler);
    };
    
    /*$scope.discussion = [];
    DiscussionService.id.get({id: $stateParams.discussion_id},function(data, status, headers, config) {
        $scope.discussion = data;
    }, ReplyErrorHandler);*/
}]);