// @SOURCE:/Users/cbi/Documents/git-repos/ART/conf/routes
// @HASH:7b18c2bef1ea6e5542e1601bce7f51207757efa8
// @DATE:Thu Apr 23 12:11:14 CEST 2015


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
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:9
private[this] lazy val controllers_smell_SmellController_getAll1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smell"))))
private[this] lazy val controllers_smell_SmellController_getAll1_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellController", "getAll", Nil,"GET", """Smell service""", Routes.prefix + """smell"""))
        

// @LINE:10
private[this] lazy val controllers_smell_SmellController_getCloudSmells2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smell/forcloud"))))
private[this] lazy val controllers_smell_SmellController_getCloudSmells2_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).getCloudSmells(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellController", "getCloudSmells", Nil,"GET", """""", Routes.prefix + """smell/forcloud"""))
        

// @LINE:11
private[this] lazy val controllers_smell_SmellController_get3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smell/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_smell_SmellController_get3_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).get(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """smell/$id<[^/]+>"""))
        

// @LINE:12
private[this] lazy val controllers_smell_SmellController_create4_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smell"))))
private[this] lazy val controllers_smell_SmellController_create4_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellController", "create", Nil,"POST", """""", Routes.prefix + """smell"""))
        

// @LINE:13
private[this] lazy val controllers_smell_SmellController_update5_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smell"))))
private[this] lazy val controllers_smell_SmellController_update5_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).update(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellController", "update", Nil,"PUT", """""", Routes.prefix + """smell"""))
        

// @LINE:14
private[this] lazy val controllers_smell_SmellController_delete6_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smell/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_smell_SmellController_delete6_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """smell/$id<[^/]+>"""))
        

// @LINE:17
private[this] lazy val controllers_smell_SmellGroupController_getAll7_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smellgroup"))))
private[this] lazy val controllers_smell_SmellGroupController_getAll7_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellGroupController", "getAll", Nil,"GET", """SmellGroup service""", Routes.prefix + """smellgroup"""))
        

// @LINE:18
private[this] lazy val controllers_smell_SmellGroupController_get8_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smellgroup/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_smell_SmellGroupController_get8_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).get(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellGroupController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """smellgroup/$id<[^/]+>"""))
        

// @LINE:19
private[this] lazy val controllers_smell_SmellGroupController_create9_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smellgroup"))))
private[this] lazy val controllers_smell_SmellGroupController_create9_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellGroupController", "create", Nil,"POST", """""", Routes.prefix + """smellgroup"""))
        

// @LINE:20
private[this] lazy val controllers_smell_SmellGroupController_update10_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smellgroup"))))
private[this] lazy val controllers_smell_SmellGroupController_update10_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).update(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellGroupController", "update", Nil,"PUT", """""", Routes.prefix + """smellgroup"""))
        

// @LINE:21
private[this] lazy val controllers_smell_SmellGroupController_delete11_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smellgroup/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_smell_SmellGroupController_delete11_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellGroupController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """smellgroup/$id<[^/]+>"""))
        

// @LINE:24
private[this] lazy val controllers_property_PropertyController_getAll12_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("property"))))
private[this] lazy val controllers_property_PropertyController_getAll12_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.property.PropertyController", "getAll", Nil,"GET", """Property service""", Routes.prefix + """property"""))
        

// @LINE:25
private[this] lazy val controllers_property_PropertyController_getCategorie13_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("property/categorie/"),DynamicPart("cat", """[^/]+""",true))))
private[this] lazy val controllers_property_PropertyController_getCategorie13_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).getCategorie(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.property.PropertyController", "getCategorie", Seq(classOf[String]),"GET", """""", Routes.prefix + """property/categorie/$cat<[^/]+>"""))
        

// @LINE:26
private[this] lazy val controllers_property_PropertyController_get14_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("property/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_property_PropertyController_get14_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).get(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.property.PropertyController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """property/$id<[^/]+>"""))
        

// @LINE:27
private[this] lazy val controllers_property_PropertyController_create15_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("property"))))
private[this] lazy val controllers_property_PropertyController_create15_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.property.PropertyController", "create", Nil,"POST", """""", Routes.prefix + """property"""))
        

// @LINE:28
private[this] lazy val controllers_property_PropertyController_update16_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("property"))))
private[this] lazy val controllers_property_PropertyController_update16_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).update(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.property.PropertyController", "update", Nil,"PUT", """""", Routes.prefix + """property"""))
        

// @LINE:29
private[this] lazy val controllers_property_PropertyController_delete17_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("property/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_property_PropertyController_delete17_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.property.PropertyController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """property/$id<[^/]+>"""))
        

// @LINE:32
private[this] lazy val controllers_menu_MenuController_getAll18_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("menu"))))
private[this] lazy val controllers_menu_MenuController_getAll18_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.menu.MenuController", "getAll", Nil,"GET", """Menu service""", Routes.prefix + """menu"""))
        

// @LINE:33
private[this] lazy val controllers_menu_MenuController_get19_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("menu/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_menu_MenuController_get19_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).get(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.menu.MenuController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """menu/$id<[^/]+>"""))
        

// @LINE:34
private[this] lazy val controllers_menu_MenuController_create20_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("menu"))))
private[this] lazy val controllers_menu_MenuController_create20_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.menu.MenuController", "create", Nil,"POST", """""", Routes.prefix + """menu"""))
        

// @LINE:35
private[this] lazy val controllers_menu_MenuController_update21_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("menu"))))
private[this] lazy val controllers_menu_MenuController_update21_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).update(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.menu.MenuController", "update", Nil,"PUT", """""", Routes.prefix + """menu"""))
        

// @LINE:36
private[this] lazy val controllers_menu_MenuController_delete22_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("menu/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_menu_MenuController_delete22_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.menu.MenuController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """menu/$id<[^/]+>"""))
        

// @LINE:39
private[this] lazy val controllers_user_UserController_getAll23_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user"))))
private[this] lazy val controllers_user_UserController_getAll23_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "getAll", Nil,"GET", """User service""", Routes.prefix + """user"""))
        

// @LINE:40
private[this] lazy val controllers_user_UserController_get24_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_user_UserController_get24_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).get(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """user/$id<[^/]+>"""))
        

// @LINE:41
private[this] lazy val controllers_user_UserController_create25_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user"))))
private[this] lazy val controllers_user_UserController_create25_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "create", Nil,"POST", """""", Routes.prefix + """user"""))
        

// @LINE:42
private[this] lazy val controllers_user_UserController_update26_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user"))))
private[this] lazy val controllers_user_UserController_update26_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).update(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "update", Nil,"PUT", """""", Routes.prefix + """user"""))
        

// @LINE:43
private[this] lazy val controllers_user_UserController_delete27_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_user_UserController_delete27_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """user/$id<[^/]+>"""))
        

// @LINE:44
private[this] lazy val controllers_user_UserController_changePassword28_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("changepw"))))
private[this] lazy val controllers_user_UserController_changePassword28_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).changePassword(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "changePassword", Nil,"PUT", """""", Routes.prefix + """changepw"""))
        

// @LINE:45
private[this] lazy val controllers_user_UserController_login29_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
private[this] lazy val controllers_user_UserController_login29_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).login(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "login", Nil,"PUT", """""", Routes.prefix + """login"""))
        

// @LINE:46
private[this] lazy val controllers_user_UserController_logout30_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
private[this] lazy val controllers_user_UserController_logout30_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).logout(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
        

// @LINE:47
private[this] lazy val controllers_user_RoleController_getAll31_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("userroles"))))
private[this] lazy val controllers_user_RoleController_getAll31_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.RoleController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.user.RoleController", "getAll", Nil,"GET", """""", Routes.prefix + """userroles"""))
        

// @LINE:50
private[this] lazy val controllers_task_ExecTaskTypeController_getAll32_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("exectasktype"))))
private[this] lazy val controllers_task_ExecTaskTypeController_getAll32_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.task.ExecTaskTypeController", "getAll", Nil,"GET", """ExecTaskType service""", Routes.prefix + """exectasktype"""))
        

// @LINE:51
private[this] lazy val controllers_task_ExecTaskTypeController_getEmptyExecTaskType33_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("exectasktype/empty"))))
private[this] lazy val controllers_task_ExecTaskTypeController_getEmptyExecTaskType33_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).getEmptyExecTaskType(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.task.ExecTaskTypeController", "getEmptyExecTaskType", Nil,"GET", """""", Routes.prefix + """exectasktype/empty"""))
        

// @LINE:52
private[this] lazy val controllers_task_ExecTaskTypeController_get34_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("exectasktype/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_task_ExecTaskTypeController_get34_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).get(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.task.ExecTaskTypeController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """exectasktype/$id<[^/]+>"""))
        

// @LINE:53
private[this] lazy val controllers_task_ExecTaskTypeController_create35_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("exectasktype"))))
private[this] lazy val controllers_task_ExecTaskTypeController_create35_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.task.ExecTaskTypeController", "create", Nil,"POST", """""", Routes.prefix + """exectasktype"""))
        

// @LINE:54
private[this] lazy val controllers_task_ExecTaskTypeController_update36_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("exectasktype"))))
private[this] lazy val controllers_task_ExecTaskTypeController_update36_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).update(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.task.ExecTaskTypeController", "update", Nil,"PUT", """""", Routes.prefix + """exectasktype"""))
        

// @LINE:55
private[this] lazy val controllers_task_ExecTaskTypeController_delete37_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("exectasktype/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_task_ExecTaskTypeController_delete37_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.task.ExecTaskTypeController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """exectasktype/$id<[^/]+>"""))
        

// @LINE:58
private[this] lazy val controllers_status_StatusController_get38_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("status"))))
private[this] lazy val controllers_status_StatusController_get38_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.status.StatusController]).get(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.status.StatusController", "get", Nil,"GET", """Status service""", Routes.prefix + """status"""))
        

// @LINE:61
private[this] lazy val controllers_Assets_at39_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at39_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""@controllers.Application@.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smell""","""@controllers.smell.SmellController@.getAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smell/forcloud""","""@controllers.smell.SmellController@.getCloudSmells()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smell/$id<[^/]+>""","""@controllers.smell.SmellController@.get(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smell""","""@controllers.smell.SmellController@.create()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smell""","""@controllers.smell.SmellController@.update()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smell/$id<[^/]+>""","""@controllers.smell.SmellController@.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smellgroup""","""@controllers.smell.SmellGroupController@.getAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smellgroup/$id<[^/]+>""","""@controllers.smell.SmellGroupController@.get(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smellgroup""","""@controllers.smell.SmellGroupController@.create()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smellgroup""","""@controllers.smell.SmellGroupController@.update()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smellgroup/$id<[^/]+>""","""@controllers.smell.SmellGroupController@.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """property""","""@controllers.property.PropertyController@.getAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """property/categorie/$cat<[^/]+>""","""@controllers.property.PropertyController@.getCategorie(cat:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """property/$id<[^/]+>""","""@controllers.property.PropertyController@.get(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """property""","""@controllers.property.PropertyController@.create()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """property""","""@controllers.property.PropertyController@.update()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """property/$id<[^/]+>""","""@controllers.property.PropertyController@.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """menu""","""@controllers.menu.MenuController@.getAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """menu/$id<[^/]+>""","""@controllers.menu.MenuController@.get(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """menu""","""@controllers.menu.MenuController@.create()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """menu""","""@controllers.menu.MenuController@.update()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """menu/$id<[^/]+>""","""@controllers.menu.MenuController@.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user""","""@controllers.user.UserController@.getAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/$id<[^/]+>""","""@controllers.user.UserController@.get(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user""","""@controllers.user.UserController@.create()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user""","""@controllers.user.UserController@.update()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/$id<[^/]+>""","""@controllers.user.UserController@.delete(id:Long)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """changepw""","""@controllers.user.UserController@.changePassword()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""@controllers.user.UserController@.login()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""@controllers.user.UserController@.logout()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """userroles""","""@controllers.user.RoleController@.getAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """exectasktype""","""@controllers.task.ExecTaskTypeController@.getAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """exectasktype/empty""","""@controllers.task.ExecTaskTypeController@.getEmptyExecTaskType()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """exectasktype/$id<[^/]+>""","""@controllers.task.ExecTaskTypeController@.get(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """exectasktype""","""@controllers.task.ExecTaskTypeController@.create()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """exectasktype""","""@controllers.task.ExecTaskTypeController@.update()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """exectasktype/$id<[^/]+>""","""@controllers.task.ExecTaskTypeController@.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """status""","""@controllers.status.StatusController@.get()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).index())
   }
}
        

// @LINE:9
case controllers_smell_SmellController_getAll1_route(params) => {
   call { 
        controllers_smell_SmellController_getAll1_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).getAll())
   }
}
        

// @LINE:10
case controllers_smell_SmellController_getCloudSmells2_route(params) => {
   call { 
        controllers_smell_SmellController_getCloudSmells2_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).getCloudSmells())
   }
}
        

// @LINE:11
case controllers_smell_SmellController_get3_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_smell_SmellController_get3_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).get(id))
   }
}
        

// @LINE:12
case controllers_smell_SmellController_create4_route(params) => {
   call { 
        controllers_smell_SmellController_create4_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).create())
   }
}
        

// @LINE:13
case controllers_smell_SmellController_update5_route(params) => {
   call { 
        controllers_smell_SmellController_update5_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).update())
   }
}
        

// @LINE:14
case controllers_smell_SmellController_delete6_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_smell_SmellController_delete6_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).delete(id))
   }
}
        

// @LINE:17
case controllers_smell_SmellGroupController_getAll7_route(params) => {
   call { 
        controllers_smell_SmellGroupController_getAll7_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).getAll())
   }
}
        

// @LINE:18
case controllers_smell_SmellGroupController_get8_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_smell_SmellGroupController_get8_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).get(id))
   }
}
        

// @LINE:19
case controllers_smell_SmellGroupController_create9_route(params) => {
   call { 
        controllers_smell_SmellGroupController_create9_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).create())
   }
}
        

// @LINE:20
case controllers_smell_SmellGroupController_update10_route(params) => {
   call { 
        controllers_smell_SmellGroupController_update10_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).update())
   }
}
        

// @LINE:21
case controllers_smell_SmellGroupController_delete11_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_smell_SmellGroupController_delete11_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).delete(id))
   }
}
        

// @LINE:24
case controllers_property_PropertyController_getAll12_route(params) => {
   call { 
        controllers_property_PropertyController_getAll12_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).getAll())
   }
}
        

// @LINE:25
case controllers_property_PropertyController_getCategorie13_route(params) => {
   call(params.fromPath[String]("cat", None)) { (cat) =>
        controllers_property_PropertyController_getCategorie13_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).getCategorie(cat))
   }
}
        

// @LINE:26
case controllers_property_PropertyController_get14_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_property_PropertyController_get14_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).get(id))
   }
}
        

// @LINE:27
case controllers_property_PropertyController_create15_route(params) => {
   call { 
        controllers_property_PropertyController_create15_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).create())
   }
}
        

// @LINE:28
case controllers_property_PropertyController_update16_route(params) => {
   call { 
        controllers_property_PropertyController_update16_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).update())
   }
}
        

// @LINE:29
case controllers_property_PropertyController_delete17_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_property_PropertyController_delete17_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).delete(id))
   }
}
        

// @LINE:32
case controllers_menu_MenuController_getAll18_route(params) => {
   call { 
        controllers_menu_MenuController_getAll18_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).getAll())
   }
}
        

// @LINE:33
case controllers_menu_MenuController_get19_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_menu_MenuController_get19_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).get(id))
   }
}
        

// @LINE:34
case controllers_menu_MenuController_create20_route(params) => {
   call { 
        controllers_menu_MenuController_create20_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).create())
   }
}
        

// @LINE:35
case controllers_menu_MenuController_update21_route(params) => {
   call { 
        controllers_menu_MenuController_update21_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).update())
   }
}
        

// @LINE:36
case controllers_menu_MenuController_delete22_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_menu_MenuController_delete22_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).delete(id))
   }
}
        

// @LINE:39
case controllers_user_UserController_getAll23_route(params) => {
   call { 
        controllers_user_UserController_getAll23_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).getAll())
   }
}
        

// @LINE:40
case controllers_user_UserController_get24_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_user_UserController_get24_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).get(id))
   }
}
        

// @LINE:41
case controllers_user_UserController_create25_route(params) => {
   call { 
        controllers_user_UserController_create25_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).create())
   }
}
        

// @LINE:42
case controllers_user_UserController_update26_route(params) => {
   call { 
        controllers_user_UserController_update26_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).update())
   }
}
        

// @LINE:43
case controllers_user_UserController_delete27_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_user_UserController_delete27_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).delete(id))
   }
}
        

// @LINE:44
case controllers_user_UserController_changePassword28_route(params) => {
   call { 
        controllers_user_UserController_changePassword28_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).changePassword())
   }
}
        

// @LINE:45
case controllers_user_UserController_login29_route(params) => {
   call { 
        controllers_user_UserController_login29_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).login())
   }
}
        

// @LINE:46
case controllers_user_UserController_logout30_route(params) => {
   call { 
        controllers_user_UserController_logout30_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).logout())
   }
}
        

// @LINE:47
case controllers_user_RoleController_getAll31_route(params) => {
   call { 
        controllers_user_RoleController_getAll31_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.RoleController]).getAll())
   }
}
        

// @LINE:50
case controllers_task_ExecTaskTypeController_getAll32_route(params) => {
   call { 
        controllers_task_ExecTaskTypeController_getAll32_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).getAll())
   }
}
        

// @LINE:51
case controllers_task_ExecTaskTypeController_getEmptyExecTaskType33_route(params) => {
   call { 
        controllers_task_ExecTaskTypeController_getEmptyExecTaskType33_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).getEmptyExecTaskType())
   }
}
        

// @LINE:52
case controllers_task_ExecTaskTypeController_get34_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_task_ExecTaskTypeController_get34_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).get(id))
   }
}
        

// @LINE:53
case controllers_task_ExecTaskTypeController_create35_route(params) => {
   call { 
        controllers_task_ExecTaskTypeController_create35_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).create())
   }
}
        

// @LINE:54
case controllers_task_ExecTaskTypeController_update36_route(params) => {
   call { 
        controllers_task_ExecTaskTypeController_update36_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).update())
   }
}
        

// @LINE:55
case controllers_task_ExecTaskTypeController_delete37_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_task_ExecTaskTypeController_delete37_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).delete(id))
   }
}
        

// @LINE:58
case controllers_status_StatusController_get38_route(params) => {
   call { 
        controllers_status_StatusController_get38_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.status.StatusController]).get())
   }
}
        

// @LINE:61
case controllers_Assets_at39_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at39_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     