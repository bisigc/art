// @SOURCE:/Users/cbi/Documents/git-repos/ART/conf/routes
// @HASH:7ee568d65d05f077a116612f091dd2ed4f0a52d8
// @DATE:Thu Apr 02 16:09:06 CEST 2015


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:7
private[this] lazy val controllers_EEPPIController_listAll1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("listAll"))))
private[this] lazy val controllers_EEPPIController_listAll1_invoker = createInvoker(
controllers.EEPPIController.listAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.EEPPIController", "listAll", Nil,"GET", """""", Routes.prefix + """listAll"""))
        

// @LINE:10
private[this] lazy val controllers_SmellController_getAllSmells2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smells"))))
private[this] lazy val controllers_SmellController_getAllSmells2_invoker = createInvoker(
controllers.SmellController.getAllSmells(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.SmellController", "getAllSmells", Nil,"GET", """Smell service""", Routes.prefix + """smells"""))
        

// @LINE:11
private[this] lazy val controllers_SmellController_getCloudSmells3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smells/forcloud"))))
private[this] lazy val controllers_SmellController_getCloudSmells3_invoker = createInvoker(
controllers.SmellController.getCloudSmells(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.SmellController", "getCloudSmells", Nil,"GET", """""", Routes.prefix + """smells/forcloud"""))
        

// @LINE:12
private[this] lazy val controllers_SmellController_getSmell4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smells/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_SmellController_getSmell4_invoker = createInvoker(
controllers.SmellController.getSmell(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.SmellController", "getSmell", Seq(classOf[Long]),"GET", """""", Routes.prefix + """smells/$id<[^/]+>"""))
        

// @LINE:13
private[this] lazy val controllers_SmellController_createSmell5_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smells"))))
private[this] lazy val controllers_SmellController_createSmell5_invoker = createInvoker(
controllers.SmellController.createSmell(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.SmellController", "createSmell", Nil,"POST", """""", Routes.prefix + """smells"""))
        

// @LINE:14
private[this] lazy val controllers_SmellController_updateSmell6_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smells/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_SmellController_updateSmell6_invoker = createInvoker(
controllers.SmellController.updateSmell(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.SmellController", "updateSmell", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """smells/$id<[^/]+>"""))
        

// @LINE:15
private[this] lazy val controllers_SmellController_deleteSmell7_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smells/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_SmellController_deleteSmell7_invoker = createInvoker(
controllers.SmellController.deleteSmell(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.SmellController", "deleteSmell", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """smells/$id<[^/]+>"""))
        

// @LINE:18
private[this] lazy val controllers_PropertyController_getAllProperties8_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("property"))))
private[this] lazy val controllers_PropertyController_getAllProperties8_invoker = createInvoker(
controllers.PropertyController.getAllProperties(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PropertyController", "getAllProperties", Nil,"GET", """Property service""", Routes.prefix + """property"""))
        

// @LINE:19
private[this] lazy val controllers_PropertyController_getProperties9_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("property/categorie/"),DynamicPart("cat", """[^/]+""",true))))
private[this] lazy val controllers_PropertyController_getProperties9_invoker = createInvoker(
controllers.PropertyController.getProperties(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PropertyController", "getProperties", Seq(classOf[String]),"GET", """""", Routes.prefix + """property/categorie/$cat<[^/]+>"""))
        

// @LINE:20
private[this] lazy val controllers_PropertyController_getProperty10_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("property/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_PropertyController_getProperty10_invoker = createInvoker(
controllers.PropertyController.getProperty(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PropertyController", "getProperty", Seq(classOf[Long]),"GET", """""", Routes.prefix + """property/$id<[^/]+>"""))
        

// @LINE:21
private[this] lazy val controllers_PropertyController_createProperty11_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("property"))))
private[this] lazy val controllers_PropertyController_createProperty11_invoker = createInvoker(
controllers.PropertyController.createProperty(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PropertyController", "createProperty", Nil,"POST", """""", Routes.prefix + """property"""))
        

// @LINE:22
private[this] lazy val controllers_PropertyController_updateProperty12_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("property/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_PropertyController_updateProperty12_invoker = createInvoker(
controllers.PropertyController.updateProperty(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PropertyController", "updateProperty", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """property/$id<[^/]+>"""))
        

// @LINE:23
private[this] lazy val controllers_PropertyController_deleteProperty13_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("property/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_PropertyController_deleteProperty13_invoker = createInvoker(
controllers.PropertyController.deleteProperty(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PropertyController", "deleteProperty", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """property/$id<[^/]+>"""))
        

// @LINE:26
private[this] lazy val controllers_Assets_at14_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at14_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """listAll""","""controllers.EEPPIController.listAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smells""","""controllers.SmellController.getAllSmells()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smells/forcloud""","""controllers.SmellController.getCloudSmells()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smells/$id<[^/]+>""","""controllers.SmellController.getSmell(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smells""","""controllers.SmellController.createSmell()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smells/$id<[^/]+>""","""controllers.SmellController.updateSmell(id:Long)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smells/$id<[^/]+>""","""controllers.SmellController.deleteSmell(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """property""","""controllers.PropertyController.getAllProperties()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """property/categorie/$cat<[^/]+>""","""controllers.PropertyController.getProperties(cat:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """property/$id<[^/]+>""","""controllers.PropertyController.getProperty(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """property""","""controllers.PropertyController.createProperty()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """property/$id<[^/]+>""","""controllers.PropertyController.updateProperty(id:Long)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """property/$id<[^/]+>""","""controllers.PropertyController.deleteProperty(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index())
   }
}
        

// @LINE:7
case controllers_EEPPIController_listAll1_route(params) => {
   call { 
        controllers_EEPPIController_listAll1_invoker.call(controllers.EEPPIController.listAll())
   }
}
        

// @LINE:10
case controllers_SmellController_getAllSmells2_route(params) => {
   call { 
        controllers_SmellController_getAllSmells2_invoker.call(controllers.SmellController.getAllSmells())
   }
}
        

// @LINE:11
case controllers_SmellController_getCloudSmells3_route(params) => {
   call { 
        controllers_SmellController_getCloudSmells3_invoker.call(controllers.SmellController.getCloudSmells())
   }
}
        

// @LINE:12
case controllers_SmellController_getSmell4_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_SmellController_getSmell4_invoker.call(controllers.SmellController.getSmell(id))
   }
}
        

// @LINE:13
case controllers_SmellController_createSmell5_route(params) => {
   call { 
        controllers_SmellController_createSmell5_invoker.call(controllers.SmellController.createSmell())
   }
}
        

// @LINE:14
case controllers_SmellController_updateSmell6_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_SmellController_updateSmell6_invoker.call(controllers.SmellController.updateSmell(id))
   }
}
        

// @LINE:15
case controllers_SmellController_deleteSmell7_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_SmellController_deleteSmell7_invoker.call(controllers.SmellController.deleteSmell(id))
   }
}
        

// @LINE:18
case controllers_PropertyController_getAllProperties8_route(params) => {
   call { 
        controllers_PropertyController_getAllProperties8_invoker.call(controllers.PropertyController.getAllProperties())
   }
}
        

// @LINE:19
case controllers_PropertyController_getProperties9_route(params) => {
   call(params.fromPath[String]("cat", None)) { (cat) =>
        controllers_PropertyController_getProperties9_invoker.call(controllers.PropertyController.getProperties(cat))
   }
}
        

// @LINE:20
case controllers_PropertyController_getProperty10_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_PropertyController_getProperty10_invoker.call(controllers.PropertyController.getProperty(id))
   }
}
        

// @LINE:21
case controllers_PropertyController_createProperty11_route(params) => {
   call { 
        controllers_PropertyController_createProperty11_invoker.call(controllers.PropertyController.createProperty())
   }
}
        

// @LINE:22
case controllers_PropertyController_updateProperty12_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_PropertyController_updateProperty12_invoker.call(controllers.PropertyController.updateProperty(id))
   }
}
        

// @LINE:23
case controllers_PropertyController_deleteProperty13_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_PropertyController_deleteProperty13_invoker.call(controllers.PropertyController.deleteProperty(id))
   }
}
        

// @LINE:26
case controllers_Assets_at14_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at14_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     