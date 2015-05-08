// @SOURCE:/Users/cbi/Documents/git-repos/ART/conf/routes
// @HASH:47018cb4a3809d3154cc2eab1c84995e70ceda23
// @DATE:Fri May 08 16:37:54 CEST 2015


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
private[this] lazy val controllers_ar_ArController_getAll1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ar"))))
private[this] lazy val controllers_ar_ArController_getAll1_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArController", "getAll", Nil,"GET", """AR service""", Routes.prefix + """ar"""))
        

// @LINE:10
private[this] lazy val controllers_ar_ArController_get2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ar/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_ar_ArController_get2_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArController]).get(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """ar/$id<[^/]+>"""))
        

// @LINE:11
private[this] lazy val controllers_ar_ArController_create3_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ar"))))
private[this] lazy val controllers_ar_ArController_create3_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArController]).create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArController", "create", Nil,"POST", """""", Routes.prefix + """ar"""))
        

// @LINE:12
private[this] lazy val controllers_ar_ArController_update4_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ar"))))
private[this] lazy val controllers_ar_ArController_update4_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArController]).update(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArController", "update", Nil,"PUT", """""", Routes.prefix + """ar"""))
        

// @LINE:13
private[this] lazy val controllers_ar_ArController_delete5_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ar/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_ar_ArController_delete5_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArController]).delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """ar/$id<[^/]+>"""))
        

// @LINE:17
private[this] lazy val controllers_ar_ArVersionController_getAll6_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("arversion"))))
private[this] lazy val controllers_ar_ArVersionController_getAll6_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArVersionController", "getAll", Nil,"GET", """AR Version service
GET     /arversion/active         @controllers.ar.ArVersionController.getAllActive()""", Routes.prefix + """arversion"""))
        

// @LINE:18
private[this] lazy val controllers_ar_ArVersionController_get7_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("arversion/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_ar_ArVersionController_get7_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).get(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArVersionController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """arversion/$id<[^/]+>"""))
        

// @LINE:19
private[this] lazy val controllers_ar_ArVersionController_create8_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("arversion"))))
private[this] lazy val controllers_ar_ArVersionController_create8_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArVersionController", "create", Nil,"POST", """""", Routes.prefix + """arversion"""))
        

// @LINE:20
private[this] lazy val controllers_ar_ArVersionController_update9_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("arversion"))))
private[this] lazy val controllers_ar_ArVersionController_update9_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).update(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArVersionController", "update", Nil,"PUT", """""", Routes.prefix + """arversion"""))
        

// @LINE:21
private[this] lazy val controllers_ar_ArVersionController_delete10_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("arversion/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_ar_ArVersionController_delete10_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArVersionController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """arversion/$id<[^/]+>"""))
        

// @LINE:24
private[this] lazy val controllers_smell_SmellController_getAll11_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smell"))))
private[this] lazy val controllers_smell_SmellController_getAll11_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellController", "getAll", Nil,"GET", """Smell service""", Routes.prefix + """smell"""))
        

// @LINE:25
private[this] lazy val controllers_smell_SmellController_getCloudSmells12_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smell/forcloud"))))
private[this] lazy val controllers_smell_SmellController_getCloudSmells12_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).getCloudSmells(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellController", "getCloudSmells", Nil,"GET", """""", Routes.prefix + """smell/forcloud"""))
        

// @LINE:26
private[this] lazy val controllers_smell_SmellController_get13_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smell/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_smell_SmellController_get13_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).get(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """smell/$id<[^/]+>"""))
        

// @LINE:27
private[this] lazy val controllers_smell_SmellController_create14_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smell"))))
private[this] lazy val controllers_smell_SmellController_create14_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellController", "create", Nil,"POST", """""", Routes.prefix + """smell"""))
        

// @LINE:28
private[this] lazy val controllers_smell_SmellController_update15_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smell"))))
private[this] lazy val controllers_smell_SmellController_update15_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).update(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellController", "update", Nil,"PUT", """""", Routes.prefix + """smell"""))
        

// @LINE:29
private[this] lazy val controllers_smell_SmellController_delete16_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smell/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_smell_SmellController_delete16_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """smell/$id<[^/]+>"""))
        

// @LINE:32
private[this] lazy val controllers_smell_SmellGroupController_getAll17_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smellgroup"))))
private[this] lazy val controllers_smell_SmellGroupController_getAll17_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellGroupController", "getAll", Nil,"GET", """SmellGroup service""", Routes.prefix + """smellgroup"""))
        

// @LINE:33
private[this] lazy val controllers_smell_SmellGroupController_get18_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smellgroup/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_smell_SmellGroupController_get18_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).get(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellGroupController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """smellgroup/$id<[^/]+>"""))
        

// @LINE:34
private[this] lazy val controllers_smell_SmellGroupController_create19_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smellgroup"))))
private[this] lazy val controllers_smell_SmellGroupController_create19_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellGroupController", "create", Nil,"POST", """""", Routes.prefix + """smellgroup"""))
        

// @LINE:35
private[this] lazy val controllers_smell_SmellGroupController_update20_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smellgroup"))))
private[this] lazy val controllers_smell_SmellGroupController_update20_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).update(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellGroupController", "update", Nil,"PUT", """""", Routes.prefix + """smellgroup"""))
        

// @LINE:36
private[this] lazy val controllers_smell_SmellGroupController_delete21_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smellgroup/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_smell_SmellGroupController_delete21_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellGroupController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """smellgroup/$id<[^/]+>"""))
        

// @LINE:39
private[this] lazy val controllers_discussion_DiscussionController_getAll22_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("discussion"))))
private[this] lazy val controllers_discussion_DiscussionController_getAll22_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.DiscussionController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.DiscussionController", "getAll", Nil,"GET", """Discussion service""", Routes.prefix + """discussion"""))
        

// @LINE:40
private[this] lazy val controllers_discussion_DiscussionController_get23_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("discussion/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_discussion_DiscussionController_get23_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.DiscussionController]).get(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.DiscussionController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """discussion/$id<[^/]+>"""))
        

// @LINE:41
private[this] lazy val controllers_discussion_DiscussionController_create24_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("discussion"))))
private[this] lazy val controllers_discussion_DiscussionController_create24_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.DiscussionController]).create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.DiscussionController", "create", Nil,"POST", """""", Routes.prefix + """discussion"""))
        

// @LINE:42
private[this] lazy val controllers_discussion_DiscussionController_update25_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("discussion"))))
private[this] lazy val controllers_discussion_DiscussionController_update25_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.DiscussionController]).update(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.DiscussionController", "update", Nil,"PUT", """""", Routes.prefix + """discussion"""))
        

// @LINE:43
private[this] lazy val controllers_discussion_DiscussionController_delete26_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("discussion/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_discussion_DiscussionController_delete26_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.DiscussionController]).delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.DiscussionController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """discussion/$id<[^/]+>"""))
        

// @LINE:46
private[this] lazy val controllers_discussion_CommentController_getAll27_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("comment"))))
private[this] lazy val controllers_discussion_CommentController_getAll27_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.CommentController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.CommentController", "getAll", Nil,"GET", """Comment service""", Routes.prefix + """comment"""))
        

// @LINE:47
private[this] lazy val controllers_discussion_CommentController_get28_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("comment/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_discussion_CommentController_get28_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.CommentController]).get(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.CommentController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """comment/$id<[^/]+>"""))
        

// @LINE:48
private[this] lazy val controllers_discussion_LikeController_like29_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("like/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_discussion_LikeController_like29_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.LikeController]).like(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.LikeController", "like", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """like/$id<[^/]+>"""))
        

// @LINE:49
private[this] lazy val controllers_discussion_CommentController_create30_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("comment"))))
private[this] lazy val controllers_discussion_CommentController_create30_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.CommentController]).create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.CommentController", "create", Nil,"POST", """""", Routes.prefix + """comment"""))
        

// @LINE:50
private[this] lazy val controllers_discussion_CommentController_update31_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("comment"))))
private[this] lazy val controllers_discussion_CommentController_update31_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.CommentController]).update(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.CommentController", "update", Nil,"PUT", """""", Routes.prefix + """comment"""))
        

// @LINE:51
private[this] lazy val controllers_discussion_CommentController_delete32_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("comment/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_discussion_CommentController_delete32_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.CommentController]).delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.CommentController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """comment/$id<[^/]+>"""))
        

// @LINE:54
private[this] lazy val controllers_property_PropertyController_getAll33_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("property"))))
private[this] lazy val controllers_property_PropertyController_getAll33_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.property.PropertyController", "getAll", Nil,"GET", """Property service""", Routes.prefix + """property"""))
        

// @LINE:55
private[this] lazy val controllers_property_PropertyController_getCategorie34_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("property/categorie/"),DynamicPart("cat", """[^/]+""",true))))
private[this] lazy val controllers_property_PropertyController_getCategorie34_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).getCategorie(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.property.PropertyController", "getCategorie", Seq(classOf[String]),"GET", """""", Routes.prefix + """property/categorie/$cat<[^/]+>"""))
        

// @LINE:56
private[this] lazy val controllers_property_PropertyController_get35_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("property/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_property_PropertyController_get35_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).get(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.property.PropertyController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """property/$id<[^/]+>"""))
        

// @LINE:57
private[this] lazy val controllers_property_PropertyController_create36_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("property"))))
private[this] lazy val controllers_property_PropertyController_create36_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.property.PropertyController", "create", Nil,"POST", """""", Routes.prefix + """property"""))
        

// @LINE:58
private[this] lazy val controllers_property_PropertyController_update37_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("property"))))
private[this] lazy val controllers_property_PropertyController_update37_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).update(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.property.PropertyController", "update", Nil,"PUT", """""", Routes.prefix + """property"""))
        

// @LINE:59
private[this] lazy val controllers_property_PropertyController_delete38_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("property/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_property_PropertyController_delete38_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.property.PropertyController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """property/$id<[^/]+>"""))
        

// @LINE:62
private[this] lazy val controllers_menu_MenuController_getAll39_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("menu"))))
private[this] lazy val controllers_menu_MenuController_getAll39_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.menu.MenuController", "getAll", Nil,"GET", """Menu service""", Routes.prefix + """menu"""))
        

// @LINE:63
private[this] lazy val controllers_menu_MenuController_get40_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("menu/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_menu_MenuController_get40_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).get(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.menu.MenuController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """menu/$id<[^/]+>"""))
        

// @LINE:64
private[this] lazy val controllers_menu_MenuController_create41_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("menu"))))
private[this] lazy val controllers_menu_MenuController_create41_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.menu.MenuController", "create", Nil,"POST", """""", Routes.prefix + """menu"""))
        

// @LINE:65
private[this] lazy val controllers_menu_MenuController_update42_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("menu"))))
private[this] lazy val controllers_menu_MenuController_update42_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).update(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.menu.MenuController", "update", Nil,"PUT", """""", Routes.prefix + """menu"""))
        

// @LINE:66
private[this] lazy val controllers_menu_MenuController_delete43_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("menu/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_menu_MenuController_delete43_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.menu.MenuController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """menu/$id<[^/]+>"""))
        

// @LINE:69
private[this] lazy val controllers_user_UserController_getAll44_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user"))))
private[this] lazy val controllers_user_UserController_getAll44_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "getAll", Nil,"GET", """User service""", Routes.prefix + """user"""))
        

// @LINE:70
private[this] lazy val controllers_user_UserController_get45_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_user_UserController_get45_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).get(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """user/$id<[^/]+>"""))
        

// @LINE:71
private[this] lazy val controllers_user_UserController_create46_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user"))))
private[this] lazy val controllers_user_UserController_create46_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "create", Nil,"POST", """""", Routes.prefix + """user"""))
        

// @LINE:72
private[this] lazy val controllers_user_UserController_update47_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user"))))
private[this] lazy val controllers_user_UserController_update47_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).update(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "update", Nil,"PUT", """""", Routes.prefix + """user"""))
        

// @LINE:73
private[this] lazy val controllers_user_UserController_delete48_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_user_UserController_delete48_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """user/$id<[^/]+>"""))
        

// @LINE:74
private[this] lazy val controllers_user_UserController_changePassword49_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("changepw"))))
private[this] lazy val controllers_user_UserController_changePassword49_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).changePassword(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "changePassword", Nil,"PUT", """""", Routes.prefix + """changepw"""))
        

// @LINE:75
private[this] lazy val controllers_user_UserController_login50_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
private[this] lazy val controllers_user_UserController_login50_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).login(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "login", Nil,"PUT", """""", Routes.prefix + """login"""))
        

// @LINE:76
private[this] lazy val controllers_user_UserController_logout51_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
private[this] lazy val controllers_user_UserController_logout51_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).logout(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
        

// @LINE:77
private[this] lazy val controllers_user_RoleController_getAll52_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("userroles"))))
private[this] lazy val controllers_user_RoleController_getAll52_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.RoleController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.user.RoleController", "getAll", Nil,"GET", """""", Routes.prefix + """userroles"""))
        

// @LINE:78
private[this] lazy val controllers_user_UserController_uploadAvatar53_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("uploadavatar"))))
private[this] lazy val controllers_user_UserController_uploadAvatar53_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).uploadAvatar(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "uploadAvatar", Nil,"POST", """""", Routes.prefix + """uploadavatar"""))
        

// @LINE:81
private[this] lazy val controllers_task_ExecTaskTypeController_getAll54_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("exectasktype"))))
private[this] lazy val controllers_task_ExecTaskTypeController_getAll54_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.task.ExecTaskTypeController", "getAll", Nil,"GET", """ExecTaskType service""", Routes.prefix + """exectasktype"""))
        

// @LINE:82
private[this] lazy val controllers_task_ExecTaskTypeController_getEmptyExecTaskType55_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("exectasktype/empty"))))
private[this] lazy val controllers_task_ExecTaskTypeController_getEmptyExecTaskType55_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).getEmptyExecTaskType(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.task.ExecTaskTypeController", "getEmptyExecTaskType", Nil,"GET", """""", Routes.prefix + """exectasktype/empty"""))
        

// @LINE:83
private[this] lazy val controllers_task_ExecTaskTypeController_get56_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("exectasktype/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_task_ExecTaskTypeController_get56_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).get(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.task.ExecTaskTypeController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """exectasktype/$id<[^/]+>"""))
        

// @LINE:84
private[this] lazy val controllers_task_ExecTaskTypeController_create57_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("exectasktype"))))
private[this] lazy val controllers_task_ExecTaskTypeController_create57_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.task.ExecTaskTypeController", "create", Nil,"POST", """""", Routes.prefix + """exectasktype"""))
        

// @LINE:85
private[this] lazy val controllers_task_ExecTaskTypeController_update58_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("exectasktype"))))
private[this] lazy val controllers_task_ExecTaskTypeController_update58_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).update(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.task.ExecTaskTypeController", "update", Nil,"PUT", """""", Routes.prefix + """exectasktype"""))
        

// @LINE:86
private[this] lazy val controllers_task_ExecTaskTypeController_delete59_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("exectasktype/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_task_ExecTaskTypeController_delete59_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.task.ExecTaskTypeController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """exectasktype/$id<[^/]+>"""))
        

// @LINE:89
private[this] lazy val controllers_status_StatusController_get60_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("status"))))
private[this] lazy val controllers_status_StatusController_get60_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.status.StatusController]).get(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.status.StatusController", "get", Nil,"GET", """Status service""", Routes.prefix + """status"""))
        

// @LINE:92
private[this] lazy val controllers_Assets_at61_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at61_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""@controllers.Application@.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ar""","""@controllers.ar.ArController@.getAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ar/$id<[^/]+>""","""@controllers.ar.ArController@.get(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ar""","""@controllers.ar.ArController@.create()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ar""","""@controllers.ar.ArController@.update()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ar/$id<[^/]+>""","""@controllers.ar.ArController@.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """arversion""","""@controllers.ar.ArVersionController@.getAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """arversion/$id<[^/]+>""","""@controllers.ar.ArVersionController@.get(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """arversion""","""@controllers.ar.ArVersionController@.create()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """arversion""","""@controllers.ar.ArVersionController@.update()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """arversion/$id<[^/]+>""","""@controllers.ar.ArVersionController@.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smell""","""@controllers.smell.SmellController@.getAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smell/forcloud""","""@controllers.smell.SmellController@.getCloudSmells()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smell/$id<[^/]+>""","""@controllers.smell.SmellController@.get(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smell""","""@controllers.smell.SmellController@.create()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smell""","""@controllers.smell.SmellController@.update()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smell/$id<[^/]+>""","""@controllers.smell.SmellController@.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smellgroup""","""@controllers.smell.SmellGroupController@.getAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smellgroup/$id<[^/]+>""","""@controllers.smell.SmellGroupController@.get(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smellgroup""","""@controllers.smell.SmellGroupController@.create()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smellgroup""","""@controllers.smell.SmellGroupController@.update()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smellgroup/$id<[^/]+>""","""@controllers.smell.SmellGroupController@.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """discussion""","""@controllers.discussion.DiscussionController@.getAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """discussion/$id<[^/]+>""","""@controllers.discussion.DiscussionController@.get(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """discussion""","""@controllers.discussion.DiscussionController@.create()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """discussion""","""@controllers.discussion.DiscussionController@.update()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """discussion/$id<[^/]+>""","""@controllers.discussion.DiscussionController@.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """comment""","""@controllers.discussion.CommentController@.getAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """comment/$id<[^/]+>""","""@controllers.discussion.CommentController@.get(id:Long)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """like/$id<[^/]+>""","""@controllers.discussion.LikeController@.like(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """comment""","""@controllers.discussion.CommentController@.create()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """comment""","""@controllers.discussion.CommentController@.update()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """comment/$id<[^/]+>""","""@controllers.discussion.CommentController@.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """property""","""@controllers.property.PropertyController@.getAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """property/categorie/$cat<[^/]+>""","""@controllers.property.PropertyController@.getCategorie(cat:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """property/$id<[^/]+>""","""@controllers.property.PropertyController@.get(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """property""","""@controllers.property.PropertyController@.create()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """property""","""@controllers.property.PropertyController@.update()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """property/$id<[^/]+>""","""@controllers.property.PropertyController@.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """menu""","""@controllers.menu.MenuController@.getAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """menu/$id<[^/]+>""","""@controllers.menu.MenuController@.get(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """menu""","""@controllers.menu.MenuController@.create()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """menu""","""@controllers.menu.MenuController@.update()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """menu/$id<[^/]+>""","""@controllers.menu.MenuController@.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user""","""@controllers.user.UserController@.getAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/$id<[^/]+>""","""@controllers.user.UserController@.get(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user""","""@controllers.user.UserController@.create()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user""","""@controllers.user.UserController@.update()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/$id<[^/]+>""","""@controllers.user.UserController@.delete(id:Long)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """changepw""","""@controllers.user.UserController@.changePassword()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""@controllers.user.UserController@.login()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""@controllers.user.UserController@.logout()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """userroles""","""@controllers.user.RoleController@.getAll()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """uploadavatar""","""@controllers.user.UserController@.uploadAvatar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """exectasktype""","""@controllers.task.ExecTaskTypeController@.getAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """exectasktype/empty""","""@controllers.task.ExecTaskTypeController@.getEmptyExecTaskType()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """exectasktype/$id<[^/]+>""","""@controllers.task.ExecTaskTypeController@.get(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """exectasktype""","""@controllers.task.ExecTaskTypeController@.create()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """exectasktype""","""@controllers.task.ExecTaskTypeController@.update()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """exectasktype/$id<[^/]+>""","""@controllers.task.ExecTaskTypeController@.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """status""","""@controllers.status.StatusController@.get()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
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
case controllers_ar_ArController_getAll1_route(params) => {
   call { 
        controllers_ar_ArController_getAll1_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArController]).getAll())
   }
}
        

// @LINE:10
case controllers_ar_ArController_get2_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ar_ArController_get2_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArController]).get(id))
   }
}
        

// @LINE:11
case controllers_ar_ArController_create3_route(params) => {
   call { 
        controllers_ar_ArController_create3_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArController]).create())
   }
}
        

// @LINE:12
case controllers_ar_ArController_update4_route(params) => {
   call { 
        controllers_ar_ArController_update4_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArController]).update())
   }
}
        

// @LINE:13
case controllers_ar_ArController_delete5_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ar_ArController_delete5_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArController]).delete(id))
   }
}
        

// @LINE:17
case controllers_ar_ArVersionController_getAll6_route(params) => {
   call { 
        controllers_ar_ArVersionController_getAll6_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).getAll())
   }
}
        

// @LINE:18
case controllers_ar_ArVersionController_get7_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ar_ArVersionController_get7_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).get(id))
   }
}
        

// @LINE:19
case controllers_ar_ArVersionController_create8_route(params) => {
   call { 
        controllers_ar_ArVersionController_create8_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).create())
   }
}
        

// @LINE:20
case controllers_ar_ArVersionController_update9_route(params) => {
   call { 
        controllers_ar_ArVersionController_update9_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).update())
   }
}
        

// @LINE:21
case controllers_ar_ArVersionController_delete10_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ar_ArVersionController_delete10_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).delete(id))
   }
}
        

// @LINE:24
case controllers_smell_SmellController_getAll11_route(params) => {
   call { 
        controllers_smell_SmellController_getAll11_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).getAll())
   }
}
        

// @LINE:25
case controllers_smell_SmellController_getCloudSmells12_route(params) => {
   call { 
        controllers_smell_SmellController_getCloudSmells12_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).getCloudSmells())
   }
}
        

// @LINE:26
case controllers_smell_SmellController_get13_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_smell_SmellController_get13_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).get(id))
   }
}
        

// @LINE:27
case controllers_smell_SmellController_create14_route(params) => {
   call { 
        controllers_smell_SmellController_create14_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).create())
   }
}
        

// @LINE:28
case controllers_smell_SmellController_update15_route(params) => {
   call { 
        controllers_smell_SmellController_update15_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).update())
   }
}
        

// @LINE:29
case controllers_smell_SmellController_delete16_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_smell_SmellController_delete16_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).delete(id))
   }
}
        

// @LINE:32
case controllers_smell_SmellGroupController_getAll17_route(params) => {
   call { 
        controllers_smell_SmellGroupController_getAll17_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).getAll())
   }
}
        

// @LINE:33
case controllers_smell_SmellGroupController_get18_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_smell_SmellGroupController_get18_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).get(id))
   }
}
        

// @LINE:34
case controllers_smell_SmellGroupController_create19_route(params) => {
   call { 
        controllers_smell_SmellGroupController_create19_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).create())
   }
}
        

// @LINE:35
case controllers_smell_SmellGroupController_update20_route(params) => {
   call { 
        controllers_smell_SmellGroupController_update20_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).update())
   }
}
        

// @LINE:36
case controllers_smell_SmellGroupController_delete21_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_smell_SmellGroupController_delete21_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).delete(id))
   }
}
        

// @LINE:39
case controllers_discussion_DiscussionController_getAll22_route(params) => {
   call { 
        controllers_discussion_DiscussionController_getAll22_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.DiscussionController]).getAll())
   }
}
        

// @LINE:40
case controllers_discussion_DiscussionController_get23_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_discussion_DiscussionController_get23_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.DiscussionController]).get(id))
   }
}
        

// @LINE:41
case controllers_discussion_DiscussionController_create24_route(params) => {
   call { 
        controllers_discussion_DiscussionController_create24_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.DiscussionController]).create())
   }
}
        

// @LINE:42
case controllers_discussion_DiscussionController_update25_route(params) => {
   call { 
        controllers_discussion_DiscussionController_update25_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.DiscussionController]).update())
   }
}
        

// @LINE:43
case controllers_discussion_DiscussionController_delete26_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_discussion_DiscussionController_delete26_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.DiscussionController]).delete(id))
   }
}
        

// @LINE:46
case controllers_discussion_CommentController_getAll27_route(params) => {
   call { 
        controllers_discussion_CommentController_getAll27_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.CommentController]).getAll())
   }
}
        

// @LINE:47
case controllers_discussion_CommentController_get28_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_discussion_CommentController_get28_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.CommentController]).get(id))
   }
}
        

// @LINE:48
case controllers_discussion_LikeController_like29_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_discussion_LikeController_like29_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.LikeController]).like(id))
   }
}
        

// @LINE:49
case controllers_discussion_CommentController_create30_route(params) => {
   call { 
        controllers_discussion_CommentController_create30_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.CommentController]).create())
   }
}
        

// @LINE:50
case controllers_discussion_CommentController_update31_route(params) => {
   call { 
        controllers_discussion_CommentController_update31_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.CommentController]).update())
   }
}
        

// @LINE:51
case controllers_discussion_CommentController_delete32_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_discussion_CommentController_delete32_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.CommentController]).delete(id))
   }
}
        

// @LINE:54
case controllers_property_PropertyController_getAll33_route(params) => {
   call { 
        controllers_property_PropertyController_getAll33_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).getAll())
   }
}
        

// @LINE:55
case controllers_property_PropertyController_getCategorie34_route(params) => {
   call(params.fromPath[String]("cat", None)) { (cat) =>
        controllers_property_PropertyController_getCategorie34_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).getCategorie(cat))
   }
}
        

// @LINE:56
case controllers_property_PropertyController_get35_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_property_PropertyController_get35_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).get(id))
   }
}
        

// @LINE:57
case controllers_property_PropertyController_create36_route(params) => {
   call { 
        controllers_property_PropertyController_create36_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).create())
   }
}
        

// @LINE:58
case controllers_property_PropertyController_update37_route(params) => {
   call { 
        controllers_property_PropertyController_update37_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).update())
   }
}
        

// @LINE:59
case controllers_property_PropertyController_delete38_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_property_PropertyController_delete38_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).delete(id))
   }
}
        

// @LINE:62
case controllers_menu_MenuController_getAll39_route(params) => {
   call { 
        controllers_menu_MenuController_getAll39_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).getAll())
   }
}
        

// @LINE:63
case controllers_menu_MenuController_get40_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_menu_MenuController_get40_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).get(id))
   }
}
        

// @LINE:64
case controllers_menu_MenuController_create41_route(params) => {
   call { 
        controllers_menu_MenuController_create41_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).create())
   }
}
        

// @LINE:65
case controllers_menu_MenuController_update42_route(params) => {
   call { 
        controllers_menu_MenuController_update42_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).update())
   }
}
        

// @LINE:66
case controllers_menu_MenuController_delete43_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_menu_MenuController_delete43_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).delete(id))
   }
}
        

// @LINE:69
case controllers_user_UserController_getAll44_route(params) => {
   call { 
        controllers_user_UserController_getAll44_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).getAll())
   }
}
        

// @LINE:70
case controllers_user_UserController_get45_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_user_UserController_get45_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).get(id))
   }
}
        

// @LINE:71
case controllers_user_UserController_create46_route(params) => {
   call { 
        controllers_user_UserController_create46_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).create())
   }
}
        

// @LINE:72
case controllers_user_UserController_update47_route(params) => {
   call { 
        controllers_user_UserController_update47_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).update())
   }
}
        

// @LINE:73
case controllers_user_UserController_delete48_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_user_UserController_delete48_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).delete(id))
   }
}
        

// @LINE:74
case controllers_user_UserController_changePassword49_route(params) => {
   call { 
        controllers_user_UserController_changePassword49_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).changePassword())
   }
}
        

// @LINE:75
case controllers_user_UserController_login50_route(params) => {
   call { 
        controllers_user_UserController_login50_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).login())
   }
}
        

// @LINE:76
case controllers_user_UserController_logout51_route(params) => {
   call { 
        controllers_user_UserController_logout51_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).logout())
   }
}
        

// @LINE:77
case controllers_user_RoleController_getAll52_route(params) => {
   call { 
        controllers_user_RoleController_getAll52_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.RoleController]).getAll())
   }
}
        

// @LINE:78
case controllers_user_UserController_uploadAvatar53_route(params) => {
   call { 
        controllers_user_UserController_uploadAvatar53_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).uploadAvatar())
   }
}
        

// @LINE:81
case controllers_task_ExecTaskTypeController_getAll54_route(params) => {
   call { 
        controllers_task_ExecTaskTypeController_getAll54_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).getAll())
   }
}
        

// @LINE:82
case controllers_task_ExecTaskTypeController_getEmptyExecTaskType55_route(params) => {
   call { 
        controllers_task_ExecTaskTypeController_getEmptyExecTaskType55_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).getEmptyExecTaskType())
   }
}
        

// @LINE:83
case controllers_task_ExecTaskTypeController_get56_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_task_ExecTaskTypeController_get56_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).get(id))
   }
}
        

// @LINE:84
case controllers_task_ExecTaskTypeController_create57_route(params) => {
   call { 
        controllers_task_ExecTaskTypeController_create57_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).create())
   }
}
        

// @LINE:85
case controllers_task_ExecTaskTypeController_update58_route(params) => {
   call { 
        controllers_task_ExecTaskTypeController_update58_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).update())
   }
}
        

// @LINE:86
case controllers_task_ExecTaskTypeController_delete59_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_task_ExecTaskTypeController_delete59_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).delete(id))
   }
}
        

// @LINE:89
case controllers_status_StatusController_get60_route(params) => {
   call { 
        controllers_status_StatusController_get60_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.status.StatusController]).get())
   }
}
        

// @LINE:92
case controllers_Assets_at61_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at61_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     