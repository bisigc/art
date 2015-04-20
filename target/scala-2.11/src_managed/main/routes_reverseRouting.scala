// @SOURCE:/Users/cbi/Documents/git-repos/ART/conf/routes
// @HASH:191f3bee1f37f11263ea406c8832a48e3409f61c
// @DATE:Sun Apr 19 15:06:08 CEST 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
package controllers.menu {

// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
class ReverseMenuController {


// @LINE:32
def delete(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "menu/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:30
def create(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "menu")
}
                        

// @LINE:28
def getAll(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "menu")
}
                        

// @LINE:29
def get(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "menu/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:31
def update(): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "menu")
}
                        

}
                          
}
                  

// @LINE:54
// @LINE:6
package controllers {

// @LINE:54
class ReverseAssets {


// @LINE:54
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
                  

// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
package controllers.property {

// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
class ReversePropertyController {


// @LINE:25
def delete(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "property/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:23
def create(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "property")
}
                        

// @LINE:21
def getCategorie(cat:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "property/categorie/" + implicitly[PathBindable[String]].unbind("cat", dynamicString(cat)))
}
                        

// @LINE:20
def getAll(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "property")
}
                        

// @LINE:22
def get(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "property/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:24
def update(): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "property")
}
                        

}
                          
}
                  

// @LINE:17
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
package controllers.smell {

// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
class ReverseSmellController {


// @LINE:14
def delete(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "smell/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:10
def getCloudSmells(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "smell/forcloud")
}
                        

// @LINE:12
def create(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "smell")
}
                        

// @LINE:9
def getAll(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "smell")
}
                        

// @LINE:11
def get(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "smell/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:13
def update(): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "smell")
}
                        

}
                          

// @LINE:17
class ReverseSmellGroupController {


// @LINE:17
def getAll(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "smellgroup")
}
                        

}
                          
}
                  

// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
package controllers.user {

// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
class ReverseUserController {


// @LINE:39
def delete(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "user/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:37
def create(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "user")
}
                        

// @LINE:35
def getAll(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "user")
}
                        

// @LINE:36
def get(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "user/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:38
def update(): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "user")
}
                        

}
                          

// @LINE:40
class ReverseRoleController {


// @LINE:40
def getAll(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "userroles")
}
                        

}
                          
}
                  

// @LINE:51
package controllers.status {

// @LINE:51
class ReverseStatusController {


// @LINE:51
def get(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "status")
}
                        

}
                          
}
                  

// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
package controllers.task {

// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
class ReverseExecTaskTypeController {


// @LINE:48
def delete(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "exectasktype/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:46
def create(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "exectasktype")
}
                        

// @LINE:43
def getAll(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "exectasktype")
}
                        

// @LINE:45
def get(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "exectasktype/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:47
def update(): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "exectasktype")
}
                        

// @LINE:44
def getEmptyExecTaskType(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "exectasktype/empty")
}
                        

}
                          
}
                  


// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
package controllers.menu.javascript {
import ReverseRouteContext.empty

// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
class ReverseMenuController {


// @LINE:32
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.menu.MenuController.delete",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "menu/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:30
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.menu.MenuController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "menu"})
      }
   """
)
                        

// @LINE:28
def getAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.menu.MenuController.getAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "menu"})
      }
   """
)
                        

// @LINE:29
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.menu.MenuController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "menu/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:31
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
        

// @LINE:54
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:54
class ReverseAssets {


// @LINE:54
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
        

// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
package controllers.property.javascript {
import ReverseRouteContext.empty

// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
class ReversePropertyController {


// @LINE:25
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.property.PropertyController.delete",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "property/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:23
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.property.PropertyController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "property"})
      }
   """
)
                        

// @LINE:21
def getCategorie : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.property.PropertyController.getCategorie",
   """
      function(cat) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "property/categorie/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("cat", encodeURIComponent(cat))})
      }
   """
)
                        

// @LINE:20
def getAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.property.PropertyController.getAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "property"})
      }
   """
)
                        

// @LINE:22
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.property.PropertyController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "property/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:24
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
        

// @LINE:17
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
package controllers.smell.javascript {
import ReverseRouteContext.empty

// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
class ReverseSmellController {


// @LINE:14
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.smell.SmellController.delete",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "smell/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:10
def getCloudSmells : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.smell.SmellController.getCloudSmells",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "smell/forcloud"})
      }
   """
)
                        

// @LINE:12
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.smell.SmellController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "smell"})
      }
   """
)
                        

// @LINE:9
def getAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.smell.SmellController.getAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "smell"})
      }
   """
)
                        

// @LINE:11
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.smell.SmellController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "smell/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:13
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.smell.SmellController.update",
   """
      function() {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "smell"})
      }
   """
)
                        

}
              

// @LINE:17
class ReverseSmellGroupController {


// @LINE:17
def getAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.smell.SmellGroupController.getAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "smellgroup"})
      }
   """
)
                        

}
              
}
        

// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
package controllers.user.javascript {
import ReverseRouteContext.empty

// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
class ReverseUserController {


// @LINE:39
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.user.UserController.delete",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:37
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.user.UserController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user"})
      }
   """
)
                        

// @LINE:35
def getAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.user.UserController.getAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user"})
      }
   """
)
                        

// @LINE:36
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.user.UserController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:38
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.user.UserController.update",
   """
      function() {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "user"})
      }
   """
)
                        

}
              

// @LINE:40
class ReverseRoleController {


// @LINE:40
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
        

// @LINE:51
package controllers.status.javascript {
import ReverseRouteContext.empty

// @LINE:51
class ReverseStatusController {


// @LINE:51
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
        

// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
package controllers.task.javascript {
import ReverseRouteContext.empty

// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
class ReverseExecTaskTypeController {


// @LINE:48
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.task.ExecTaskTypeController.delete",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "exectasktype/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:46
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.task.ExecTaskTypeController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "exectasktype"})
      }
   """
)
                        

// @LINE:43
def getAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.task.ExecTaskTypeController.getAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "exectasktype"})
      }
   """
)
                        

// @LINE:45
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.task.ExecTaskTypeController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "exectasktype/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:47
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.task.ExecTaskTypeController.update",
   """
      function() {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "exectasktype"})
      }
   """
)
                        

// @LINE:44
def getEmptyExecTaskType : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.task.ExecTaskTypeController.getEmptyExecTaskType",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "exectasktype/empty"})
      }
   """
)
                        

}
              
}
        


// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
package controllers.menu.ref {


// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
class ReverseMenuController {


// @LINE:32
def delete(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).delete(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.menu.MenuController", "delete", Seq(classOf[Long]), "DELETE", """""", _prefix + """menu/$id<[^/]+>""")
)
                      

// @LINE:30
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).create(), HandlerDef(this.getClass.getClassLoader, "", "controllers.menu.MenuController", "create", Seq(), "POST", """""", _prefix + """menu""")
)
                      

// @LINE:28
def getAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).getAll(), HandlerDef(this.getClass.getClassLoader, "", "controllers.menu.MenuController", "getAll", Seq(), "GET", """Menu service""", _prefix + """menu""")
)
                      

// @LINE:29
def get(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).get(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.menu.MenuController", "get", Seq(classOf[Long]), "GET", """""", _prefix + """menu/$id<[^/]+>""")
)
                      

// @LINE:31
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).update(), HandlerDef(this.getClass.getClassLoader, "", "controllers.menu.MenuController", "update", Seq(), "PUT", """""", _prefix + """menu""")
)
                      

}
                          
}
        

// @LINE:54
// @LINE:6
package controllers.ref {


// @LINE:54
class ReverseAssets {


// @LINE:54
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
        

// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
package controllers.property.ref {


// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
class ReversePropertyController {


// @LINE:25
def delete(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).delete(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.property.PropertyController", "delete", Seq(classOf[Long]), "DELETE", """""", _prefix + """property/$id<[^/]+>""")
)
                      

// @LINE:23
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).create(), HandlerDef(this.getClass.getClassLoader, "", "controllers.property.PropertyController", "create", Seq(), "POST", """""", _prefix + """property""")
)
                      

// @LINE:21
def getCategorie(cat:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).getCategorie(cat), HandlerDef(this.getClass.getClassLoader, "", "controllers.property.PropertyController", "getCategorie", Seq(classOf[String]), "GET", """""", _prefix + """property/categorie/$cat<[^/]+>""")
)
                      

// @LINE:20
def getAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).getAll(), HandlerDef(this.getClass.getClassLoader, "", "controllers.property.PropertyController", "getAll", Seq(), "GET", """Property service""", _prefix + """property""")
)
                      

// @LINE:22
def get(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).get(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.property.PropertyController", "get", Seq(classOf[Long]), "GET", """""", _prefix + """property/$id<[^/]+>""")
)
                      

// @LINE:24
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).update(), HandlerDef(this.getClass.getClassLoader, "", "controllers.property.PropertyController", "update", Seq(), "PUT", """""", _prefix + """property""")
)
                      

}
                          
}
        

// @LINE:17
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
package controllers.smell.ref {


// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
class ReverseSmellController {


// @LINE:14
def delete(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).delete(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellController", "delete", Seq(classOf[Long]), "DELETE", """""", _prefix + """smell/$id<[^/]+>""")
)
                      

// @LINE:10
def getCloudSmells(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).getCloudSmells(), HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellController", "getCloudSmells", Seq(), "GET", """""", _prefix + """smell/forcloud""")
)
                      

// @LINE:12
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).create(), HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellController", "create", Seq(), "POST", """""", _prefix + """smell""")
)
                      

// @LINE:9
def getAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).getAll(), HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellController", "getAll", Seq(), "GET", """Smell service""", _prefix + """smell""")
)
                      

// @LINE:11
def get(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).get(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellController", "get", Seq(classOf[Long]), "GET", """""", _prefix + """smell/$id<[^/]+>""")
)
                      

// @LINE:13
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).update(), HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellController", "update", Seq(), "PUT", """""", _prefix + """smell""")
)
                      

}
                          

// @LINE:17
class ReverseSmellGroupController {


// @LINE:17
def getAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).getAll(), HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellGroupController", "getAll", Seq(), "GET", """SmellGroup service""", _prefix + """smellgroup""")
)
                      

}
                          
}
        

// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
package controllers.user.ref {


// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
class ReverseUserController {


// @LINE:39
def delete(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).delete(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "delete", Seq(classOf[Long]), "DELETE", """""", _prefix + """user/$id<[^/]+>""")
)
                      

// @LINE:37
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).create(), HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "create", Seq(), "POST", """""", _prefix + """user""")
)
                      

// @LINE:35
def getAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).getAll(), HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "getAll", Seq(), "GET", """User service""", _prefix + """user""")
)
                      

// @LINE:36
def get(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).get(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "get", Seq(classOf[Long]), "GET", """""", _prefix + """user/$id<[^/]+>""")
)
                      

// @LINE:38
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).update(), HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "update", Seq(), "PUT", """""", _prefix + """user""")
)
                      

}
                          

// @LINE:40
class ReverseRoleController {


// @LINE:40
def getAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.RoleController]).getAll(), HandlerDef(this.getClass.getClassLoader, "", "controllers.user.RoleController", "getAll", Seq(), "GET", """""", _prefix + """userroles""")
)
                      

}
                          
}
        

// @LINE:51
package controllers.status.ref {


// @LINE:51
class ReverseStatusController {


// @LINE:51
def get(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.status.StatusController]).get(), HandlerDef(this.getClass.getClassLoader, "", "controllers.status.StatusController", "get", Seq(), "GET", """Status service""", _prefix + """status""")
)
                      

}
                          
}
        

// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
package controllers.task.ref {


// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
class ReverseExecTaskTypeController {


// @LINE:48
def delete(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).delete(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.task.ExecTaskTypeController", "delete", Seq(classOf[Long]), "DELETE", """""", _prefix + """exectasktype/$id<[^/]+>""")
)
                      

// @LINE:46
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).create(), HandlerDef(this.getClass.getClassLoader, "", "controllers.task.ExecTaskTypeController", "create", Seq(), "POST", """""", _prefix + """exectasktype""")
)
                      

// @LINE:43
def getAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).getAll(), HandlerDef(this.getClass.getClassLoader, "", "controllers.task.ExecTaskTypeController", "getAll", Seq(), "GET", """ExecTaskType service""", _prefix + """exectasktype""")
)
                      

// @LINE:45
def get(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).get(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.task.ExecTaskTypeController", "get", Seq(classOf[Long]), "GET", """""", _prefix + """exectasktype/$id<[^/]+>""")
)
                      

// @LINE:47
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).update(), HandlerDef(this.getClass.getClassLoader, "", "controllers.task.ExecTaskTypeController", "update", Seq(), "PUT", """""", _prefix + """exectasktype""")
)
                      

// @LINE:44
def getEmptyExecTaskType(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).getEmptyExecTaskType(), HandlerDef(this.getClass.getClassLoader, "", "controllers.task.ExecTaskTypeController", "getEmptyExecTaskType", Seq(), "GET", """""", _prefix + """exectasktype/empty""")
)
                      

}
                          
}
        
    