// @SOURCE:/Users/cbi/Documents/git-repos/ART/conf/routes
// @HASH:f1a6ec0833de52fd31f294e594a7f81cafd9c77b
// @DATE:Wed May 13 21:06:20 CEST 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
package controllers.menu {

// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
class ReverseMenuController {


// @LINE:69
def delete(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "menu/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:67
def create(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "menu")
}
                        

// @LINE:65
def getAll(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "menu")
}
                        

// @LINE:66
def get(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "menu/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:68
def update(): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "menu")
}
                        

}
                          
}
                  

// @LINE:112
// @LINE:6
package controllers {

// @LINE:112
class ReverseAssets {


// @LINE:112
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:6
class ReverseApplication {


// @LINE:6
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

}
                          
}
                  

// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
package controllers.property {

// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
class ReversePropertyController {


// @LINE:62
def delete(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "property/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:60
def create(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "property")
}
                        

// @LINE:58
def getCategorie(cat:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "property/categorie/" + implicitly[PathBindable[String]].unbind("cat", dynamicString(cat)))
}
                        

// @LINE:57
def getAll(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "property")
}
                        

// @LINE:59
def get(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "property/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:61
def update(): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "property")
}
                        

}
                          
}
                  

// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
package controllers.ar {

// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
class ReverseArVersionController {


// @LINE:21
def delete(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "arversion/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:19
def create(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "arversion")
}
                        

// @LINE:17
def getAll(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "arversion")
}
                        

// @LINE:18
def get(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "arversion/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:23
def arSmellSearchCount(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "arsearchcount")
}
                        

// @LINE:20
def update(): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "arversion")
}
                        

// @LINE:22
def arSmellSearch(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "arsearch")
}
                        

}
                          

// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
class ReverseArController {


// @LINE:13
def delete(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "ar/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:11
def create(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "ar")
}
                        

// @LINE:9
def getAll(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "ar")
}
                        

// @LINE:10
def get(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "ar/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:12
def update(): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "ar")
}
                        

}
                          
}
                  

// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
package controllers.smell {

// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
class ReverseSmellController {


// @LINE:32
def delete(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "smell/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:28
def getCloudSmells(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "smell/forcloud")
}
                        

// @LINE:30
def create(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "smell")
}
                        

// @LINE:27
def getAll(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "smell")
}
                        

// @LINE:29
def get(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "smell/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:31
def update(): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "smell")
}
                        

}
                          

// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
class ReverseSmellGroupController {


// @LINE:39
def delete(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "smellgroup/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:37
def create(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "smellgroup")
}
                        

// @LINE:35
def getAll(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "smellgroup")
}
                        

// @LINE:36
def get(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "smellgroup/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:38
def update(): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "smellgroup")
}
                        

}
                          
}
                  

// @LINE:81
// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
package controllers.user {

// @LINE:81
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
class ReverseUserController {


// @LINE:76
def delete(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "user/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:74
def create(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "user")
}
                        

// @LINE:81
def uploadAvatar(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "uploadavatar")
}
                        

// @LINE:72
def getAll(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "user")
}
                        

// @LINE:73
def get(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "user/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:79
def logout(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                        

// @LINE:77
def changePassword(): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "changepw")
}
                        

// @LINE:75
def update(): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "user")
}
                        

// @LINE:78
def login(): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "login")
}
                        

}
                          

// @LINE:80
class ReverseRoleController {


// @LINE:80
def getAll(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "userroles")
}
                        

}
                          
}
                  

// @LINE:106
package controllers.status {

// @LINE:106
class ReverseStatusController {


// @LINE:106
def get(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "status")
}
                        

}
                          
}
                  

// @LINE:103
// @LINE:102
// @LINE:101
// @LINE:100
// @LINE:99
// @LINE:98
// @LINE:95
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
package controllers.task {

// @LINE:103
// @LINE:102
// @LINE:101
// @LINE:100
// @LINE:99
// @LINE:98
class ReverseExecTaskTypeController {


// @LINE:103
def delete(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "exectasktype/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:101
def create(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "exectasktype")
}
                        

// @LINE:98
def getAll(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "exectasktype")
}
                        

// @LINE:100
def get(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "exectasktype/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:102
def update(): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "exectasktype")
}
                        

// @LINE:99
def getEmptyExecTaskType(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "exectasktype/empty")
}
                        

}
                          

// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
class ReverseTaskTemplateController {


// @LINE:88
def delete(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "task/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:86
def create(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "task")
}
                        

// @LINE:84
def getAll(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "task")
}
                        

// @LINE:85
def get(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "task/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:87
def update(): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "task")
}
                        

}
                          

// @LINE:95
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
class ReverseTaskPropertyController {


// @LINE:95
def delete(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "taskproperty/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:93
def create(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "taskproperty")
}
                        

// @LINE:91
def getAll(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "taskproperty")
}
                        

// @LINE:92
def get(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "taskproperty/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:94
def update(): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "taskproperty")
}
                        

}
                          
}
                  

// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
package controllers.discussion {

// @LINE:51
class ReverseLikeController {


// @LINE:51
def like(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "like/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

}
                          

// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
class ReverseDiscussionController {


// @LINE:46
def delete(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "discussion/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:44
def create(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "discussion")
}
                        

// @LINE:42
def getAll(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "discussion")
}
                        

// @LINE:43
def get(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "discussion/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:45
def update(): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "discussion")
}
                        

}
                          

// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:50
// @LINE:49
class ReverseCommentController {


// @LINE:54
def delete(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "comment/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:52
def create(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "comment")
}
                        

// @LINE:49
def getAll(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "comment")
}
                        

// @LINE:50
def get(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "comment/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:53
def update(): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "comment")
}
                        

}
                          
}
                  

// @LINE:109
package controllers.statistic {

// @LINE:109
class ReverseStatisticController {


// @LINE:109
def get(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "stats")
}
                        

}
                          
}
                  


// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
package controllers.menu.javascript {
import ReverseRouteContext.empty

// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
class ReverseMenuController {


// @LINE:69
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.menu.MenuController.delete",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "menu/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:67
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.menu.MenuController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "menu"})
      }
   """
)
                        

// @LINE:65
def getAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.menu.MenuController.getAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "menu"})
      }
   """
)
                        

// @LINE:66
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.menu.MenuController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "menu/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:68
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.menu.MenuController.update",
   """
      function() {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "menu"})
      }
   """
)
                        

}
              
}
        

// @LINE:112
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:112
class ReverseAssets {


// @LINE:112
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:6
class ReverseApplication {


// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

}
              
}
        

// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
package controllers.property.javascript {
import ReverseRouteContext.empty

// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
class ReversePropertyController {


// @LINE:62
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.property.PropertyController.delete",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "property/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:60
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.property.PropertyController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "property"})
      }
   """
)
                        

// @LINE:58
def getCategorie : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.property.PropertyController.getCategorie",
   """
      function(cat) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "property/categorie/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("cat", encodeURIComponent(cat))})
      }
   """
)
                        

// @LINE:57
def getAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.property.PropertyController.getAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "property"})
      }
   """
)
                        

// @LINE:59
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.property.PropertyController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "property/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:61
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.property.PropertyController.update",
   """
      function() {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "property"})
      }
   """
)
                        

}
              
}
        

// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
package controllers.ar.javascript {
import ReverseRouteContext.empty

// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
class ReverseArVersionController {


// @LINE:21
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ar.ArVersionController.delete",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "arversion/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:19
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ar.ArVersionController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "arversion"})
      }
   """
)
                        

// @LINE:17
def getAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ar.ArVersionController.getAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "arversion"})
      }
   """
)
                        

// @LINE:18
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ar.ArVersionController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "arversion/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:23
def arSmellSearchCount : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ar.ArVersionController.arSmellSearchCount",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "arsearchcount"})
      }
   """
)
                        

// @LINE:20
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ar.ArVersionController.update",
   """
      function() {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "arversion"})
      }
   """
)
                        

// @LINE:22
def arSmellSearch : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ar.ArVersionController.arSmellSearch",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "arsearch"})
      }
   """
)
                        

}
              

// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
class ReverseArController {


// @LINE:13
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ar.ArController.delete",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "ar/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:11
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ar.ArController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ar"})
      }
   """
)
                        

// @LINE:9
def getAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ar.ArController.getAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ar"})
      }
   """
)
                        

// @LINE:10
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ar.ArController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ar/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:12
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ar.ArController.update",
   """
      function() {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "ar"})
      }
   """
)
                        

}
              
}
        

// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
package controllers.smell.javascript {
import ReverseRouteContext.empty

// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
class ReverseSmellController {


// @LINE:32
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.smell.SmellController.delete",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "smell/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:28
def getCloudSmells : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.smell.SmellController.getCloudSmells",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "smell/forcloud"})
      }
   """
)
                        

// @LINE:30
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.smell.SmellController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "smell"})
      }
   """
)
                        

// @LINE:27
def getAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.smell.SmellController.getAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "smell"})
      }
   """
)
                        

// @LINE:29
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.smell.SmellController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "smell/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:31
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.smell.SmellController.update",
   """
      function() {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "smell"})
      }
   """
)
                        

}
              

// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
class ReverseSmellGroupController {


// @LINE:39
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.smell.SmellGroupController.delete",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "smellgroup/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:37
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.smell.SmellGroupController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "smellgroup"})
      }
   """
)
                        

// @LINE:35
def getAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.smell.SmellGroupController.getAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "smellgroup"})
      }
   """
)
                        

// @LINE:36
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.smell.SmellGroupController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "smellgroup/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:38
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.smell.SmellGroupController.update",
   """
      function() {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "smellgroup"})
      }
   """
)
                        

}
              
}
        

// @LINE:81
// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
package controllers.user.javascript {
import ReverseRouteContext.empty

// @LINE:81
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
class ReverseUserController {


// @LINE:76
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.user.UserController.delete",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:74
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.user.UserController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user"})
      }
   """
)
                        

// @LINE:81
def uploadAvatar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.user.UserController.uploadAvatar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "uploadavatar"})
      }
   """
)
                        

// @LINE:72
def getAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.user.UserController.getAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user"})
      }
   """
)
                        

// @LINE:73
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.user.UserController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:79
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.user.UserController.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:77
def changePassword : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.user.UserController.changePassword",
   """
      function() {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "changepw"})
      }
   """
)
                        

// @LINE:75
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.user.UserController.update",
   """
      function() {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "user"})
      }
   """
)
                        

// @LINE:78
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.user.UserController.login",
   """
      function() {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

}
              

// @LINE:80
class ReverseRoleController {


// @LINE:80
def getAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.user.RoleController.getAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "userroles"})
      }
   """
)
                        

}
              
}
        

// @LINE:106
package controllers.status.javascript {
import ReverseRouteContext.empty

// @LINE:106
class ReverseStatusController {


// @LINE:106
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.status.StatusController.get",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "status"})
      }
   """
)
                        

}
              
}
        

// @LINE:103
// @LINE:102
// @LINE:101
// @LINE:100
// @LINE:99
// @LINE:98
// @LINE:95
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
package controllers.task.javascript {
import ReverseRouteContext.empty

// @LINE:103
// @LINE:102
// @LINE:101
// @LINE:100
// @LINE:99
// @LINE:98
class ReverseExecTaskTypeController {


// @LINE:103
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.task.ExecTaskTypeController.delete",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "exectasktype/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:101
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.task.ExecTaskTypeController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "exectasktype"})
      }
   """
)
                        

// @LINE:98
def getAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.task.ExecTaskTypeController.getAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "exectasktype"})
      }
   """
)
                        

// @LINE:100
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.task.ExecTaskTypeController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "exectasktype/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:102
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.task.ExecTaskTypeController.update",
   """
      function() {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "exectasktype"})
      }
   """
)
                        

// @LINE:99
def getEmptyExecTaskType : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.task.ExecTaskTypeController.getEmptyExecTaskType",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "exectasktype/empty"})
      }
   """
)
                        

}
              

// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
class ReverseTaskTemplateController {


// @LINE:88
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.task.TaskTemplateController.delete",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "task/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:86
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.task.TaskTemplateController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "task"})
      }
   """
)
                        

// @LINE:84
def getAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.task.TaskTemplateController.getAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "task"})
      }
   """
)
                        

// @LINE:85
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.task.TaskTemplateController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "task/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:87
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.task.TaskTemplateController.update",
   """
      function() {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "task"})
      }
   """
)
                        

}
              

// @LINE:95
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
class ReverseTaskPropertyController {


// @LINE:95
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.task.TaskPropertyController.delete",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "taskproperty/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:93
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.task.TaskPropertyController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "taskproperty"})
      }
   """
)
                        

// @LINE:91
def getAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.task.TaskPropertyController.getAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "taskproperty"})
      }
   """
)
                        

// @LINE:92
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.task.TaskPropertyController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "taskproperty/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:94
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.task.TaskPropertyController.update",
   """
      function() {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "taskproperty"})
      }
   """
)
                        

}
              
}
        

// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
package controllers.discussion.javascript {
import ReverseRouteContext.empty

// @LINE:51
class ReverseLikeController {


// @LINE:51
def like : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.discussion.LikeController.like",
   """
      function(id) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "like/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

}
              

// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
class ReverseDiscussionController {


// @LINE:46
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.discussion.DiscussionController.delete",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "discussion/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:44
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.discussion.DiscussionController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "discussion"})
      }
   """
)
                        

// @LINE:42
def getAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.discussion.DiscussionController.getAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "discussion"})
      }
   """
)
                        

// @LINE:43
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.discussion.DiscussionController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "discussion/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:45
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.discussion.DiscussionController.update",
   """
      function() {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "discussion"})
      }
   """
)
                        

}
              

// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:50
// @LINE:49
class ReverseCommentController {


// @LINE:54
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.discussion.CommentController.delete",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "comment/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:52
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.discussion.CommentController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "comment"})
      }
   """
)
                        

// @LINE:49
def getAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.discussion.CommentController.getAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "comment"})
      }
   """
)
                        

// @LINE:50
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.discussion.CommentController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "comment/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:53
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.discussion.CommentController.update",
   """
      function() {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "comment"})
      }
   """
)
                        

}
              
}
        

// @LINE:109
package controllers.statistic.javascript {
import ReverseRouteContext.empty

// @LINE:109
class ReverseStatisticController {


// @LINE:109
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.statistic.StatisticController.get",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "stats"})
      }
   """
)
                        

}
              
}
        


// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
package controllers.menu.ref {


// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
class ReverseMenuController {


// @LINE:69
def delete(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).delete(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.menu.MenuController", "delete", Seq(classOf[Long]), "DELETE", """""", _prefix + """menu/$id<[^/]+>""")
)
                      

// @LINE:67
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).create(), HandlerDef(this.getClass.getClassLoader, "", "controllers.menu.MenuController", "create", Seq(), "POST", """""", _prefix + """menu""")
)
                      

// @LINE:65
def getAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).getAll(), HandlerDef(this.getClass.getClassLoader, "", "controllers.menu.MenuController", "getAll", Seq(), "GET", """Menu service""", _prefix + """menu""")
)
                      

// @LINE:66
def get(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).get(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.menu.MenuController", "get", Seq(classOf[Long]), "GET", """""", _prefix + """menu/$id<[^/]+>""")
)
                      

// @LINE:68
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).update(), HandlerDef(this.getClass.getClassLoader, "", "controllers.menu.MenuController", "update", Seq(), "PUT", """""", _prefix + """menu""")
)
                      

}
                          
}
        

// @LINE:112
// @LINE:6
package controllers.ref {


// @LINE:112
class ReverseAssets {


// @LINE:112
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """$file<.+>""")
)
                      

}
                          

// @LINE:6
class ReverseApplication {


// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

}
                          
}
        

// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
package controllers.property.ref {


// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
class ReversePropertyController {


// @LINE:62
def delete(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).delete(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.property.PropertyController", "delete", Seq(classOf[Long]), "DELETE", """""", _prefix + """property/$id<[^/]+>""")
)
                      

// @LINE:60
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).create(), HandlerDef(this.getClass.getClassLoader, "", "controllers.property.PropertyController", "create", Seq(), "POST", """""", _prefix + """property""")
)
                      

// @LINE:58
def getCategorie(cat:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).getCategorie(cat), HandlerDef(this.getClass.getClassLoader, "", "controllers.property.PropertyController", "getCategorie", Seq(classOf[String]), "GET", """""", _prefix + """property/categorie/$cat<[^/]+>""")
)
                      

// @LINE:57
def getAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).getAll(), HandlerDef(this.getClass.getClassLoader, "", "controllers.property.PropertyController", "getAll", Seq(), "GET", """Property service""", _prefix + """property""")
)
                      

// @LINE:59
def get(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).get(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.property.PropertyController", "get", Seq(classOf[Long]), "GET", """""", _prefix + """property/$id<[^/]+>""")
)
                      

// @LINE:61
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).update(), HandlerDef(this.getClass.getClassLoader, "", "controllers.property.PropertyController", "update", Seq(), "PUT", """""", _prefix + """property""")
)
                      

}
                          
}
        

// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
package controllers.ar.ref {


// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
class ReverseArVersionController {


// @LINE:21
def delete(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).delete(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArVersionController", "delete", Seq(classOf[Long]), "DELETE", """""", _prefix + """arversion/$id<[^/]+>""")
)
                      

// @LINE:19
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).create(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArVersionController", "create", Seq(), "POST", """""", _prefix + """arversion""")
)
                      

// @LINE:17
def getAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).getAll(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArVersionController", "getAll", Seq(), "GET", """AR Version service
GET     /arversion/active         @controllers.ar.ArVersionController.getAllActive()""", _prefix + """arversion""")
)
                      

// @LINE:18
def get(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).get(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArVersionController", "get", Seq(classOf[Long]), "GET", """""", _prefix + """arversion/$id<[^/]+>""")
)
                      

// @LINE:23
def arSmellSearchCount(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).arSmellSearchCount(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArVersionController", "arSmellSearchCount", Seq(), "POST", """""", _prefix + """arsearchcount""")
)
                      

// @LINE:20
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).update(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArVersionController", "update", Seq(), "PUT", """""", _prefix + """arversion""")
)
                      

// @LINE:22
def arSmellSearch(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).arSmellSearch(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArVersionController", "arSmellSearch", Seq(), "POST", """""", _prefix + """arsearch""")
)
                      

}
                          

// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
class ReverseArController {


// @LINE:13
def delete(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArController]).delete(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArController", "delete", Seq(classOf[Long]), "DELETE", """""", _prefix + """ar/$id<[^/]+>""")
)
                      

// @LINE:11
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArController]).create(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArController", "create", Seq(), "POST", """""", _prefix + """ar""")
)
                      

// @LINE:9
def getAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArController]).getAll(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArController", "getAll", Seq(), "GET", """AR service""", _prefix + """ar""")
)
                      

// @LINE:10
def get(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArController]).get(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArController", "get", Seq(classOf[Long]), "GET", """""", _prefix + """ar/$id<[^/]+>""")
)
                      

// @LINE:12
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArController]).update(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArController", "update", Seq(), "PUT", """""", _prefix + """ar""")
)
                      

}
                          
}
        

// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
package controllers.smell.ref {


// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
class ReverseSmellController {


// @LINE:32
def delete(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).delete(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellController", "delete", Seq(classOf[Long]), "DELETE", """""", _prefix + """smell/$id<[^/]+>""")
)
                      

// @LINE:28
def getCloudSmells(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).getCloudSmells(), HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellController", "getCloudSmells", Seq(), "GET", """""", _prefix + """smell/forcloud""")
)
                      

// @LINE:30
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).create(), HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellController", "create", Seq(), "POST", """""", _prefix + """smell""")
)
                      

// @LINE:27
def getAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).getAll(), HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellController", "getAll", Seq(), "GET", """Smell service""", _prefix + """smell""")
)
                      

// @LINE:29
def get(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).get(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellController", "get", Seq(classOf[Long]), "GET", """""", _prefix + """smell/$id<[^/]+>""")
)
                      

// @LINE:31
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).update(), HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellController", "update", Seq(), "PUT", """""", _prefix + """smell""")
)
                      

}
                          

// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
class ReverseSmellGroupController {


// @LINE:39
def delete(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).delete(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellGroupController", "delete", Seq(classOf[Long]), "DELETE", """""", _prefix + """smellgroup/$id<[^/]+>""")
)
                      

// @LINE:37
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).create(), HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellGroupController", "create", Seq(), "POST", """""", _prefix + """smellgroup""")
)
                      

// @LINE:35
def getAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).getAll(), HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellGroupController", "getAll", Seq(), "GET", """SmellGroup service""", _prefix + """smellgroup""")
)
                      

// @LINE:36
def get(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).get(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellGroupController", "get", Seq(classOf[Long]), "GET", """""", _prefix + """smellgroup/$id<[^/]+>""")
)
                      

// @LINE:38
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).update(), HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellGroupController", "update", Seq(), "PUT", """""", _prefix + """smellgroup""")
)
                      

}
                          
}
        

// @LINE:81
// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
package controllers.user.ref {


// @LINE:81
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
class ReverseUserController {


// @LINE:76
def delete(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).delete(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "delete", Seq(classOf[Long]), "DELETE", """""", _prefix + """user/$id<[^/]+>""")
)
                      

// @LINE:74
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).create(), HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "create", Seq(), "POST", """""", _prefix + """user""")
)
                      

// @LINE:81
def uploadAvatar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).uploadAvatar(), HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "uploadAvatar", Seq(), "POST", """""", _prefix + """uploadavatar""")
)
                      

// @LINE:72
def getAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).getAll(), HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "getAll", Seq(), "GET", """User service""", _prefix + """user""")
)
                      

// @LINE:73
def get(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).get(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "get", Seq(classOf[Long]), "GET", """""", _prefix + """user/$id<[^/]+>""")
)
                      

// @LINE:79
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).logout(), HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:77
def changePassword(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).changePassword(), HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "changePassword", Seq(), "PUT", """""", _prefix + """changepw""")
)
                      

// @LINE:75
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).update(), HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "update", Seq(), "PUT", """""", _prefix + """user""")
)
                      

// @LINE:78
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).login(), HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "login", Seq(), "PUT", """""", _prefix + """login""")
)
                      

}
                          

// @LINE:80
class ReverseRoleController {


// @LINE:80
def getAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.RoleController]).getAll(), HandlerDef(this.getClass.getClassLoader, "", "controllers.user.RoleController", "getAll", Seq(), "GET", """""", _prefix + """userroles""")
)
                      

}
                          
}
        

// @LINE:106
package controllers.status.ref {


// @LINE:106
class ReverseStatusController {


// @LINE:106
def get(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.status.StatusController]).get(), HandlerDef(this.getClass.getClassLoader, "", "controllers.status.StatusController", "get", Seq(), "GET", """Status service""", _prefix + """status""")
)
                      

}
                          
}
        

// @LINE:103
// @LINE:102
// @LINE:101
// @LINE:100
// @LINE:99
// @LINE:98
// @LINE:95
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
package controllers.task.ref {


// @LINE:103
// @LINE:102
// @LINE:101
// @LINE:100
// @LINE:99
// @LINE:98
class ReverseExecTaskTypeController {


// @LINE:103
def delete(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).delete(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.task.ExecTaskTypeController", "delete", Seq(classOf[Long]), "DELETE", """""", _prefix + """exectasktype/$id<[^/]+>""")
)
                      

// @LINE:101
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).create(), HandlerDef(this.getClass.getClassLoader, "", "controllers.task.ExecTaskTypeController", "create", Seq(), "POST", """""", _prefix + """exectasktype""")
)
                      

// @LINE:98
def getAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).getAll(), HandlerDef(this.getClass.getClassLoader, "", "controllers.task.ExecTaskTypeController", "getAll", Seq(), "GET", """ExecTaskType service""", _prefix + """exectasktype""")
)
                      

// @LINE:100
def get(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).get(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.task.ExecTaskTypeController", "get", Seq(classOf[Long]), "GET", """""", _prefix + """exectasktype/$id<[^/]+>""")
)
                      

// @LINE:102
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).update(), HandlerDef(this.getClass.getClassLoader, "", "controllers.task.ExecTaskTypeController", "update", Seq(), "PUT", """""", _prefix + """exectasktype""")
)
                      

// @LINE:99
def getEmptyExecTaskType(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).getEmptyExecTaskType(), HandlerDef(this.getClass.getClassLoader, "", "controllers.task.ExecTaskTypeController", "getEmptyExecTaskType", Seq(), "GET", """""", _prefix + """exectasktype/empty""")
)
                      

}
                          

// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
class ReverseTaskTemplateController {


// @LINE:88
def delete(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.TaskTemplateController]).delete(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.task.TaskTemplateController", "delete", Seq(classOf[Long]), "DELETE", """""", _prefix + """task/$id<[^/]+>""")
)
                      

// @LINE:86
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.TaskTemplateController]).create(), HandlerDef(this.getClass.getClassLoader, "", "controllers.task.TaskTemplateController", "create", Seq(), "POST", """""", _prefix + """task""")
)
                      

// @LINE:84
def getAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.TaskTemplateController]).getAll(), HandlerDef(this.getClass.getClassLoader, "", "controllers.task.TaskTemplateController", "getAll", Seq(), "GET", """TaskTemplate service""", _prefix + """task""")
)
                      

// @LINE:85
def get(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.TaskTemplateController]).get(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.task.TaskTemplateController", "get", Seq(classOf[Long]), "GET", """""", _prefix + """task/$id<[^/]+>""")
)
                      

// @LINE:87
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.TaskTemplateController]).update(), HandlerDef(this.getClass.getClassLoader, "", "controllers.task.TaskTemplateController", "update", Seq(), "PUT", """""", _prefix + """task""")
)
                      

}
                          

// @LINE:95
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
class ReverseTaskPropertyController {


// @LINE:95
def delete(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.TaskPropertyController]).delete(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.task.TaskPropertyController", "delete", Seq(classOf[Long]), "DELETE", """""", _prefix + """taskproperty/$id<[^/]+>""")
)
                      

// @LINE:93
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.TaskPropertyController]).create(), HandlerDef(this.getClass.getClassLoader, "", "controllers.task.TaskPropertyController", "create", Seq(), "POST", """""", _prefix + """taskproperty""")
)
                      

// @LINE:91
def getAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.TaskPropertyController]).getAll(), HandlerDef(this.getClass.getClassLoader, "", "controllers.task.TaskPropertyController", "getAll", Seq(), "GET", """TaskProperty service""", _prefix + """taskproperty""")
)
                      

// @LINE:92
def get(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.TaskPropertyController]).get(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.task.TaskPropertyController", "get", Seq(classOf[Long]), "GET", """""", _prefix + """taskproperty/$id<[^/]+>""")
)
                      

// @LINE:94
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.TaskPropertyController]).update(), HandlerDef(this.getClass.getClassLoader, "", "controllers.task.TaskPropertyController", "update", Seq(), "PUT", """""", _prefix + """taskproperty""")
)
                      

}
                          
}
        

// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
package controllers.discussion.ref {


// @LINE:51
class ReverseLikeController {


// @LINE:51
def like(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.LikeController]).like(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.LikeController", "like", Seq(classOf[Long]), "PUT", """""", _prefix + """like/$id<[^/]+>""")
)
                      

}
                          

// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
class ReverseDiscussionController {


// @LINE:46
def delete(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.DiscussionController]).delete(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.DiscussionController", "delete", Seq(classOf[Long]), "DELETE", """""", _prefix + """discussion/$id<[^/]+>""")
)
                      

// @LINE:44
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.DiscussionController]).create(), HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.DiscussionController", "create", Seq(), "POST", """""", _prefix + """discussion""")
)
                      

// @LINE:42
def getAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.DiscussionController]).getAll(), HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.DiscussionController", "getAll", Seq(), "GET", """Discussion service""", _prefix + """discussion""")
)
                      

// @LINE:43
def get(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.DiscussionController]).get(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.DiscussionController", "get", Seq(classOf[Long]), "GET", """""", _prefix + """discussion/$id<[^/]+>""")
)
                      

// @LINE:45
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.DiscussionController]).update(), HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.DiscussionController", "update", Seq(), "PUT", """""", _prefix + """discussion""")
)
                      

}
                          

// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:50
// @LINE:49
class ReverseCommentController {


// @LINE:54
def delete(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.CommentController]).delete(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.CommentController", "delete", Seq(classOf[Long]), "DELETE", """""", _prefix + """comment/$id<[^/]+>""")
)
                      

// @LINE:52
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.CommentController]).create(), HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.CommentController", "create", Seq(), "POST", """""", _prefix + """comment""")
)
                      

// @LINE:49
def getAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.CommentController]).getAll(), HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.CommentController", "getAll", Seq(), "GET", """Comment service""", _prefix + """comment""")
)
                      

// @LINE:50
def get(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.CommentController]).get(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.CommentController", "get", Seq(classOf[Long]), "GET", """""", _prefix + """comment/$id<[^/]+>""")
)
                      

// @LINE:53
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.CommentController]).update(), HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.CommentController", "update", Seq(), "PUT", """""", _prefix + """comment""")
)
                      

}
                          
}
        

// @LINE:109
package controllers.statistic.ref {


// @LINE:109
class ReverseStatisticController {


// @LINE:109
def get(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.statistic.StatisticController]).get(), HandlerDef(this.getClass.getClassLoader, "", "controllers.statistic.StatisticController", "get", Seq(), "GET", """Statistic service""", _prefix + """stats""")
)
                      

}
                          
}
        
    