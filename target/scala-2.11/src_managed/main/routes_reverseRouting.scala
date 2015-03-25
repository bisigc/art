// @SOURCE:/Users/cbi/Documents/git-repos/ART/conf/routes
// @HASH:87471b13483a9544e3d23017922a88cd022679f3
// @DATE:Wed Mar 25 09:22:58 CET 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:18
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:7
// @LINE:6
package controllers {

// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
class ReverseSmellController {


// @LINE:11
def getCloudSmells(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "smells/forcloud")
}
                        

// @LINE:15
def deleteSmell(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "smells/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:12
def getSmell(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "smells/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:13
def createSmell(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "smells")
}
                        

// @LINE:14
def updateSmell(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "smells/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:10
def getAllSmells(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "smells")
}
                        

}
                          

// @LINE:18
class ReverseAssets {


// @LINE:18
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:7
class ReverseEEPPIController {


// @LINE:7
def listAll(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "listAll")
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
                  


// @LINE:18
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:7
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
class ReverseSmellController {


// @LINE:11
def getCloudSmells : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SmellController.getCloudSmells",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "smells/forcloud"})
      }
   """
)
                        

// @LINE:15
def deleteSmell : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SmellController.deleteSmell",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "smells/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:12
def getSmell : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SmellController.getSmell",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "smells/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:13
def createSmell : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SmellController.createSmell",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "smells"})
      }
   """
)
                        

// @LINE:14
def updateSmell : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SmellController.updateSmell",
   """
      function(id) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "smells/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:10
def getAllSmells : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SmellController.getAllSmells",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "smells"})
      }
   """
)
                        

}
              

// @LINE:18
class ReverseAssets {


// @LINE:18
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:7
class ReverseEEPPIController {


// @LINE:7
def listAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.EEPPIController.listAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "listAll"})
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
        


// @LINE:18
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
class ReverseSmellController {


// @LINE:11
def getCloudSmells(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SmellController.getCloudSmells(), HandlerDef(this.getClass.getClassLoader, "", "controllers.SmellController", "getCloudSmells", Seq(), "GET", """""", _prefix + """smells/forcloud""")
)
                      

// @LINE:15
def deleteSmell(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SmellController.deleteSmell(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.SmellController", "deleteSmell", Seq(classOf[Long]), "DELETE", """""", _prefix + """smells/$id<[^/]+>""")
)
                      

// @LINE:12
def getSmell(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SmellController.getSmell(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.SmellController", "getSmell", Seq(classOf[Long]), "GET", """""", _prefix + """smells/$id<[^/]+>""")
)
                      

// @LINE:13
def createSmell(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SmellController.createSmell(), HandlerDef(this.getClass.getClassLoader, "", "controllers.SmellController", "createSmell", Seq(), "POST", """""", _prefix + """smells""")
)
                      

// @LINE:14
def updateSmell(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SmellController.updateSmell(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.SmellController", "updateSmell", Seq(classOf[Long]), "PUT", """""", _prefix + """smells/$id<[^/]+>""")
)
                      

// @LINE:10
def getAllSmells(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SmellController.getAllSmells(), HandlerDef(this.getClass.getClassLoader, "", "controllers.SmellController", "getAllSmells", Seq(), "GET", """Smell service""", _prefix + """smells""")
)
                      

}
                          

// @LINE:18
class ReverseAssets {


// @LINE:18
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """$file<.+>""")
)
                      

}
                          

// @LINE:7
class ReverseEEPPIController {


// @LINE:7
def listAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.EEPPIController.listAll(), HandlerDef(this.getClass.getClassLoader, "", "controllers.EEPPIController", "listAll", Seq(), "GET", """""", _prefix + """listAll""")
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
        
    