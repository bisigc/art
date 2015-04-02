// @SOURCE:/Users/cbi/Documents/git-repos/ART/conf/routes
// @HASH:7ee568d65d05f077a116612f091dd2ed4f0a52d8
// @DATE:Thu Apr 02 16:09:06 CEST 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:26
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
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

// @LINE:26
class ReverseAssets {


// @LINE:26
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
class ReversePropertyController {


// @LINE:19
def getProperties(cat:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "property/categorie/" + implicitly[PathBindable[String]].unbind("cat", dynamicString(cat)))
}
                        

// @LINE:18
def getAllProperties(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "property")
}
                        

// @LINE:22
def updateProperty(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "property/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:23
def deleteProperty(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "property/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:20
def getProperty(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "property/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:21
def createProperty(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "property")
}
                        

}
                          

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
                          

// @LINE:6
class ReverseApplication {


// @LINE:6
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
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
                          
}
                  


// @LINE:26
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
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

// @LINE:26
class ReverseAssets {


// @LINE:26
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
class ReversePropertyController {


// @LINE:19
def getProperties : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PropertyController.getProperties",
   """
      function(cat) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "property/categorie/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("cat", encodeURIComponent(cat))})
      }
   """
)
                        

// @LINE:18
def getAllProperties : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PropertyController.getAllProperties",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "property"})
      }
   """
)
                        

// @LINE:22
def updateProperty : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PropertyController.updateProperty",
   """
      function(id) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "property/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:23
def deleteProperty : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PropertyController.deleteProperty",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "property/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:20
def getProperty : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PropertyController.getProperty",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "property/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:21
def createProperty : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PropertyController.createProperty",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "property"})
      }
   """
)
                        

}
              

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
              
}
        


// @LINE:26
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
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


// @LINE:26
class ReverseAssets {


// @LINE:26
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """$file<.+>""")
)
                      

}
                          

// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
class ReversePropertyController {


// @LINE:19
def getProperties(cat:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PropertyController.getProperties(cat), HandlerDef(this.getClass.getClassLoader, "", "controllers.PropertyController", "getProperties", Seq(classOf[String]), "GET", """""", _prefix + """property/categorie/$cat<[^/]+>""")
)
                      

// @LINE:18
def getAllProperties(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PropertyController.getAllProperties(), HandlerDef(this.getClass.getClassLoader, "", "controllers.PropertyController", "getAllProperties", Seq(), "GET", """Property service""", _prefix + """property""")
)
                      

// @LINE:22
def updateProperty(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PropertyController.updateProperty(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.PropertyController", "updateProperty", Seq(classOf[Long]), "PUT", """""", _prefix + """property/$id<[^/]+>""")
)
                      

// @LINE:23
def deleteProperty(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PropertyController.deleteProperty(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.PropertyController", "deleteProperty", Seq(classOf[Long]), "DELETE", """""", _prefix + """property/$id<[^/]+>""")
)
                      

// @LINE:20
def getProperty(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PropertyController.getProperty(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.PropertyController", "getProperty", Seq(classOf[Long]), "GET", """""", _prefix + """property/$id<[^/]+>""")
)
                      

// @LINE:21
def createProperty(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PropertyController.createProperty(), HandlerDef(this.getClass.getClassLoader, "", "controllers.PropertyController", "createProperty", Seq(), "POST", """""", _prefix + """property""")
)
                      

}
                          

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
                          

// @LINE:6
class ReverseApplication {


// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

}
                          

// @LINE:7
class ReverseEEPPIController {


// @LINE:7
def listAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.EEPPIController.listAll(), HandlerDef(this.getClass.getClassLoader, "", "controllers.EEPPIController", "listAll", Seq(), "GET", """""", _prefix + """listAll""")
)
                      

}
                          
}
        
    