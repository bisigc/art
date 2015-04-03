// @SOURCE:/Users/cbi/Documents/git-repos/ART/conf/routes
// @HASH:83395b601ecb68cae5b8c38b0b74278f7ac39fd2
// @DATE:Fri Apr 03 14:37:25 CEST 2015


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
        

// @LINE:9
private[this] lazy val controllers_SmellController_getAllSmells1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smells"))))
private[this] lazy val controllers_SmellController_getAllSmells1_invoker = createInvoker(
controllers.SmellController.getAllSmells(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.SmellController", "getAllSmells", Nil,"GET", """Smell service""", Routes.prefix + """smells"""))
        

// @LINE:10
private[this] lazy val controllers_SmellController_getCloudSmells2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smells/forcloud"))))
private[this] lazy val controllers_SmellController_getCloudSmells2_invoker = createInvoker(
controllers.SmellController.getCloudSmells(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.SmellController", "getCloudSmells", Nil,"GET", """""", Routes.prefix + """smells/forcloud"""))
        

// @LINE:11
private[this] lazy val controllers_SmellController_getSmell3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smells/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_SmellController_getSmell3_invoker = createInvoker(
controllers.SmellController.getSmell(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.SmellController", "getSmell", Seq(classOf[Long]),"GET", """""", Routes.prefix + """smells/$id<[^/]+>"""))
        

// @LINE:12
private[this] lazy val controllers_SmellController_createSmell4_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smells"))))
private[this] lazy val controllers_SmellController_createSmell4_invoker = createInvoker(
controllers.SmellController.createSmell(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.SmellController", "createSmell", Nil,"POST", """""", Routes.prefix + """smells"""))
        

// @LINE:13
private[this] lazy val controllers_SmellController_updateSmell5_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smells/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_SmellController_updateSmell5_invoker = createInvoker(
controllers.SmellController.updateSmell(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.SmellController", "updateSmell", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """smells/$id<[^/]+>"""))
        

// @LINE:14
private[this] lazy val controllers_SmellController_deleteSmell6_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smells/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_SmellController_deleteSmell6_invoker = createInvoker(
controllers.SmellController.deleteSmell(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.SmellController", "deleteSmell", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """smells/$id<[^/]+>"""))
        

// @LINE:17
private[this] lazy val controllers_PropertyController_getAllProperties7_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("property"))))
private[this] lazy val controllers_PropertyController_getAllProperties7_invoker = createInvoker(
controllers.PropertyController.getAllProperties(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PropertyController", "getAllProperties", Nil,"GET", """Property service""", Routes.prefix + """property"""))
        

// @LINE:18
private[this] lazy val controllers_PropertyController_getProperties8_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("property/categorie/"),DynamicPart("cat", """[^/]+""",true))))
private[this] lazy val controllers_PropertyController_getProperties8_invoker = createInvoker(
controllers.PropertyController.getProperties(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PropertyController", "getProperties", Seq(classOf[String]),"GET", """""", Routes.prefix + """property/categorie/$cat<[^/]+>"""))
        

// @LINE:19
private[this] lazy val controllers_PropertyController_getProperty9_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("property/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_PropertyController_getProperty9_invoker = createInvoker(
controllers.PropertyController.getProperty(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PropertyController", "getProperty", Seq(classOf[Long]),"GET", """""", Routes.prefix + """property/$id<[^/]+>"""))
        

// @LINE:20
private[this] lazy val controllers_PropertyController_createProperty10_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("property"))))
private[this] lazy val controllers_PropertyController_createProperty10_invoker = createInvoker(
controllers.PropertyController.createProperty(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PropertyController", "createProperty", Nil,"POST", """""", Routes.prefix + """property"""))
        

// @LINE:21
private[this] lazy val controllers_PropertyController_updateProperty11_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("property/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_PropertyController_updateProperty11_invoker = createInvoker(
controllers.PropertyController.updateProperty(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PropertyController", "updateProperty", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """property/$id<[^/]+>"""))
        

// @LINE:22
private[this] lazy val controllers_PropertyController_deleteProperty12_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("property/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_PropertyController_deleteProperty12_invoker = createInvoker(
controllers.PropertyController.deleteProperty(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PropertyController", "deleteProperty", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """property/$id<[^/]+>"""))
        

// @LINE:25
private[this] lazy val controllers_MenuController_getMenuitems13_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("menu"))))
private[this] lazy val controllers_MenuController_getMenuitems13_invoker = createInvoker(
controllers.MenuController.getMenuitems(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.MenuController", "getMenuitems", Nil,"GET", """Menu service""", Routes.prefix + """menu"""))
        

// @LINE:26
private[this] lazy val controllers_MenuController_getMenuitem14_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("menu/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_MenuController_getMenuitem14_invoker = createInvoker(
controllers.MenuController.getMenuitem(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.MenuController", "getMenuitem", Seq(classOf[Long]),"GET", """""", Routes.prefix + """menu/$id<[^/]+>"""))
        

// @LINE:27
private[this] lazy val controllers_MenuController_createMenuitem15_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("menu"))))
private[this] lazy val controllers_MenuController_createMenuitem15_invoker = createInvoker(
controllers.MenuController.createMenuitem(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.MenuController", "createMenuitem", Nil,"POST", """""", Routes.prefix + """menu"""))
        

// @LINE:28
private[this] lazy val controllers_MenuController_updateMenuitem16_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("menu/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_MenuController_updateMenuitem16_invoker = createInvoker(
controllers.MenuController.updateMenuitem(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.MenuController", "updateMenuitem", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """menu/$id<[^/]+>"""))
        

// @LINE:29
private[this] lazy val controllers_MenuController_deleteMenuitem17_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("menu/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_MenuController_deleteMenuitem17_invoker = createInvoker(
controllers.MenuController.deleteMenuitem(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.MenuController", "deleteMenuitem", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """menu/$id<[^/]+>"""))
        

// @LINE:32
private[this] lazy val controllers_Assets_at18_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at18_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smells""","""controllers.SmellController.getAllSmells()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smells/forcloud""","""controllers.SmellController.getCloudSmells()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smells/$id<[^/]+>""","""controllers.SmellController.getSmell(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smells""","""controllers.SmellController.createSmell()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smells/$id<[^/]+>""","""controllers.SmellController.updateSmell(id:Long)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smells/$id<[^/]+>""","""controllers.SmellController.deleteSmell(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """property""","""controllers.PropertyController.getAllProperties()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """property/categorie/$cat<[^/]+>""","""controllers.PropertyController.getProperties(cat:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """property/$id<[^/]+>""","""controllers.PropertyController.getProperty(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """property""","""controllers.PropertyController.createProperty()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """property/$id<[^/]+>""","""controllers.PropertyController.updateProperty(id:Long)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """property/$id<[^/]+>""","""controllers.PropertyController.deleteProperty(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """menu""","""controllers.MenuController.getMenuitems()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """menu/$id<[^/]+>""","""controllers.MenuController.getMenuitem(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """menu""","""controllers.MenuController.createMenuitem()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """menu/$id<[^/]+>""","""controllers.MenuController.updateMenuitem(id:Long)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """menu/$id<[^/]+>""","""controllers.MenuController.deleteMenuitem(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
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
        

// @LINE:9
case controllers_SmellController_getAllSmells1_route(params) => {
   call { 
        controllers_SmellController_getAllSmells1_invoker.call(controllers.SmellController.getAllSmells())
   }
}
        

// @LINE:10
case controllers_SmellController_getCloudSmells2_route(params) => {
   call { 
        controllers_SmellController_getCloudSmells2_invoker.call(controllers.SmellController.getCloudSmells())
   }
}
        

// @LINE:11
case controllers_SmellController_getSmell3_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_SmellController_getSmell3_invoker.call(controllers.SmellController.getSmell(id))
   }
}
        

// @LINE:12
case controllers_SmellController_createSmell4_route(params) => {
   call { 
        controllers_SmellController_createSmell4_invoker.call(controllers.SmellController.createSmell())
   }
}
        

// @LINE:13
case controllers_SmellController_updateSmell5_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_SmellController_updateSmell5_invoker.call(controllers.SmellController.updateSmell(id))
   }
}
        

// @LINE:14
case controllers_SmellController_deleteSmell6_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_SmellController_deleteSmell6_invoker.call(controllers.SmellController.deleteSmell(id))
   }
}
        

// @LINE:17
case controllers_PropertyController_getAllProperties7_route(params) => {
   call { 
        controllers_PropertyController_getAllProperties7_invoker.call(controllers.PropertyController.getAllProperties())
   }
}
        

// @LINE:18
case controllers_PropertyController_getProperties8_route(params) => {
   call(params.fromPath[String]("cat", None)) { (cat) =>
        controllers_PropertyController_getProperties8_invoker.call(controllers.PropertyController.getProperties(cat))
   }
}
        

// @LINE:19
case controllers_PropertyController_getProperty9_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_PropertyController_getProperty9_invoker.call(controllers.PropertyController.getProperty(id))
   }
}
        

// @LINE:20
case controllers_PropertyController_createProperty10_route(params) => {
   call { 
        controllers_PropertyController_createProperty10_invoker.call(controllers.PropertyController.createProperty())
   }
}
        

// @LINE:21
case controllers_PropertyController_updateProperty11_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_PropertyController_updateProperty11_invoker.call(controllers.PropertyController.updateProperty(id))
   }
}
        

// @LINE:22
case controllers_PropertyController_deleteProperty12_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_PropertyController_deleteProperty12_invoker.call(controllers.PropertyController.deleteProperty(id))
   }
}
        

// @LINE:25
case controllers_MenuController_getMenuitems13_route(params) => {
   call { 
        controllers_MenuController_getMenuitems13_invoker.call(controllers.MenuController.getMenuitems())
   }
}
        

// @LINE:26
case controllers_MenuController_getMenuitem14_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_MenuController_getMenuitem14_invoker.call(controllers.MenuController.getMenuitem(id))
   }
}
        

// @LINE:27
case controllers_MenuController_createMenuitem15_route(params) => {
   call { 
        controllers_MenuController_createMenuitem15_invoker.call(controllers.MenuController.createMenuitem())
   }
}
        

// @LINE:28
case controllers_MenuController_updateMenuitem16_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_MenuController_updateMenuitem16_invoker.call(controllers.MenuController.updateMenuitem(id))
   }
}
        

// @LINE:29
case controllers_MenuController_deleteMenuitem17_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_MenuController_deleteMenuitem17_invoker.call(controllers.MenuController.deleteMenuitem(id))
   }
}
        

// @LINE:32
case controllers_Assets_at18_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at18_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     