// @SOURCE:/Users/cbi/Documents/git-repos/ART/conf/routes
// @HASH:967d6d2085267b2ca74adf56474fd5040aded288
// @DATE:Wed Apr 08 12:17:15 CEST 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:43
// @LINE:40
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers {

// @LINE:43
class ReverseAssets {


// @LINE:43
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
class ReverseExecTaskTypeController {


// @LINE:36
def updateExecTaskType(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "exectasktype/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:34
def getExecTaskType(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "exectasktype/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:32
def getExecTaskTypes(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "exectasktype")
}
                        

// @LINE:37
def deleteExecTaskType(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "exectasktype/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:35
def createExecTaskType(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "exectasktype")
}
                        

// @LINE:33
def getEmptyExecTaskType(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "exectasktype/empty")
}
                        

}
                          

// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
class ReversePropertyController {


// @LINE:18
def getProperties(cat:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "property/categorie/" + implicitly[PathBindable[String]].unbind("cat", dynamicString(cat)))
}
                        

// @LINE:17
def getAllProperties(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "property")
}
                        

// @LINE:21
def updateProperty(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "property/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:22
def deleteProperty(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "property/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:19
def getProperty(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "property/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:20
def createProperty(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "property")
}
                        

}
                          

// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
class ReverseMenuController {


// @LINE:27
def createMenuitem(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "menu")
}
                        

// @LINE:28
def updateMenuitem(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "menu/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:25
def getMenuitems(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "menu")
}
                        

// @LINE:29
def deleteMenuitem(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "menu/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:26
def getMenuitem(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "menu/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

}
                          

// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
class ReverseSmellController {


// @LINE:10
def getCloudSmells(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "smells/forcloud")
}
                        

// @LINE:14
def deleteSmell(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "smells/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:11
def getSmell(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "smells/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:12
def createSmell(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "smells")
}
                        

// @LINE:13
def updateSmell(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "smells/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:9
def getAllSmells(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "smells")
}
                        

}
                          

// @LINE:40
class ReverseStatusController {


// @LINE:40
def getStatus(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "status")
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
                  


// @LINE:43
// @LINE:40
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:43
class ReverseAssets {


// @LINE:43
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
class ReverseExecTaskTypeController {


// @LINE:36
def updateExecTaskType : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ExecTaskTypeController.updateExecTaskType",
   """
      function(id) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "exectasktype/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:34
def getExecTaskType : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ExecTaskTypeController.getExecTaskType",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "exectasktype/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:32
def getExecTaskTypes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ExecTaskTypeController.getExecTaskTypes",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "exectasktype"})
      }
   """
)
                        

// @LINE:37
def deleteExecTaskType : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ExecTaskTypeController.deleteExecTaskType",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "exectasktype/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:35
def createExecTaskType : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ExecTaskTypeController.createExecTaskType",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "exectasktype"})
      }
   """
)
                        

// @LINE:33
def getEmptyExecTaskType : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ExecTaskTypeController.getEmptyExecTaskType",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "exectasktype/empty"})
      }
   """
)
                        

}
              

// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
class ReversePropertyController {


// @LINE:18
def getProperties : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PropertyController.getProperties",
   """
      function(cat) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "property/categorie/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("cat", encodeURIComponent(cat))})
      }
   """
)
                        

// @LINE:17
def getAllProperties : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PropertyController.getAllProperties",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "property"})
      }
   """
)
                        

// @LINE:21
def updateProperty : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PropertyController.updateProperty",
   """
      function(id) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "property/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:22
def deleteProperty : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PropertyController.deleteProperty",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "property/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:19
def getProperty : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PropertyController.getProperty",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "property/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:20
def createProperty : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PropertyController.createProperty",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "property"})
      }
   """
)
                        

}
              

// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
class ReverseMenuController {


// @LINE:27
def createMenuitem : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MenuController.createMenuitem",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "menu"})
      }
   """
)
                        

// @LINE:28
def updateMenuitem : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MenuController.updateMenuitem",
   """
      function(id) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "menu/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:25
def getMenuitems : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MenuController.getMenuitems",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "menu"})
      }
   """
)
                        

// @LINE:29
def deleteMenuitem : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MenuController.deleteMenuitem",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "menu/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:26
def getMenuitem : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MenuController.getMenuitem",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "menu/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

}
              

// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
class ReverseSmellController {


// @LINE:10
def getCloudSmells : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SmellController.getCloudSmells",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "smells/forcloud"})
      }
   """
)
                        

// @LINE:14
def deleteSmell : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SmellController.deleteSmell",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "smells/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:11
def getSmell : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SmellController.getSmell",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "smells/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:12
def createSmell : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SmellController.createSmell",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "smells"})
      }
   """
)
                        

// @LINE:13
def updateSmell : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SmellController.updateSmell",
   """
      function(id) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "smells/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:9
def getAllSmells : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SmellController.getAllSmells",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "smells"})
      }
   """
)
                        

}
              

// @LINE:40
class ReverseStatusController {


// @LINE:40
def getStatus : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.StatusController.getStatus",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "status"})
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
        


// @LINE:43
// @LINE:40
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.ref {


// @LINE:43
class ReverseAssets {


// @LINE:43
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """$file<.+>""")
)
                      

}
                          

// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
class ReverseExecTaskTypeController {


// @LINE:36
def updateExecTaskType(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ExecTaskTypeController.updateExecTaskType(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.ExecTaskTypeController", "updateExecTaskType", Seq(classOf[Long]), "PUT", """""", _prefix + """exectasktype/$id<[^/]+>""")
)
                      

// @LINE:34
def getExecTaskType(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ExecTaskTypeController.getExecTaskType(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.ExecTaskTypeController", "getExecTaskType", Seq(classOf[Long]), "GET", """""", _prefix + """exectasktype/$id<[^/]+>""")
)
                      

// @LINE:32
def getExecTaskTypes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ExecTaskTypeController.getExecTaskTypes(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ExecTaskTypeController", "getExecTaskTypes", Seq(), "GET", """ExecTaskType service""", _prefix + """exectasktype""")
)
                      

// @LINE:37
def deleteExecTaskType(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ExecTaskTypeController.deleteExecTaskType(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.ExecTaskTypeController", "deleteExecTaskType", Seq(classOf[Long]), "DELETE", """""", _prefix + """exectasktype/$id<[^/]+>""")
)
                      

// @LINE:35
def createExecTaskType(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ExecTaskTypeController.createExecTaskType(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ExecTaskTypeController", "createExecTaskType", Seq(), "POST", """""", _prefix + """exectasktype""")
)
                      

// @LINE:33
def getEmptyExecTaskType(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ExecTaskTypeController.getEmptyExecTaskType(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ExecTaskTypeController", "getEmptyExecTaskType", Seq(), "GET", """""", _prefix + """exectasktype/empty""")
)
                      

}
                          

// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
class ReversePropertyController {


// @LINE:18
def getProperties(cat:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PropertyController.getProperties(cat), HandlerDef(this.getClass.getClassLoader, "", "controllers.PropertyController", "getProperties", Seq(classOf[String]), "GET", """""", _prefix + """property/categorie/$cat<[^/]+>""")
)
                      

// @LINE:17
def getAllProperties(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PropertyController.getAllProperties(), HandlerDef(this.getClass.getClassLoader, "", "controllers.PropertyController", "getAllProperties", Seq(), "GET", """Property service""", _prefix + """property""")
)
                      

// @LINE:21
def updateProperty(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PropertyController.updateProperty(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.PropertyController", "updateProperty", Seq(classOf[Long]), "PUT", """""", _prefix + """property/$id<[^/]+>""")
)
                      

// @LINE:22
def deleteProperty(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PropertyController.deleteProperty(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.PropertyController", "deleteProperty", Seq(classOf[Long]), "DELETE", """""", _prefix + """property/$id<[^/]+>""")
)
                      

// @LINE:19
def getProperty(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PropertyController.getProperty(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.PropertyController", "getProperty", Seq(classOf[Long]), "GET", """""", _prefix + """property/$id<[^/]+>""")
)
                      

// @LINE:20
def createProperty(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PropertyController.createProperty(), HandlerDef(this.getClass.getClassLoader, "", "controllers.PropertyController", "createProperty", Seq(), "POST", """""", _prefix + """property""")
)
                      

}
                          

// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
class ReverseMenuController {


// @LINE:27
def createMenuitem(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MenuController.createMenuitem(), HandlerDef(this.getClass.getClassLoader, "", "controllers.MenuController", "createMenuitem", Seq(), "POST", """""", _prefix + """menu""")
)
                      

// @LINE:28
def updateMenuitem(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MenuController.updateMenuitem(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.MenuController", "updateMenuitem", Seq(classOf[Long]), "PUT", """""", _prefix + """menu/$id<[^/]+>""")
)
                      

// @LINE:25
def getMenuitems(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MenuController.getMenuitems(), HandlerDef(this.getClass.getClassLoader, "", "controllers.MenuController", "getMenuitems", Seq(), "GET", """Menu service""", _prefix + """menu""")
)
                      

// @LINE:29
def deleteMenuitem(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MenuController.deleteMenuitem(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.MenuController", "deleteMenuitem", Seq(classOf[Long]), "DELETE", """""", _prefix + """menu/$id<[^/]+>""")
)
                      

// @LINE:26
def getMenuitem(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MenuController.getMenuitem(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.MenuController", "getMenuitem", Seq(classOf[Long]), "GET", """""", _prefix + """menu/$id<[^/]+>""")
)
                      

}
                          

// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
class ReverseSmellController {


// @LINE:10
def getCloudSmells(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SmellController.getCloudSmells(), HandlerDef(this.getClass.getClassLoader, "", "controllers.SmellController", "getCloudSmells", Seq(), "GET", """""", _prefix + """smells/forcloud""")
)
                      

// @LINE:14
def deleteSmell(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SmellController.deleteSmell(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.SmellController", "deleteSmell", Seq(classOf[Long]), "DELETE", """""", _prefix + """smells/$id<[^/]+>""")
)
                      

// @LINE:11
def getSmell(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SmellController.getSmell(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.SmellController", "getSmell", Seq(classOf[Long]), "GET", """""", _prefix + """smells/$id<[^/]+>""")
)
                      

// @LINE:12
def createSmell(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SmellController.createSmell(), HandlerDef(this.getClass.getClassLoader, "", "controllers.SmellController", "createSmell", Seq(), "POST", """""", _prefix + """smells""")
)
                      

// @LINE:13
def updateSmell(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SmellController.updateSmell(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.SmellController", "updateSmell", Seq(classOf[Long]), "PUT", """""", _prefix + """smells/$id<[^/]+>""")
)
                      

// @LINE:9
def getAllSmells(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SmellController.getAllSmells(), HandlerDef(this.getClass.getClassLoader, "", "controllers.SmellController", "getAllSmells", Seq(), "GET", """Smell service""", _prefix + """smells""")
)
                      

}
                          

// @LINE:40
class ReverseStatusController {


// @LINE:40
def getStatus(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.StatusController.getStatus(), HandlerDef(this.getClass.getClassLoader, "", "controllers.StatusController", "getStatus", Seq(), "GET", """Status service""", _prefix + """status""")
)
                      

}
                          

// @LINE:6
class ReverseApplication {


// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

}
                          
}
        
    